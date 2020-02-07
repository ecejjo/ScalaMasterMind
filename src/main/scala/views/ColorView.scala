package views

import models.Color

object ColorView {

  def show (color: Color): String = {

    var colorString = "";
    var colorsIndex = 0
    colorString = "Available colors: \n - ";
    for (colorsIndex <- 0 to color.getColors().size - 1) {
      colorString += color.getColors()(colorsIndex);
      colorString += ":";
      colorString += color.getColorsText()(colorsIndex);
      colorString += " ";
    }
    colorString += "\n";
    colorString
  }
}
