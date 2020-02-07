import models.Result
import org.scalatest.FunSuite

class ResultTest extends FunSuite {

  // private val colors_ = List('G', 'B', 'R', 'Y', 'M', 'C');

  test("No matches") {
    val result = new Result();
    assert(result.calculate(List('G','G','G','G'), List('B','B','B','B')) == new Result(List()));
  }

  test("One black: first position") {
    val result = new Result();
    assert(result.calculate(List('G','B','R','Y'), List('G','M','M','M')) == new Result(List('B')));
  }

  test("Two blacks: first and third position") {
    val result = new Result();
    assert(result.calculate(List('G','B','R','Y'), List('G','M','R','M')) == new Result(List('B','B')));
  }

  test("One white: second position") {
    val result = new Result();
    assert(result.calculate(List('G','B','R','Y'), List('M','G','M','M')) == new Result(List('W')));
  }

  test("Two whites: second and fourth position") {
    val result = new Result();
    assert(result.calculate(List('G','B','R','Y'), List('M','G','M','R')) == new Result(List('W','W')));
  }

  test("Black and whites: BBWW") {
    val result = new Result();
    assert(result.calculate(List('G','B','R','Y'), List('G','Y','R','B')) == new Result(List('B','B','W','W')));
  }

  test("All blacks") {
      val result = new Result();
      assert(result.calculate(List('G','B','R','Y'), List('G', 'B', 'R', 'Y')) == new Result(List('B','B','B','B')));
  }

  test("All whites") {
    val result = new Result();
    assert(result.calculate(List('G','B','R','Y'), List('Y','G','B','R')) == new Result(List('W','W','W','W')));
  }
}
