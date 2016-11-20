package uk.gov.hmrc.shopping.shoppingcart

import uk.gov.hmrc.shopping.items.Item

/**
  * Created by peterwhitehead on 20/11/2016.
  */
case class StandardCart(items: Map[Item, Long] = Map.empty) {
  def addItemToCart(item: Item) = {
    val numberOfThisItemInCart = items.getOrElse(item, 0L) + 1
    copy(items + (item -> numberOfThisItemInCart))
  }
}
