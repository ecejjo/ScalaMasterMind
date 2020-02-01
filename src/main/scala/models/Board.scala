package models

case class Board(combinations : List[Combination] = List(),
                 results : List[Result] = List() ) {

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
    new Board(combination::this.combinations_,
              new Result().calculate(this.secret_, combination)::this.results_)
  }

  def getCombination(index: Int) : Combination = {
    this.combinations_(index);
  }

  def getResult(index: Int) : Result = {
    this.results_(index);
  }

  def isComplete: Boolean = {
    combinations.size == MAX_COMBINATIONS
  }

  def isWinner: Boolean = {
    false;
  }
}
