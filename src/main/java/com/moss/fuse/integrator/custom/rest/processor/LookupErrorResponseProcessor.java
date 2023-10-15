package com.moss.fuse.integrator.custom.rest.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import com.moss.fuse.integrator.common.model.exception.ErrorResponse;
import com.moss.fuse.integrator.custom.exception.MissingQueryParamException;
import com.moss.fuse.integrator.custom.lookup.constants.MessageConstants;

@Component
public class LookupErrorResponseProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
    	
        MissingQueryParamException exception = exchange.getProperty(Exchange.EXCEPTION_CAUGHT, MissingQueryParamException.class);
        String paramName = exception.getParamName();
        ErrorResponse errorResponse = new ErrorResponse(MessageConstants.MISSING_QUERY_PARAMETER_EXCEPTION+ " " + paramName);
        errorResponse.setMessage(MessageConstants.MISSING_QUERY_PARAMETER_EXCEPTION+ " " + paramName);

        exchange.getMessage().setHeader(Exchange.HTTP_RESPONSE_CODE, 400);
        exchange.getMessage().setBody(errorResponse);
    }
}