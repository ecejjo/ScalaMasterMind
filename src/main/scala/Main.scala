import models.Game
import views.{CombinationView, GameView, GestorIO}

object Main {

  var game = new Game

  def main(args: Array[String]): Unit = {
    while (!game.isComplete) {
      GameView.write(game)
        game = game.propose(CombinationView.read)
        if (game.isWinner()){
          GestorIO.write("You win!!")
          return
      }
    }
    GameView.write(game)
    GestorIO.write("You loose!!")
  }
}
