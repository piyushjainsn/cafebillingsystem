package discount

import models.{DiscountItem, Order}

trait Discount {
  def apply(order:Order) : DiscountItem
}

object TenPercentDiscountUnder200 extends Discount {
  override def apply(order: Order): DiscountItem = {
    DiscountItem("Discount - 10%", (order.totalAmount*0.1) )
  }
}

object TwentyPercentDiscountOver200 extends Discount {
  override def apply(order: Order): DiscountItem = {
    val discountAmount = if (order.totalAmount > 200) ( (order.totalAmount - 200) *0.2) else 0
    DiscountItem("Discount - 20% over 200", discountAmount)
  }
}