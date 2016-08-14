package com.sales.module.persistence;


import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.sales.module.dao.SalesPlayDAO;
import com.sales.module.domain.SalesPlay;

@Repository
public class SalesPlayHibernateDao extends SelloCityHibernateDao<SalesPlay> implements SalesPlayDAO<SalesPlay>{
 
	public SalesPlay findBySalesPlayId(Integer spIdValue){
		List<SalesPlay> playList= findByCriteria(Restrictions.eq("spId",spIdValue));
		if(playList != null && playList.size() >=0){
			return playList.get(0);
		}
		return null;
	}

  public Class<SalesPlay> getPersistentClass() {
    return SalesPlay.class;
  }

 
 
}
