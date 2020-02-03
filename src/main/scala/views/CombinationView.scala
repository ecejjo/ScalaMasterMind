package views

import models.Combination

import scala.collection.mutable.ListBuffer

object CombinationView {

  private val COMBINATION_SIZE = 4;

  def read: Combination = {
    var combination = new String
    combination += GestorIO.readString("Your proposal? [GBRY]")
    Combination(combination.toList)
  }

  def show (combination: Combination): String = {
    var result = "";
    for (counter <- 0 to COMBINATION_SIZE - 1) {
      result += combination.getValue(counter);
    }
    result
  }

}
