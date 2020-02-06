package models

case class Combination(value: List[Char], result: Result = new Result()) {

  private val COMBINATION_SIZE = 4;

  private var value_ : List[Char] = value;

  private val result_ = result;

  def getValue: List[Char] = value_

  def getResult(): Result = {
    this.result_;
  }

  def calculateResult(secret: List[Char]): Combination = {
    new Combination(this.value_, this.result_.calculate(secret, this))
  }

  def isWinner(): Boolean = {
    this.result_.isWinner();
  }

}
