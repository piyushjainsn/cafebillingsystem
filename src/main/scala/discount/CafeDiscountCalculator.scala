package discount

import models.{DiscountItem, Order}

trait DiscountCalculator {
  def calculateDiscount(order:Order) : List[DiscountItem]
}

class CafeDiscountCalculator(discounts: List[Discount]) extends DiscountCalculator{

  def calculateDiscount(order:Order) : List[DiscountItem] = {
    discounts.map(_.apply(order)).filter(_.amount > 0)
  }

}
