import models.{Board, Combination}
import org.scalatest.FunSuite

class BoardTest extends FunSuite {

    test("put on 1,1 with x") {
      val board = new Board()
      val combination = new Combination(List('R', 'R', 'R','R'));
      assert(board.put(combination) == new Board(List(new Combination(List('R', 'R', 'R','R')))));
    }
}
