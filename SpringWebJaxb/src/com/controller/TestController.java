package com.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.services.TestService;
import com.services.transferobject.ItemXmlTO;

@Controller
@RequestMapping("/push")
public class TestController {

	@Autowired
	TestService testService;

	@RequestMapping(value = "/pullXML/{testId}/{qid}" , method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ItemXmlTO> getItemXml(@PathVariable String testId, @PathVariable String qid){
		ItemXmlTO itemXmlTO = null;
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Type", "application/json;charset=utf-8");
		try{
			if(StringUtils.isNotBlank(testId) && StringUtils.isNotBlank(qid) && !"qid".equals(qid)){
				itemXmlTO = testService.getItemXml(testId, qid);
				if(itemXmlTO == null){
					throw new Exception("itemXmlTO is getting generated As NULL");
				}
			}else{
				throw new Exception("Testid or questionid is coming Null or Empty, Testid : "+testId+", questionid : "+qid);
			}
		}catch(Exception ex){
			System.out.println(" Exception while getItemXml ....");
			ex.printStackTrace();
			itemXmlTO = new ItemXmlTO();
			itemXmlTO.setMessage("Testid or questionid is coming Null or Empty, Testid : "+testId+", questionid : "+qid);
			return new ResponseEntity<ItemXmlTO>(itemXmlTO, headers, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<ItemXmlTO>(itemXmlTO, headers, HttpStatus.OK);
	}

}
