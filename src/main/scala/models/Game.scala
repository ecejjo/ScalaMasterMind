package models

class Game(board: Board = new Board()) {

  private val board_ = board

  def propose(combination: Combination): Game = {
    new Game(board_.put(combination));
  }

  def getCombination(index: Int): Combination = {
    println("Game.getCombination(): index is:" + index)
    println("Game.getCombination(): this.board_.combinations.size is:" + this.board_.combinations.size)
    if (this.board_.combinations.size == 0) {
      null
    }
    else if (index > this.board_.combinations.size - 1) {
      null
    }
    else {
      println("Game.getCombination(): combination is: " + this.board_.combinations(index))
      this.board_.combinations(index)
    }
  }

  def isWinner(): Boolean = this.board_.isWinner;

  def isComplete: Boolean = board_.isComplete
}