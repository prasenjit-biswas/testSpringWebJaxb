package com.services;

import com.services.transferobject.ItemXmlTO;

public interface TestService {
	public ItemXmlTO getItemXml(String testid, String qid) throws Exception;
}
