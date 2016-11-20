package uk.gov.hmrc

import java.io.{ByteArrayOutputStream, ByteArrayInputStream}

import org.specs2.mutable.Specification
import uk.gov.hmrc.shopping.items.{Apple, Orange, Item}
import uk.gov.hmrc.shopping.shoppingcart.{ShoppingCartCommandLine, Parser}


/**
  * Created by peterwhitehead on 20/11/2016.
  */
class ShoppingCartCommandLineSpec extends Specification {
  "check parser splits csv string" should {
    "parsing no csv values" in {
      val parser = new Parser()
      parser.parse("") mustEqual List.empty[Item]
    }

    "parsing csv values" in {
      val parser = new Parser()
      parser.parse("apple, orange, apple") mustEqual List(Apple, Orange, Apple)
    }
  }

  "enter values from command line" should {
    "read empty command line should " in {
      val in = new ByteArrayInputStream((" ").getBytes)
      val out = new ByteArrayOutputStream()

      Console.withIn(in) {
        Console.withOut(out) {
          ShoppingCartCommandLine.main(null)
          out.toString must contain("Your shopping cart total is £0")
        }
      }
    }

    "read apple, apple, orange, apple would be 2.05 knock off free apple 1.45" in {
      val in = new ByteArrayInputStream(("apple,apple,orange,apple").getBytes)
      val out = new ByteArrayOutputStream()

      Console.withIn(in) {
        Console.withOut(out) {
          ShoppingCartCommandLine.main(null)
          out.toString must contain("Your shopping cart total is £1.45")
        }
      }
    }

  }
}
