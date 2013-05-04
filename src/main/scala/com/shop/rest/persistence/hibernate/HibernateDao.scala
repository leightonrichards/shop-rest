package com.shop.rest.persistence.hibernate

import org.springframework.beans.factory.annotation.Autowired
import org.hibernate.{Criteria, SessionFactory}
import java.lang.reflect.{Type, ParameterizedType}
import com.shop.rest.persistence.GenericDao
import com.shop.rest.domain.AbstractEntity
import java.util

class HibernateDao[T <: AbstractEntity] extends GenericDao[T]
{
  @Autowired
  var sessionFactory: SessionFactory = null

  def currentSession = sessionFactory.getCurrentSession

  protected def figureOutPersistentClass: Class[T] =
  {
    val parameterizedType: ParameterizedType = (getClass.getGenericSuperclass).asInstanceOf[ParameterizedType]
    val arguments: Array[Type] = parameterizedType.getActualTypeArguments
    arguments(0).asInstanceOf[Class[T]]
  }

  def add(obj: T) {currentSession.save(obj)}

  def get(id: Int):T = currentSession.get(figureOutPersistentClass, id).asInstanceOf[T]

  def update(obj: T) {currentSession.update(obj)}

  def delete(obj: T) {currentSession.delete(obj)}

  def fetchAll(): util.List[T] = criteria.list().asInstanceOf[util.List[T]]

  def criteria: Criteria =    currentSession.createCriteria(figureOutPersistentClass)
}