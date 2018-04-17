package order

import models.CafeMenu._
import models.{Order, OrderItem}

trait OrderGenerator {
  def createOrder(orderedItems : List[(String,Int)]) : Order
}

class CafeOrderGenerator extends OrderGenerator  {

  def createOrder(orderedItems : List[(String,Int)]): Order = {

    val orderItems = orderedItems.map{
      orderedItem => OrderItem(items.filter( _.code == orderedItem._1).head, orderedItem._2)
    }

    Order(orderItems)
  }

}
