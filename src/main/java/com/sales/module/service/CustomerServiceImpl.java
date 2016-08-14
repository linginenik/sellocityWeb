package com.sales.module.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sales.module.dao.ClientDAO;
import com.sales.module.dao.CustomerDAO;
import com.sales.module.dao.SalesPlayDAO;
import com.sales.module.dao.SalesPlayMappingDAO;
import com.sales.module.dao.StatusDAO;
import com.sales.module.dao.UserDAO;
import com.sales.module.domain.Clients;
import com.sales.module.domain.Customer;
import com.sales.module.domain.CustomerInfo;
import com.sales.module.domain.SalesPlay;
import com.sales.module.domain.SalesPlayMapping;
import com.sales.module.domain.SalesPlayMappingInfo;
import com.sales.module.domain.Status;
import com.sales.module.domain.User;

@Service
public class CustomerServiceImpl implements CustomerService {


	
	@Autowired
	StatusDAO<Status> statusDao;
	
	@Autowired
	UserDAO<User> userDao;
	
	@Autowired
	ClientDAO<Clients> clientDao;

	@Autowired
	CustomerDAO<Customer> customerDao;
	
//	@Autowired
//	SalesPersonDAO<SalesPerson> salesPerson;
//	
	@Autowired
	SalesPlayDAO<SalesPlay> salesPlayDao;
	
	@Autowired
	SalesPlayMappingDAO<SalesPlayMapping> salesPlayMappingDao;
	
//	public CustomerProducts add(CustomerProducts product){
//		return customerDAO.add(product);
//		
//	}
	public Status createStatus(){
		Status status = new Status();
		status.setDescription("Active");
		return statusDao.persist(status);
		
	}
	public User createUser(){
		User user = new User();
		user.setuName("test");
		user.setPassword("password");
		user.setStatus(createStatus());
		return userDao.persist(user);
		
	}	
	public Customer createCustomer(){
		Customer customer = new Customer();
		customer.setName("Dell");
		customer.setStatus(createStatus());
		return customerDao.persist(customer);
		
	}	
	public SalesPlay createSalesPlay(CustomerInfo customerInfo,String userInfo,String imagePath){
		
		//List<SalesPlayMapping> salesPlayMappingList = new ArrayList<SalesPlayMapping>();
		Clients clients = new Clients();
		Customer cust = createCustomer();
		clients.setCustomer(cust);
		clients.setLogo(imagePath);
		clients.setName(customerInfo.getClientName());
		clients = clientDao.persist(clients);

		
		SalesPlay salesPlay =new SalesPlay();
		salesPlay.setCustomer(cust);
		salesPlay.setUser(createUser());
		salesPlay.setClients(clients);
		salesPlay.setClientContactName(customerInfo.getCustomerClientContact());
		salesPlay.setClientContactEmail(customerInfo.getCustomerClientEmail());
		salesPlay.setSalesPlayName(customerInfo.getSalesPlayName());
		salesPlay = salesPlayDao.persist(salesPlay);
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
		return salesPlay;	
		
	}
	public SalesPlay addSalesPlayMapping(SalesPlayMappingInfo mappingInfo,Integer salesPlayId){
		
		SalesPlay salesPlay = salesPlayDao.findBySalesPlayId(salesPlayId);
		List<SalesPlayMapping> mappingList = new ArrayList<SalesPlayMapping>();
		if(mappingInfo.getPainPoint1() != null){
			mappingList.add(createSalesMapping(mappingInfo.getPainPoint1(), salesPlay));
		}
		if(mappingInfo.getPainPoint2() != null){
			mappingList.add(createSalesMapping(mappingInfo.getPainPoint2(), salesPlay));
		}
		if(mappingInfo.getPainPoint3() != null){
			mappingList.add(createSalesMapping(mappingInfo.getPainPoint3(), salesPlay));
		}
		if(mappingInfo.getPainPoint4() != null){
			mappingList.add(createSalesMapping(mappingInfo.getPainPoint4(), salesPlay));
		}
		salesPlay.setSalesPlayMapping(mappingList);
		return salesPlay;
	}
	private SalesPlayMapping createSalesMapping(String  paingPoint, SalesPlay salesPlay) {
		SalesPlayMapping salesPlayMapping  = new SalesPlayMapping();
		salesPlayMapping.setPainPoint(paingPoint);
		salesPlayMapping.setSalesPlay(salesPlay);
		salesPlayMapping.setStatus(salesPlay.getStatus());
		salesPlayMappingDao.persist(salesPlayMapping);
		return salesPlayMapping;
	}
 
}
