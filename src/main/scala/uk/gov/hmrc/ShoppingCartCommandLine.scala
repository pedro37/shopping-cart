package uk.gov.hmrc.shopping.shoppingcart

import uk.gov.hmrc.shopping.items.{Item, ValidItems}
import uk.gov.hmrc.shopping.offers.SpecialOffers
import scala.io.StdIn
import scala.util.{Success, Failure, Try}

/**
  * Created by peterwhitehead on 20/11/2016.
  */
object ShoppingCartCommandLine {
  def main(args: Array[String]) = {
    val commandLine = StdIn.readLine("Please enter list of items in the shopping cart, in a comma delimited format. e.g. apple, orange - ")

    Try({
      val standardCart = new Parser().parse(commandLine).foldLeft(StandardCart()) { (standardCart, item) =>
        standardCart.addItemToCart(item)
      }
      SpecialOffers(standardCart).cartTotal
    }) match {
      case Success(total) => println(s"Your shopping cart total is £$total")
      case Failure(e) => println(e.getMessage)
    }
  }
}

class Parser {
  def parse(values: String) =
    values.split(",").foldLeft(List.empty[Item]) { (items, itemName) =>
      ValidItems.items.find(_.name == itemName.trim.toLowerCase) match {
        case Some(v) => v :: items
        case _ =>
          println(s"Not a valid item please enter one of the following apple or orange.")
          items
      }
    }
}
