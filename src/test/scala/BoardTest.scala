import models.{Board, Combination}
import org.scalatest.FunSuite

class BoardTest extends FunSuite {

    test("put one combination") {
      val board = new Board()
      val combination = new Combination(List('R','R','R','R'));
      assert(board.put(combination) == new Board(List(), List(new Combination(List('R','R','R','R')))));
    }

  test("put two combinations") {
    val board = new Board()
    val combination1 = new Combination(List('R','R','R','R'));
    val combination2 = new Combination(List('B','B','B','B'));

    assert(board.put(combination1).put(combination2) ==
      new Board(List(),
        List(
          new Combination(List('R','R','R','R')),
          new Combination(List('B','B','B','B')
        ))));
  }
}
