package views

import models.Combination

import scala.collection.mutable.ListBuffer

object CombinationView {

  private val COMBINATION_SIZE = 4;

  def read: Combination = {
    println("G: Green, B: Blue, R: Red, Y: Yellow")
    var combination = new ListBuffer[Char]()
    for (counter <- 0 to COMBINATION_SIZE - 1) {
      combination += GestorIO.readChar("Color" + counter + "? [GBRY]")
    }
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
