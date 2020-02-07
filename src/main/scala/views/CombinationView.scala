package views

import models.Combination

import scala.collection.mutable.ListBuffer

object CombinationView {

  private val COMBINATION_SIZE = 4;

  def read: Combination = {
    var combination = new String
    combination += GestorIO.readString("Your proposal? ")
    Combination(combination.toList)
  }

  def show (combination: Combination): String = {
    var stringToShow = "";
    for (counter <- 0 to COMBINATION_SIZE - 1) {
      stringToShow += combination.getValue(counter);
    }
    stringToShow += " - " + ResultView.show(combination.getResult);
    stringToShow
  }
}
