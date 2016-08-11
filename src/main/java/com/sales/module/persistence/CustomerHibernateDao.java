package com.sales.module.persistence;


import org.springframework.stereotype.Repository;

import com.sales.module.dao.CustomerDAO;
import com.sales.module.domain.Customer;

@Repository
public class CustomerHibernateDao extends SelloCityHibernateDao<Customer> implements CustomerDAO<Customer>{
 

  public Class<Customer> getPersistentClass() {
    return Customer.class;
  }

 
 
}
