package com.sales.module.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.module.dao.ClientDAO;
import com.sales.module.dao.SalesPlayDAO;
import com.sales.module.dao.SalesPlayMappingDAO;
import com.sales.module.domain.Clients;
import com.sales.module.domain.CustomerInfo;
import com.sales.module.domain.SalesPlay;
import com.sales.module.domain.SalesPlayMapping;

@Service
public class CustomerServiceImpl implements CustomerService {


	

	
	@Autowired
	ClientDAO<Clients> clientDao;

//	@Autowired
//	CustomerDAO<Customer> customerDao;
	
//	@Autowired
//	SalesPersonDAO<SalesPerson> salesPerson;
//	
	@Autowired
	SalesPlayDAO<SalesPlay> salesPlay;
	
	@Autowired
	SalesPlayMappingDAO<SalesPlayMapping> salesPlayMapping;
	
//	public CustomerProducts add(CustomerProducts product){
//		return customerDAO.add(product);
//		
//	}
	
	public SalesPlay createSalesPlay(CustomerInfo customerInfo,String userInfo,String imagePath){
		List<SalesPlayMapping> salesPlayMappingList = new ArrayList<SalesPlayMapping>();
//		Customer customer = customerDao.find(userInfo);
//		Clients clients = new Clients();
//		clients.setCustomer(customer);
//		clients.setLogo(imagePath);
//		clients.setName(customerInfo.getClientName());
//		clients = customerDAO.save(clients);
//		
//		SalesPerson person = new SalesPerson();
//		person.setCustomer(customer);
//		person = customerDAO.save(person);
//		
//		SalesPlay salesPlay =new SalesPlay();
//		salesPlay.setSalesPerson(person);
//		salesPlay.setClients(clients);
//		salesPlay.setClientContactName(customerInfo.getCustomerClientContact());
//		salesPlay.setClientContactEmail(customerInfo.getCustomerClientEmail());
//		salesPlay = customerDAO.save(salesPlay);
//		
//		if(customerInfo.getPainPoint1() != null){
//			SalesPlayMapping mapping = new SalesPlayMapping();
//			mapping.setSalesPlay(salesPlay);
//			mapping.setPainPoint(customerInfo.getPainPoint1() );
//			mapping = customerDAO.save(mapping);
//			salesPlayMappingList.add(mapping);
//		}
//		if(customerInfo.getPainPoint2() != null){
//			SalesPlayMapping mapping = new SalesPlayMapping();
//			mapping.setSalesPlay(salesPlay);
//			mapping.setPainPoint(customerInfo.getPainPoint2() );
//			mapping = customerDAO.save(mapping);
//			salesPlayMappingList.add(mapping);
//		}
//		if(customerInfo.getPainPoint3() != null){
//			SalesPlayMapping mapping = new SalesPlayMapping();
//			mapping.setSalesPlay(salesPlay);
//			mapping.setPainPoint(customerInfo.getPainPoint3() );
//			mapping = customerDAO.save(mapping);
//			salesPlayMappingList.add(mapping);
//		}
//		if(customerInfo.getPainPoint4() != null){
//			SalesPlayMapping mapping = new SalesPlayMapping();
//			mapping.setSalesPlay(salesPlay);
//			mapping.setPainPoint(customerInfo.getPainPoint4() );
//			mapping = customerDAO.save(mapping);
//			salesPlayMappingList.add(mapping);
//		}
		//salesPlay.setSalesPlayMapping(salesPlayMappingList);
		return null;	
		
		
		
		
		
		
		
	}

 
}
