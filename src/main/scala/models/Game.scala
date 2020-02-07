package models

class Game(board: Board = new Board()) {

  private val board_ = board

  def getColors(): Color = {
    board_.getColors()
  }

  def getSecret(): List[Char] = {
    board_.getSecret();
  }

  def getCombination(index: Int) : Combination = {
    board_.getCombination(index);
  }

  def propose(combination: Combination): Game = {
    new Game(board_.put(combination));
  }

  def isWinner(): Boolean = this.board_.isWinner;

  def isComplete: Boolean = board_.isComplete
}