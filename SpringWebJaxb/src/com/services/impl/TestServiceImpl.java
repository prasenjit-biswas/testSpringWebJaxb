package com.services.impl;

import org.springframework.stereotype.Component;

import com.services.TestService;
import com.services.transferobject.ItemXmlTO;

@Component
public class TestServiceImpl implements TestService{

	@Override
	public ItemXmlTO getItemXml(String testid, String qid) throws Exception {
		ItemXmlTO itemXmlTO = new ItemXmlTO();
		itemXmlTO.setTestid(testid);
		itemXmlTO.setQuestionid(qid);
		itemXmlTO.setQuestionType("CA");
		return itemXmlTO;
	}

}
