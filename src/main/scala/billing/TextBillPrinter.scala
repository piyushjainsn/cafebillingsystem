package billing

import models.{Bill, DiscountItem, OrderItem}


trait BillPrinter {
  def print(bill:Bill)
}

class TextBillPrinter extends BillPrinter{

  override def print(bill: Bill) = {
    val billContent = s"""
      |Item Name                Count          Price
      |${itemRows(bill.order.orderItems)}
      |Total                                   ${bill.order.totalAmount}
      |${discountRows(bill.discountItems)}
      |Final Amount                            ${bill.finalAmount}
    """.stripMargin

    println(billContent.toString)
  }

  private def itemRows(orderItems: List[OrderItem]) = {
    orderItems.map{ orderItem =>
      s"${orderItem.item.name}                  ${orderItem.quantity}           ${orderItem.item.unitPrice * orderItem.quantity}"
    }.mkString("\n")
  }

  def discountRows(discountItems: List[DiscountItem]) = {
    discountItems.map{ discountItem =>
      s"${discountItem.desc}                            ${discountItem.amount}"
    }.mkString("\n")
  }

}
