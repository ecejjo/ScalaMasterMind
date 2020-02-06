package models

case class Board(combinations : List[Combination] = List()) {

  private val secret_ = List('G', 'G', 'W', 'Y');
  private val combinations_ = combinations

  private val MAX_COMBINATIONS = 3;

  def getSecret(): Any = {
    this.secret_;
  }

  def put(combination: Combination) : Board = {
    new Board(this.combinations_ :+ combination.calculateResult(this.secret_))
  }

  def getCombination(index: Int) : Combination = {
    this.combinations_(index);
  }

  def isComplete: Boolean = {
    combinations.size == MAX_COMBINATIONS
  }

  def isWinner: Boolean = {
    combinations_.last.isWinner();
  }
}
