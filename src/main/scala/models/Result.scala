package models

import javax.naming.spi.DirStateFactory

case class Result(value: List[Char] = List()) {

  private var value_ : List[Char] = value;

  def getValue: List[Char] = value_

  def isWinner(): Boolean = {
    this.value_ == List('B', 'B', 'B', 'B')
  }

  def calculate(secret: List[Char], combination: Combination): Result = {
    var blacks: List[Char] = List()
    new Result(findBlacks(secret, combination.getValue, blacks));
  }

  def findBlacks(secret: List[Char], proposed: List[Char], blacks: List[Char]): List[Char] = {
    println("...................................")
    println("secret is: " + secret);
    println("combination is: " + proposed);
    println("result is: " + blacks);
    secret.isEmpty match {
      case true => blacks;
      case false => {
        if (secret.head == proposed.head) {
          findBlacks(secret.tail, proposed.tail, blacks :+ 'B');
        }
        else
          findBlacks(secret.tail, proposed.tail, blacks);
      }
    }
  }

  /*
    for (i <- 0 to combination.getValue.size - 1) {
      secret(i) == combination.getValue(i) match {
        case true => {
          this.value_ = this.value_ :+ 'B'
          secret.updated(i, '_'); // Avoids duplicate results
        }
        case false => findWhites(secret, combination)
      }
    }
    new Result()
  }

  def findWhites(secret: List[Char], combination: Combination): Result = {
    for (j <- i to combination.getValue.size - 1) {
      secret(j) == combination.getValue(i) match {
        case true => {
          this.value_ = this.value_ :+ 'W'
          secret.updated(j, '_'); // Avoids duplicate results
    }
    case false => println("No black, nor white")
    new Result()
  }
   */

}
