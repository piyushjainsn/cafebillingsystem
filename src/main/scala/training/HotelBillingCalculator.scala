package training


object HotelBillingCalculator {

  case class Dish(name:String, price:Double)

  case class Bill(dishes:List[Dish], totalAmount:Double)

  trait Printer{
    def print(bill:Bill)
    val totalAmountLabel = "Total amount:"
    def itemDescriptions(bill:Bill) = {
      bill.dishes.map(item => item.name + " - " + item.price).mkString("\n")
    }
  }

  object TextPrinter extends Printer{
    def print(bill:Bill) = {
      s"""
         |Bill
         |${itemDescriptions(bill)}
         |
         |$totalAmountLabel ${bill.totalAmount}
         |
         """.stripMargin
    }
  }

  object HtmlPrinter extends Printer{
    def print(bill:Bill) = {
      s"""
         |<title>Bill</title>
         |${itemDescriptions(bill)}
         |
         |<b>$totalAmountLabel ${bill.totalAmount} </b>
         |
         """.stripMargin
    }
  }

  def main(args: Array[String]) {

    val orderedItems: List[Dish] = createOrder
    val bill: Bill = createBill(orderedItems)
    printBill(bill, TextPrinter)

  }

  def printBill(bill:Bill, printer: Printer): Unit = {
    println(printer.print(bill))
  }

  def createBill(orderedItems: List[Dish]): Bill = {
    val allItemsPrice = orderedItems.map(item => item.price)
    val itemTotal = allItemsPrice.sum

    Bill(orderedItems, itemTotal)
  }

  def createOrder: List[Dish] = {
    val biryani = Dish("biryani", 100)
    val pizza = Dish("pizza", 200)
    val burger = Dish("burger", 200)

    List(biryani, pizza, burger)
  }

}



