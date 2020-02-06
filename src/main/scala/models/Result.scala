package models

import javax.naming.spi.DirStateFactory

case class Result(value: List[Char] = List()) {

  private var value_ : List[Char] = value;

  def getValue: List[Char] = value_

  def calculate(secret: List[Char], combination: Combination): Boolean = {
    this.value_ = List();

    // Calculate blacks and whites
    for (i <- 0 to combination.getValue.size - 1) {
      secret(i) == combination.getValue(i) match {
        case true => this.value_ = this.value_ :+ 'B'
        case false => {
          secret.contains(combination.getValue(i)) match {
            case true => this.value_ = this.value_ :+ 'W'
            case false => println("No black, nor white")
          }
        }
      }
    }
    this.value_ == List('B', 'B', 'B', 'B');
  }
}
