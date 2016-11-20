package uk.gov.hmrc.shopping.shoppingcart

import org.specs2.mutable.Specification
import uk.gov.hmrc.shopping.items.{Orange, Apple}

/**
  * Created by peterwhitehead on 20/11/2016.
  */
class CheckoutTest extends Specification {
  "when adding items to cart should return valid totals" should {
    "cart total must be 0 when empty" in {
      Checkout(StandardCart()).cartTotal mustEqual 0
    }

    "cart total must be 2.05 when 3 apples and one orange" in {
      val standardCart = StandardCart().addItemToCart(Apple).addItemToCart(Apple).addItemToCart(Orange).addItemToCart(Apple)
      Checkout(standardCart).cartTotal mustEqual 2.05
    }
  }
}
