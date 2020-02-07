package models

class Color {

  private val colors_ = List('G', 'B', 'R', 'Y', 'M', 'C');
  private val colorsText_ = List("Green", "Blue", "Red", "Yellow", "Magenta", "Cyan");

  def getColors(): List[Char] = {
    this.colors_
  }

  def getColorsText(): List[String] = {
    this.colorsText_
  }
}
