package models

case class Board(combinations : List[Combination] = List()) {

  private val colors = List('G', 'B', 'R', 'Y', 'B', 'W');

  private val SECRET_SIZE = 4;
  private val secret_ = randomSecret(List());

  private val MAX_COMBINATIONS = 3;
  private val combinations_ = combinations


  def getSecret(): Any = {
    this.secret_;
  }

  def randomSecret(secret : List[Char]): List[Char] = {
    secret.size match {
      case SECRET_SIZE => secret
      case default => {
        val random = new scala.util.Random
        randomSecret(secret :+ colors(random.nextInt(colors.size - 1)))
      };
    }
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

  override def equals(that: Any): Boolean =
    that match {
      case that: Board =>
        combinations_ == that.combinations_
      case _ => false
    }
}
