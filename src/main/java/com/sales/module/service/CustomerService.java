package com.sales.module.service;

import com.sales.module.domain.CustomerInfo;
import com.sales.module.domain.SalesPlay;
import com.sales.module.domain.SalesPlayMappingInfo;

public interface CustomerService {

	public SalesPlay createSalesPlay(CustomerInfo customerInfo,String userInfo,String imagePath);
	
	public SalesPlay addSalesPlayMapping(SalesPlayMappingInfo mappingInfo,Integer salesPlayId);
  
}
