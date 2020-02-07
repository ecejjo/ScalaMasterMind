package models

case class Board(secret: List[Char] = List(),
                 combinations : List[Combination] = List()) {

  private val colors = List('G', 'B', 'R', 'Y', 'B', 'W');

  private val SECRET_SIZE = 4;
  private var secret_ = secret;

  private val MAX_COMBINATIONS = 3;
  private val combinations_ = combinations

  def getSecret(): List[Char] = {
    println("In getSecret()")
    if (this.secret.isEmpty) this.secret_ = randomSecret(List())
    this.secret_
  }

  def randomSecret(secret : List[Char]): List[Char] = {
    println("In randomSecret()")
    secret.size match {
      case SECRET_SIZE => secret
      case default => {
        val random = new scala.util.Random
        randomSecret(secret :+ colors(random.nextInt(colors.size - 1)))
      };
    }
  }

  def put(combination: Combination) : Board = {
    new Board(this.secret_, this.combinations_ :+ combination.calculateResult(this.secret_))
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
