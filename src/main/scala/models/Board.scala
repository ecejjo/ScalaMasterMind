package models

case class Board(combinations : List[Combination] = List()) {

  // private val secret_ = List[Char];
  private val combinations_ = combinations
  private val MAX_COMBINATIONS = 3;

  def put(combination: Combination) : Board = {
    println("Board.put()")
    new Board(combination::combinations)
  }

  def getCombination(index: Int) : Combination = {
    this.combinations.tail.head
  }

  def isComplete: Boolean = {
    combinations.size == MAX_COMBINATIONS
  }

  def isWinner: Boolean = {
    false;
  }
}
