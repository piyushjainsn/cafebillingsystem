package order

import models.{Item, Order, OrderItem}
import org.scalatest.Matchers


class CafeOrderGeneratorTest extends org.scalatest.FunSpec with Matchers{

  describe("CafeOrderGeneratorTest"){

    it("should return empty order"){
      val cafeOrderGenerator = new CafeOrderGenerator()
      cafeOrderGenerator.createOrder(List.empty[(String,Int)]) should be(Order(List.empty[OrderItem]))
    }

    it("should return order with single Item"){
      val input = List(("TM", 1))
      val cafeOrderGenerator = new CafeOrderGenerator()
      cafeOrderGenerator.createOrder(input) should be(Order(List(OrderItem(Item("Masala Tea",  "TM", 10), 1))))
    }

    it("should return order for multiples Items"){
      val input = List(("TM", 2), ("TL", 2))
      val cafeOrderGenerator = new CafeOrderGenerator()
      cafeOrderGenerator.createOrder(input) should be(Order(List(OrderItem(Item("Masala Tea",  "TM", 10), 2), OrderItem(Item("Lemon Tea",  "TL", 15), 2))))
    }

  }

}
