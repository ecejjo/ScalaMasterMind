package views

import models.Game

object BoardView {
  def write(game: Game) = {
    var result = "Tablero:\n"

    var i = 0;
    while (game.getCombination(i) != null) {
      val combination = game.getCombination(i)
      result += i + ".- " + CombinationView.show(combination) + "\n"
      i += 1;
    }
    println(result)
  }
}
