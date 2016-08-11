package com.sales.module.persistence;


import org.springframework.stereotype.Repository;

import com.sales.module.dao.SalesPlayMappingDAO;
import com.sales.module.domain.SalesPlayMapping;

@Repository
public class SalesPlayMappingHibernateDao extends SelloCityHibernateDao<SalesPlayMapping> implements SalesPlayMappingDAO<SalesPlayMapping>{
 

  public Class<SalesPlayMapping> getPersistentClass() {
    return SalesPlayMapping.class;
  }

 
 
}
