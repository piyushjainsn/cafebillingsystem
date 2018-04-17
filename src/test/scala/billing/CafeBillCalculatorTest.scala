package billing

import discount.{CafeDiscountCalculator, TenPercentDiscountUnder200, TwentyPercentDiscountOver200}
import models._
import org.scalatest.{FunSpec, Matchers}

class CafeBillCalculatorTest extends FunSpec with Matchers{

  describe("CafeBillCalculatorTest") {

    val discounts = List(TenPercentDiscountUnder200, TwentyPercentDiscountOver200)
    val CafeBillCalculator = new CafeBillCalculator(new CafeDiscountCalculator(discounts))

    it("should generate empty bill"){
      val emptyOrder = Order(List.empty[OrderItem])
      val noDiscounts = List.empty[DiscountItem]
      CafeBillCalculator.generateBill(emptyOrder) should be(Bill(emptyOrder, List.empty[DiscountItem], 0.0) )
    }

    it("should generate bill for single item with discounts"){
      val singleItemOrder = Order(List(OrderItem(Item("Masala Tea",  "TM", 10), 2) ) )
      val discounts = List(DiscountItem("Discount - 10%",2.0))
      CafeBillCalculator.generateBill(singleItemOrder) should be(Bill(singleItemOrder, discounts, 18.0) )
    }

    it("should generate bill on multi item"){
      val multiItemOrder = Order(List(OrderItem(Item("Masala Tea",  "TM", 10), 2), OrderItem(Item("Lemon Tea",  "TL", 15), 2)))
      val discounts = List(DiscountItem("Discount - 10%",5.0))
      CafeBillCalculator.generateBill(multiItemOrder) should be(Bill(multiItemOrder, discounts, 45.0) )
    }

  }

}
