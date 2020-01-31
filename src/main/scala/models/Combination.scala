package models

case class Combination(value: List[Char]) {

  private val COMBINATION_SIZE = 4;

  private var value_ : List[Char] = value;

  def getValue: List[Char] = value_

}
