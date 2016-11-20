package uk.gov.hmrc.shopping.shoppingcart

/**
  * Created by peterwhitehead on 20/11/2016.
  */
case class Checkout(cart: StandardCart) {
  def cartTotal: BigDecimal = {
    cart.items.view.map {
      case (item, numberOfThisItemInCart) => item.price * numberOfThisItemInCart
    }.sum
  }
}
