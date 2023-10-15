package com.moss.fuse.integrator.custom.rest;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import com.moss.fuse.integrator.custom.exception.AdministrationNotFoundException;
import com.moss.fuse.integrator.custom.rest.processor.AdministrationErrorResponseProcessor;
import com.moss.fuse.integrator.custom.service.AdmininstrationService;

@Component
public class AdministrationRest extends RouteBuilder {

	@Autowired
	private AdmininstrationService admininstrationService;

	@Autowired
	private AdministrationErrorResponseProcessor adminErrorResponseProcessor;

	@Override
	public void configure() throws Exception {
		restConfiguration().component("servlet").host("localhost").port(8080)
		        .enableCORS(true)
				.corsHeaderProperty("Access-Control-Allow-Origin", "*")
				.corsHeaderProperty("Access-Control-Allow-Methods", "*")
				.corsHeaderProperty("Access-Control-Allow-Headers", "*");

		rest("/api/v1/administrations").consumes(MediaType.APPLICATION_JSON_VALUE)
				.produces(MediaType.APPLICATION_JSON_VALUE).get("/{administrationId}/orphanages").route()
				.onException(AdministrationNotFoundException.class).handled(true).process(adminErrorResponseProcessor)
				.marshal().json(JsonLibrary.Jackson).end().process(exchange -> {
					long administrationId = exchange.getIn().getHeader("administrationId", Long.class);
					exchange.getMessage().setBody(admininstrationService.getAdminOrphanages(administrationId));
				}).marshal().json(JsonLibrary.Jackson).endRest();
	}
}
