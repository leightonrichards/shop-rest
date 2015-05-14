package com.shop.rest.service

import com.shop.rest.domain.Product
import com.shop.rest.persistence.ProductDAO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 * Created with IntelliJ IDEA.
 * User: leighton
 * Date: 04/05/13
 * Time: 17:22
 * To change this template use File | Settings | File Templates.
 */
@Service
class ProductServiceImpl() extends GenericServiceImpl[Product] with ProductService
{
  @Autowired val dao: ProductDAO = null
}