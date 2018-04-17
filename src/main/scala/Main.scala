import billing.{CafeBillCalculator, TextBillPrinter}
import discount.{CafeDiscountCalculator, TenPercentDiscountUnder200, TwentyPercentDiscountOver200}
import order.CafeOrderGenerator

object Main {

  def main(args:Array[String]) = {

    println("Cafe Billing System")

    val orderedItems = List(("TM", 2), ("TL", 2))

    val orderGenerator = new CafeOrderGenerator
    val discountCalculator = new CafeDiscountCalculator(List(TenPercentDiscountUnder200, TwentyPercentDiscountOver200))
    val billCalculator = new CafeBillCalculator(discountCalculator)
    val billPrinter = new TextBillPrinter

    billPrinter.print(
      billCalculator.generateBill(
        orderGenerator.createOrder(orderedItems)))

  }

}
