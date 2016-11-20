package uk.gov.hmrc.shopping.offers

import uk.gov.hmrc.shopping.items.{Orange, Apple}
import uk.gov.hmrc.shopping.shoppingcart.StandardCart

/**
  * Created by peterwhitehead on 20/11/2016.
  */
case class SpecialOffers(cart: StandardCart) {
  def cartTotal = {
    cart.items.view.map {
      case (item, numberOfThisItemInCart) if (item == Apple) => calculatePriceOfAllApples(item.price, numberOfThisItemInCart)
      case (item, numberOfThisItemInCart) if (item == Orange) => calculatePriceOfAllOranges(item.price, numberOfThisItemInCart)
    }.sum
  }

  def calculatePriceOfAllOranges(price: BigDecimal, numberOfThisItemInCart: Long) = {
    numberOfThisItemInCart match {
      case numberOfThisItemInCart if (numberOfThisItemInCart % 3 == 0) => ((numberOfThisItemInCart / 3) * 2) * price
      case numberOfThisItemInCart => numberOfThisItemInCart * price
    }
  }

  def calculatePriceOfAllApples(price: BigDecimal, numberOfThisItemInCart: Long) = ((numberOfThisItemInCart / 2) + (numberOfThisItemInCart % 2)) * price
}
