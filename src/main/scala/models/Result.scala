package models

import javax.naming.spi.DirStateFactory

case class Result(value: List[Char] = List()) {

  private var value_ : List[Char] = value;

  def getValue: List[Char] = value_

  def isWinner(): Boolean = {
    this.value_ == List('B', 'B', 'B', 'B')
  }

  def calculate(secret: List[Char], combination: Combination): Result = {
    new Result(findBlacks(secret, combination));
  }

  def findBlacks(secret: List[Char], combination: Combination): List[Char] = {
    println("...................................")
    println("secret is: " + secret);
    println("combination is: " + combination);
    secret.isEmpty match {
      case true => {
        combination.getResult().getValue;
      }
      case false => {
        if (secret.head == combination.getValue.head) {
          findBlacks(secret.tail, new Combination(combination.getValue.tail, new Result(combination.getResult().getValue :+ 'B')));
        }
        else
          findBlacks(secret.tail, new Combination(combination.getValue.tail, new Result(combination.getResult().getValue)));
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
