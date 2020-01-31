package models

case class Board(combinations : List[Combination] = List()) {

  private val secret_ = List('x', 'x', 'x', 'x');
  private val combinations_ = combinations
  private val results_ = List(Result())

  private val MAX_COMBINATIONS = 3;

  def getSecret(): Any = {
    this.secret_;
  }

  def getResults(): Any = {
    this.results_;
  }

  def put(combination: Combination) : Board = {
    println("Board.put()")
    new Board(combination::combinations)
  }

  def getCombination(index: Int) : Combination = {
    this.combinations_.tail.head
  }

  def getResult(index: Int) : Result = {
    this.results_.tail.head
  }

  def isComplete: Boolean = {
    combinations.size == MAX_COMBINATIONS
  }

  def isWinner: Boolean = {
    false;
  }
}
