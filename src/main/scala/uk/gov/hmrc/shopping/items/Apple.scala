package uk.gov.hmrc.shopping.items

/**
  * Created by peterwhitehead on 20/11/2016.
  */
case object Apple extends Item {
  override def price: BigDecimal = BigDecimal("0.60")
  override def name: String = "apple"
}
