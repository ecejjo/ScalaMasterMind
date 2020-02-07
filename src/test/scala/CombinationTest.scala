import models.{Board, Combination, Result}
import org.scalatest.FunSuite

class CombinationTest extends FunSuite {

  val secret = List('R','B','Y','M');
  val winner = secret;
  val looser: List[Char] = secret.tail :+ 'R';

  val allBlacksResult = new Result(List('B','B','B','B'));
  val allWhitesResult = new Result(List('W','W','W','W'));

  test("calculateResult: all blacks result") {
    val combination = new Combination(winner);
    assert(combination.calculateResult(secret) == new Combination(winner, allBlacksResult));
  }

  test("calculateResult: all whites result") {
    val combination = new Combination(looser);
    assert(combination.calculateResult(secret) == new Combination(looser, allWhitesResult));
  }
}
