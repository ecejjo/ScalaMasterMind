package models

import javax.naming.spi.DirStateFactory

case class Result(value: List[Char] = List()) {

  private val RESULT_SIZE = 4;

  private var value_ : List[Char] = value;

  def getValue: List[Char] = value_

  def calculate(secret: List[Char], combination: Combination): Boolean = {
    for (i <- 0 to RESULT_SIZE - 1) {
      secret(i) == combination.getValue(i) match {
        case true => this.value_ = this.value_.::('x');
        case false => this.value_ = this.value_.::('.');
      }
    }
    this.value_ == List('x', 'x', 'x', 'x');
  }
}
