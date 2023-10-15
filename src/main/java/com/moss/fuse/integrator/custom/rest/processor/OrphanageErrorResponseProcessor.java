package com.moss.fuse.integrator.custom.rest.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.moss.fuse.integrator.common.model.exception.ErrorResponse;
import com.moss.fuse.integrator.custom.exception.OrphanageNotFoundException;
import com.moss.fuse.integrator.custom.lookup.constants.MessageConstants;

@Component
public class OrphanageErrorResponseProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
    	
        OrphanageNotFoundException exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, OrphanageNotFoundException.class);
        String orphanageId = exception.getFieldName();
        ErrorResponse errorResponse = new ErrorResponse(MessageConstants.MISSING_QUERY_PARAMETER_EXCEPTION+ " " + orphanageId);
        errorResponse.setMessage(MessageConstants.ORPHANAGE_NOT_FOUND_EXCEPTION+ " " + orphanageId);

        exchange.getMessage().setHeader(Exchange.HTTP_RESPONSE_CODE, 400);
        exchange.getMessage().setBody(errorResponse);
    }
}