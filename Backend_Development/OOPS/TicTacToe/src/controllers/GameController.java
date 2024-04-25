package controllers;

import exceptions.InvalidMoveException;
import models.Game;
import models.GameState;
import models.Player;

import java.util.List;

public class GameController {
    public Game startGame(int dimension, List<Player> players) {
        // check for duplicate symbols for players and throw an exception if found
        for (int i = 0; i < players.size(); i++) {
            for (int j = i + 1; j < players.size(); j++) {
                if (players.get(i).getSymbol() == players.get(j).getSymbol()) {
                    throw new IllegalArgumentException("Duplicate symbols for players");
                }
            }
        }

        return new Game(dimension, players);
    }

    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove(game);
    }

    public GameState checkState(Game game) {
        return game.getGameState();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }

    public void printBoard(Game game) {
        game.printBoard();
    }

}
