package models

case class Item(name:String, val code:String, val unitPrice:Double)

case class OrderItem(item: Item, quantity:Int)

case class Order(orderItems:List[OrderItem]) {
  val totalAmount = {
    orderItems.foldLeft(0.0) {
      (total, orderItem) => total + (orderItem.item.unitPrice * orderItem.quantity)
    }
  }
}

case class DiscountItem(desc:String, amount:Double)

case class Bill(order: Order, discountItems: List[DiscountItem], finalAmount: Double)











