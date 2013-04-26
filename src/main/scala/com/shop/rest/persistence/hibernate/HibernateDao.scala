package com.shop.rest.persistence.hibernate

import org.springframework.beans.factory.annotation.Autowired
import org.hibernate.SessionFactory
import java.lang.reflect.{Type, ParameterizedType}
import com.shop.rest.persistence.AbstractDao

class HibernateDao[T] extends AbstractDao[T]
{
  @Autowired
  var sessionFactory: SessionFactory = null

  def currentSession = sessionFactory.getCurrentSession

  private def figureOutPersistentClass: Class[T] =
  {
    val parameterizedType: ParameterizedType = (getClass.getGenericSuperclass).asInstanceOf[ParameterizedType]
    val arguments: Array[Type] = parameterizedType.getActualTypeArguments
    arguments(0).asInstanceOf[Class[T]]
  }

  def add(obj: T) {currentSession.save(obj)}

  def get(id: Int):T = currentSession.get(figureOutPersistentClass, id).asInstanceOf[T]

  def update(obj: T) {currentSession.update(obj)}

  def delete(obj: T) {currentSession.delete(obj)}
}