package uk.gov.hmrc.shopping.offers

import org.specs2.mutable.Specification
import uk.gov.hmrc.shopping.items.{Orange, Apple}
import uk.gov.hmrc.shopping.shoppingcart.StandardCart

/**
  * Created by peterwhitehead on 20/11/2016.
  */
class SpecialOffersTest extends Specification {
  "when adding items to cart should return valid totals" should {
    "cart total must be 0 when empty" in {
      SpecialOffers(StandardCart()).cartTotal mustEqual 0
    }

    "cart total must be 0.60 when 1 apple" in {
      val standardCart = StandardCart().addItemToCart(Apple)
      SpecialOffers(standardCart).cartTotal mustEqual 0.60
    }

    "cart total must be 0.60 when 2 apples get one free" in {
      val standardCart = StandardCart().addItemToCart(Apple).addItemToCart(Apple)
      SpecialOffers(standardCart).cartTotal mustEqual 0.60
    }

    "cart total must be 0.50 when 2 oranges" in {
      val standardCart = StandardCart().addItemToCart(Orange).addItemToCart(Orange)
      SpecialOffers(standardCart).cartTotal mustEqual 0.50
    }

    "cart total must be 0.50 when 3 oranges get one free" in {
      val standardCart = StandardCart().addItemToCart(Orange).addItemToCart(Orange).addItemToCart(Orange)
      SpecialOffers(standardCart).cartTotal mustEqual 0.50
    }
  }
}
