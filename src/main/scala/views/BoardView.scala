package views

import models.Game

object BoardView {
  def write(game: Game) = {
    var boardString = " -- G: Green, B: Blue, R: Red, Y: Yellow --\n";
    boardString += "Board Content is:\n"
    boardString += " - Secret is: " + game.getSecret().toString + "\n";

    boardString += " - # - Prop - Result\n"

    var i = 0;
    while (game.getCombination(i) != null) {
      val combination = game.getCombination(i);
      i += 1;
      boardString +=  " - " + i + ".- " + CombinationView.show(combination) + "\n"
    }
    println(boardString)
  }
}
