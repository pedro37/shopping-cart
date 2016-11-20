package uk.gov.hmrc.shopping.items

/**
  * Created by peterwhitehead on 20/11/2016.
  */
trait Item {
  def price: BigDecimal
  def name: String
}
