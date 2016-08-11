package com.sales.module.service;

import com.sales.module.domain.CustomerInfo;
import com.sales.module.domain.SalesPlay;

public interface CustomerService {

	public SalesPlay createSalesPlay(CustomerInfo customerInfo,String userInfo,String imagePath);
  
}
