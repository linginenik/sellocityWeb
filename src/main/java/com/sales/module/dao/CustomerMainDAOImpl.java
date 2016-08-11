package com.sales.module.dao;

import org.springframework.stereotype.Component;

import com.sales.module.domain.Clients;




@Component
public class CustomerMainDAOImpl implements CustomerMainDAO{

//    @Autowired(required=true)
//    private SessionFactory sessionFactory;
//    public CustomerProducts add(CustomerProducts cust){
//        Session session = sessionFactory.openSession();
//        session.saveOrUpdate(cust);
//        session.close();
//        return cust;
//    }


    public void removeCustomer(int custId){
    	
    }
    public Clients getClient(String name){
//    	Session session = sessionFactory.openSession();
//    	session.g
    	return null;
    }
  
    
    //New Data.....
    

  /*  public Customer getCustomer(String name){
    	Session session = sessionFactory.openSession();
    	 Criteria criteria = session.createCriteria(Customer.class);
    	 criteria.add(Restrictions.eq("name", name));
    	 List<Customer> customer = criteria.list();
    	return customer.get(0);
    }

	@Override
	public CustomerProducts getCustomerProducts(String custId) {
		// TODO Auto-generated method stub
		return null;
	}
	 public Clients save(Clients client){
		  Session session = sessionFactory.openSession();
		  session.saveOrUpdate(client);
	        session.close();
	        return client;
	 }
	 public SalesPerson save(SalesPerson salesPerson){
		  Session session = sessionFactory.openSession();
		  session.saveOrUpdate(salesPerson);
	        session.close();
	        return salesPerson;
	 }
	 public SalesPlay save(SalesPlay salesPlay){
		  Session session = sessionFactory.openSession();
		  session.saveOrUpdate(salesPlay);
	        session.close();
	        return salesPlay;
	 }
	 public SalesPlayMapping save(SalesPlayMapping salesPlayMapping){
		  Session session = sessionFactory.openSession();
		  session.saveOrUpdate(salesPlayMapping);
	        session.close();
	        return salesPlayMapping;
	 }*/
	 
	 
}
