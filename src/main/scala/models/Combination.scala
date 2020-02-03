package models

case class Combination(value: List[Char]) {

  private val COMBINATION_SIZE = 4;

  private var value_ : List[Char] = value;

  private val result_ = Result();

  def getValue: List[Char] = value_

  def getResult: Result = result_

  def isWinner(secret: List[Char]): Boolean = {
    this.result_.calculate(secret, this);
  }

}
