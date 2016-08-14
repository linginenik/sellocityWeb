package com.sales.module.rest;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sales.module.domain.CustomerInfo;
import com.sales.module.domain.SalesPlay;
import com.sales.module.domain.SalesPlayMappingInfo;
import com.sales.module.service.CustomerService;


@Controller
public class CustomerController  extends AbstractRestController{
	
	 
    @Autowired
    private CustomerService customerService;
    
  


    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

 
    @RequestMapping(value = "/customer/salesplay", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SalesPlay addSalesPlayData(@RequestParam("file") final MultipartFile productImage,@RequestParam("data") final String info) throws JsonParseException, JsonMappingException, IOException {
    	ObjectMapper mapper = new ObjectMapper();

    	CustomerInfo infoData  = mapper.readValue(info,CustomerInfo.class);
    	File uploads = new File("/Users/qzdbxb/projects/uploads/Dell/"+productImage.getOriginalFilename());
    	FileUtils.writeByteArrayToFile(uploads, productImage.getBytes());
    	SalesPlay salesPlay = customerService.createSalesPlay(infoData, "Dell","/Users/qzdbxb/projects/uploads/Dell/"+productImage.getOriginalFilename());
		return salesPlay;
    }
    @RequestMapping(value = "/customer/salesplay/{playId}", method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SalesPlay addPaintPoints(@PathVariable final Integer playId, @RequestBody SalesPlayMappingInfo mappingInfo)  {
    
    	return customerService.addSalesPlayMapping(mappingInfo,playId);
    	
    }
    /*
    @RequestMapping(value = "/customer/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public Customer geCustomer(@PathVariable final int id) {

    	return customerService.getCustomerById(id);
    }    
    @RequestMapping(value = "/searchCustomer/{id}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Customer> searchCustomer(@PathVariable final String id) {

    	return customerService.searchByCustomerNo(id);
    }
    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/customersearch", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public SearchResponse<Customer> searchCustomer(final HttpServletRequest request,   final HttpServletResponse response) {

    	return customerService.searchCustomerResults(request.getParameterMap());
    }
*/
}

