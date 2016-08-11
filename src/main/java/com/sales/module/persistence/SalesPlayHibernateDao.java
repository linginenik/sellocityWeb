package com.sales.module.persistence;


import org.springframework.stereotype.Repository;

import com.sales.module.dao.SalesPlayDAO;
import com.sales.module.domain.SalesPlay;

@Repository
public class SalesPlayHibernateDao extends SelloCityHibernateDao<SalesPlay> implements SalesPlayDAO<SalesPlay>{
 

  public Class<SalesPlay> getPersistentClass() {
    return SalesPlay.class;
  }

 
 
}
