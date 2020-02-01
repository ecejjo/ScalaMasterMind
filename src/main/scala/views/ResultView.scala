package views

import models.{Combination, Result}

import scala.collection.mutable.ListBuffer

object ResultView {

  private val RESULT_SIZE = 4;

  def show (result: Result): String = {
    var resultString = "";
    if ( ! result.getValue.isEmpty) {
      for (counter <- 0 to result.getValue.size) {
        resultString += result.getValue(counter);
      }
    }
    resultString
  }

}
