package com.sales.module.dao;

import java.util.List;

public interface SelloCityDao<T> {
  void persist(T entity);
  void persist(List<T> entityList);
  void delete(T entity);
  T findByID(Long id);
  List<T> findByIDs(List<Long> ids);
  List<T> findAll();
}