package com.moss.fuse.integrator.custom.rest.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.moss.fuse.integrator.custom.dto.AllLooksUpDto;
import com.moss.fuse.integrator.custom.exception.MissingQueryParamException;
import com.moss.fuse.integrator.custom.lookup.constants.LookupConstants;
import com.moss.fuse.integrator.custom.lookup.service.AidTypeService;
import com.moss.fuse.integrator.custom.lookup.service.ExpensesSourceService;
import com.moss.fuse.integrator.custom.lookup.service.IncomeSourceService;
import com.moss.fuse.integrator.custom.lookup.service.RequestorTypeService;

@Component
public class LookupProcessor implements Processor {

	@Autowired
	private AidTypeService aidTypeService;

	@Autowired
	private ExpensesSourceService expensesSourceService;

	@Autowired
	private IncomeSourceService incomeSourceService;

	@Autowired
	private RequestorTypeService requestorTypeService;

	@Override
	public void process(Exchange exchange) throws Exception {

		String queryParam="lookupKeys";
		String[] lookupKeys = exchange.getIn().getHeader("lookupKeys", String[].class);

		validateLookupKeysParams(lookupKeys, queryParam);
		
		AllLooksUpDto lookupsResponse = new AllLooksUpDto();
		
		for (String lookupKey : lookupKeys) {
			if (lookupKey.equals(LookupConstants.AID_SOURCE_TYPE_QUERY_PARAM))
				lookupsResponse.setAidTypes(aidTypeService.getAidTypeLookup());
			
			if (lookupKey.equals(LookupConstants.INCOME_SOURCE_TYPE_QUERY_PARAM))
				lookupsResponse.setIncomeSourceTypes(incomeSourceService.getIncomeSourceTypeLookup());

			
			if (lookupKey.equals(LookupConstants.EXPENSES_SOURCE_TYPE_QUERY_PARAM))
				lookupsResponse.setExpensesSourceTypes(expensesSourceService.getExpensesSourceTypeLookup());

			if (lookupKey.equals(LookupConstants.REQUESTOR_TYPE_QUERY_PARAM))
				lookupsResponse.setRequestorTypes(requestorTypeService.getRequestorTypeLookup());
		}
		exchange.getMessage().setBody(lookupsResponse);

	}

	private void validateLookupKeysParams(String[] lookupKeys, String queryParam) throws MissingQueryParamException {
		if (lookupKeys == null || lookupKeys.length == 0) 
			throw new MissingQueryParamException(queryParam);
	}

}
