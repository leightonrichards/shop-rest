package com.shop.rest.persistence.hibernate

import org.springframework.beans.factory.annotation.Autowired
import java.lang.reflect.{Type, ParameterizedType}
import com.shop.rest.persistence.GenericDao
import scala.collection.convert.WrapAsScala._
import scala.collection.mutable
import com.shop.rest.entity.AbstractEntity
import javax.persistence.{ EntityManager}
import javax.persistence.criteria.{Predicate, Root, CriteriaBuilder, CriteriaQuery}

class HibernateDao[T <: AbstractEntity] extends GenericDao[T]
{
  @Autowired
  val entityManager: EntityManager  = null

  @Autowired
  val jpaBridge: JavaJPABridge[T] = null

  protected def figureOutPersistentClass: Class[T] =
  {
    val parameterizedType: ParameterizedType = (getClass.getGenericSuperclass).asInstanceOf[ParameterizedType]
    val arguments: Array[Type] = parameterizedType.getActualTypeArguments
    arguments(0).asInstanceOf[Class[T]]
  }

  def add(obj: T) {entityManager.persist(obj)}

  def get(id: Int):Option[T] =     Option(entityManager.find(figureOutPersistentClass, id))

  def update(obj: T) {entityManager.persist(obj)}

  def delete(obj: T) {entityManager.remove(obj)}

  def fetchAll(): mutable.Buffer[T] =
  {
    val builder: CriteriaBuilder = entityManager.getCriteriaBuilder
    val criteria: CriteriaQuery[T] = builder.createQuery(figureOutPersistentClass)
    val entity:Root[T] = criteria.from(figureOutPersistentClass)
    criteria.select(entity)

    entityManager.createQuery(criteria).getResultList
  }

  def fetchFor(attributeName: String, attribute: Object): mutable.Buffer[T] =
  {
    jpaBridge.fetchFor(attributeName,attribute,figureOutPersistentClass)
    /*val builder: CriteriaBuilder = entityManager.getCriteriaBuilder
    val criteria: CriteriaQuery[T] = builder.createQuery(figureOutPersistentClass)
    val entity:Root[T] = criteria.from(figureOutPersistentClass)
    val pred: Predicate = entity.get(attributeName).in(attribute)
    criteria.where(pred)
    entityManager.createQuery(criteria).getResultList
    */
  }

}