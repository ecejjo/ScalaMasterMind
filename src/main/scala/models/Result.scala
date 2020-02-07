package models

import javax.naming.spi.DirStateFactory

case class Result(value: List[Char] = List()) {

  private var value_ : List[Char] = value;

  def getValue: List[Char] = value_

  def isWinner(): Boolean = {
    this.value_ == List('B', 'B', 'B', 'B')
  }

  def calculate(secret: List[Char], combination: Combination): Result = {
    var blacks, whites, trimmed: List[Char] = List()
    new Result(
      trimWhites(
        findBlacks(secret, combination.getValue, blacks),
        findWhites(secret, combination.getValue, whites),
        trimmed
      )
    );
  }

  def trimWhites(blacks: List[Char] = List(),
                 whites: List[Char] = List(),
                 trimmed: List[Char] = List()
                            ): List[Char] = {
    println("...................................")
    println("blacks is: " + blacks);
    println("whites is: " + whites);
    blacks.isEmpty match {
      case true => trimmed ::: whites
      case false => trimWhites(blacks.tail, whites.tail, blacks.head :: trimmed);
    }
  }

  def findBlacks(secret: List[Char], proposed: List[Char], blacks: List[Char]): List[Char] = {
    println("...................................")
    println("secret is: " + secret);
    println("combination is: " + proposed);
    println("blacks is: " + blacks);
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

  def findWhites(secret: List[Char], proposed: List[Char], whites: List[Char]): List[Char] = {
    println("...................................")
    println("secret is: " + secret);
    println("combination is: " + proposed);
    println("whites is: " + whites);
    proposed.isEmpty match {
      case true => whites;
      case false => {
        if (secret.contains(proposed.head)) {
          findWhites(secret, proposed.tail, whites :+ 'W');
        }
        else
          findWhites(secret, proposed.tail, whites);
      }
    }
  }
}
