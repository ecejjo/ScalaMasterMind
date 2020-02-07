package views

import models.Game

object BoardView {
  def write(game: Game) = {

    var boardString = "";

    var colorsIndex = 0
    boardString = "Available colors: \n - ";
    for (colorsIndex <- 0 to game.getColors().size - 1) {
      boardString += game.getColors()(colorsIndex);
      boardString += ":";
      boardString += game.getColorsText()(colorsIndex);
      boardString += " ";
    }
    boardString += "\n";

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
