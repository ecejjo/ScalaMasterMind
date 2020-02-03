package models

class Game(board: Board = new Board()) {

  private val board_ = board

  def getSecret(): Any = {
    board_.getSecret();
  }

  def propose(combination: Combination): Game = {
    new Game(board_.put(combination));
  }

  def getCombination(index: Int): Combination = {
    if (this.board_.combinations.size == 0) {
      null
    }
    else if (index > this.board_.combinations.size - 1) {
      null
    }
    else {
      this.board_.combinations(index)
    }
  }

  def isWinner(): Boolean = this.board_.isWinner;

  def isComplete: Boolean = board_.isComplete
}