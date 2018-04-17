package discount

import models.{DiscountItem, Item, Order, OrderItem}
import org.scalatest.{FunSpec, Matchers}

class CafeDiscountCalculatorTest extends FunSpec with Matchers{

  describe("CafeDiscountCalculatorTest"){

    it("should generate empty discount"){
      val cafeDiscountCalculator = new CafeDiscountCalculator(List.empty[Discount])
      val emptyOrder = Order(List.empty[OrderItem])
      cafeDiscountCalculator.calculateDiscount(emptyOrder) should be(List.empty[DiscountItem])
    }

    it("should generate 10% discount"){
      val cafeDiscountCalculator = new CafeDiscountCalculator(List(TenPercentDiscountUnder200))
      val multiItemOrder = Order(List(OrderItem(Item("Masala Tea",  "TM", 10), 2), OrderItem(Item("Lemon Tea",  "TL", 15), 2)))
      cafeDiscountCalculator.calculateDiscount(multiItemOrder) should be(List(DiscountItem("Discount - 10%", 5.0)))
    }

  }

}
