package billing

import discount.DiscountCalculator
import models.{Bill, DiscountItem, Order}

trait BillCalculator {
  def generateBill(order:Order) : Bill
}

class CafeBillCalculator(discountCalculator: DiscountCalculator) extends BillCalculator {

  override def generateBill(order: Order): Bill = {
    val discounts = discountCalculator.calculateDiscount(order)
    val totalDiscount = discounts.map(_.amount).sum
    val totalBillAmount = order.totalAmount - (totalDiscount/5)

    Bill(order, discounts, totalBillAmount )
  }

}
