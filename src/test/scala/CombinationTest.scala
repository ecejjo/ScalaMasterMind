import models.{Board, Combination, Result}
import org.scalatest.FunSuite

class CombinationTest extends FunSuite {

  val allBlacksResult = new Result(List('B','B','B','B'));
  val allWhitesResult = new Result(List('W','W','W','W'));

  test("calculateResult: all blacks result") {

    val secret = List('R','R','R','R');
    val combination = new Combination(List('R','R','R','R'));
    assert(combination.calculateResult(secret) == new Combination(secret, allBlacksResult));
  }

  test("calculateResult: all whites result") {
    val secret = List('R','B','Y','M');
    val combination = new Combination(List('B','Y','M','R'));
    assert(combination.calculateResult(secret) == new Combination(secret, allWhitesResult));
  }

}
