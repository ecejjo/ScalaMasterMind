package models

case class Result(value: List[Char] = List('.','.','.','.')) {

  private val RESULT_SIZE = 4;

  private var value_ : List[Char] = value;

  def getValue: List[Char] = value_

}
