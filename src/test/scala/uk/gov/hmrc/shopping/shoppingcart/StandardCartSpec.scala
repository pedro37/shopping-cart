package uk.gov.hmrc.shopping.shoppingcart

import org.specs2.mutable._
import uk.gov.hmrc.shopping.items.{Orange, Apple}

/**
  * Created by peterwhitehead on 20/11/2016.
  */
class StandardCartSpec extends Specification {

  "when adding items to cart should return valid values" should {
    "add one item to cart" in {
      val standardCart1 = StandardCart().addItemToCart(Apple)
      standardCart1.items.size mustEqual 1
    }

    "cart should be empty on start up" in {
      StandardCart().items.size mustEqual 0
    }

    "adding more than one item of same product should increase number of items in cart" in {
      val standardCart = StandardCart().addItemToCart(Apple).addItemToCart(Apple).addItemToCart(Orange)
      standardCart.items.size mustEqual 2
      standardCart.items mustEqual Map((Apple -> 2), (Orange, 1))
    }
  }
}
