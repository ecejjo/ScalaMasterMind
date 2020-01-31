package views

import models.{Combination, Result}

import scala.collection.mutable.ListBuffer

object ResultView {

  private val RESULT_SIZE = 4;

  def show (result: Result): String = {
    var resultString = "";
    for (counter <- 0 to RESULT_SIZE - 1) {
      resultString += result.getValue(counter);
    }
    resultString
  }

}
