import models.{Board, Combination, Game}
import org.scalatest.FunSuite

class GameTest extends FunSuite {

  val secret: List[Char] = List('B','R','Y','R');
  val winner: List[Char] = secret;
  val looser: List[Char] = secret.tail :+ 'G';

  test("Get secret") {
    val game = new Game(new Board(secret));
    assert(game.getSecret() == secret);
  }

  test("Propose combination") {
    val combination = new Combination(looser);
    val game1 = new Game(new Board(secret)).propose(combination);
    val game2 = new Game(new Board(secret, List(combination.calculateResult(secret))));
    assert(game1 == game2)
  }

  test("Get combination index 0") {
    val combination = new Combination(looser);
    val game = new Game().propose(combination);
    assert(game.getCombination(0) == combination);
  }

  test("Get combination index 2") {
    val combination1 = new Combination(looser);
    val combination2 = new Combination(looser);
    val combination3 = new Combination(winner);
    val game = new Game().propose(combination1).propose(combination2).propose(combination3);
    assert(game.getCombination(2) == combination3);
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
