package models

class Game(board: Board = new Board()) {

  private val board_ : Board = board

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
    new Game(this.board_.put(combination));
  }

  def isWinner(): Boolean = this.board_.isWinner;

  def isComplete: Boolean = board_.isComplete

  override def equals(that: Any): Boolean =
    that match {
      case that: Game =>
        this.board_ == that.board_
      case _ => false
    }
}