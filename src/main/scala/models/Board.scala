package models

case class Board(secret: List[Char] = List(),
                 combinations : List[Combination] = List()) {

  private val colors_ = List('G', 'B', 'R', 'Y', 'M', 'C');
  private val colorsText_ = List("Green", "Blue", "Red", "Yellow", "Magenta", "Cyan");

  private val SECRET_SIZE = 4;
  private var secret_ = secret;

  private val MAX_COMBINATIONS = 3;
  private val combinations_ = combinations

  def getColors(): List[Char] = {
    this.colors_
  }

  def getColorsText(): List[String] = {
    this.colorsText_
  }

  def getSecret(): List[Char] = {
    if (this.secret.isEmpty) this.secret_ = randomSecret(List())
    this.secret_
  }

  def randomSecret(secret : List[Char]): List[Char] = {
    secret.size match {
      case SECRET_SIZE => secret
      case default => {
        val random = new scala.util.Random
        randomSecret(secret :+ colors_(random.nextInt(colors_.size - 1)))
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
