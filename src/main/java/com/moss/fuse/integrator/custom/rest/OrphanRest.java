package com.moss.fuse.integrator.custom.rest;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.moss.fuse.integrator.custom.exception.OrphanageNotFoundException;
import com.moss.fuse.integrator.custom.rest.processor.OrphanErrorResponseProcessor;
import com.moss.fuse.integrator.custom.service.OrphanService;

@Component
public class OrphanRest extends RouteBuilder {

	@Autowired
	private OrphanService orphanService;

	@Autowired
	private OrphanErrorResponseProcessor orphanErrorResponseProcessor;

	@Override
	public void configure() throws Exception {
		restConfiguration().component("servlet").host("localhost").port(8080)
		        .enableCORS(true)
				.corsHeaderProperty("Access-Control-Allow-Origin", "*")
				.corsHeaderProperty("Access-Control-Allow-Methods", "*")
				.corsHeaderProperty("Access-Control-Allow-Headers", "*");

		rest("/api/v1/orphans").consumes(MediaType.APPLICATION_JSON_VALUE).produces(MediaType.APPLICATION_JSON_VALUE)
				.get("/{orphanId}").route().onException(OrphanageNotFoundException.class).handled(true)
				.process(orphanErrorResponseProcessor).marshal().json(JsonLibrary.Jackson).end().process(exchange -> {
					long orphanId = exchange.getIn().getHeader("orphanId", Long.class);
					exchange.getMessage().setBody(orphanService.getOrphan(orphanId));
				}).marshal().json(JsonLibrary.Jackson).endRest();

	}
}
