import models.{Board, Combination, Game}
import org.scalatest.FunSuite

class GameTest extends FunSuite {

  test("Propose one combination") {
    val game = new Game()
    val combination = new Combination(List('B','R','Y','R'));
    assert(game.propose(combination) == new Game(new Board(List(), List(new Combination(List('B','R','Y','R'))))));
  }
}
