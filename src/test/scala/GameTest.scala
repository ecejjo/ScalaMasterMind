import models.{Board, Combination, Game}
import org.scalatest.FunSuite

class GameTest extends FunSuite {

  val secret: List[Char] = List('B','R','Y','R')
  val winner: List[Char] = secret
  val looser: List[Char] = secret.tail :+ 'G'

  test("Propose combination") {
    val game = new Game()
    val combination = new Combination(looser);
    assert(game.propose(combination) == new Game(new Board(secret, List(new Combination(looser)))));
  }

  test("Is not winner") {
    val combination = new Combination(looser);
    val game = new Game(new Board(secret)).propose(combination);
    assert(!game.isWinner);
  }

  test("Is winner") {
    val combination = new Combination(winner);
    val game = new Game(new Board(secret)).propose(combination);
    assert(game.isWinner);
  }

  test("Is not complete") {
    val combination = new Combination(looser);
    val game = new Game(new Board(secret)).propose(combination);
    assert(!game.isComplete);
  }

  test("Is complete") {
    val combination = new Combination(looser);
    val game = new Game(new Board(secret)).propose(combination).propose(combination).propose(combination);
    assert(game.isComplete);
  }
}
