package com.shop.rest.persistence.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: leighton
 * Date: 19/05/13
 * Time: 18:12
 * To change this template use File | Settings | File Templates.
 */
@Repository
public class JavaJPABridge<T>
{
  @Autowired
  EntityManager entityManager;

  public List<T> fetchFor(String attributeName, Object attribute, Class clazz)
  {
    CriteriaBuilder builder = entityManager.getCriteriaBuilder();
    CriteriaQuery<T> criteria = builder.createQuery(clazz);
    Root<T> entity = criteria.from(clazz);
    Predicate pred = entity.get(attributeName).in(attribute);
    criteria.where(pred);
    return entityManager.createQuery(criteria).getResultList();
  }
}
