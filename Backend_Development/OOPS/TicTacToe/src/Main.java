import controllers.GameController;
import exceptions.InvalidMoveException;
import models.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InvalidMoveException {
        Scanner scanner = new Scanner(System.in);

        GameController gameController = new GameController();

        int dimension = 3;
        List<Player> players = List.of(
                new Player("Krupakar", new Symbol('X')),
                new Bot("Scaler", new Symbol('O'), BotDifficultyLevel.EASY)
        );

        Game game = gameController.startGame(dimension, players);

        while (game.getGameState().equals(GameState.IN_PROGRESS)) {
            gameController.printBoard(game);
            gameController.makeMove(game);
        }

        gameController.printBoard(game);

        System.out.println("\nGame Over");
        if (game.getWinner() != null) {
            System.out.println("Winner: " + game.getWinner().getName());
        } else {
            System.out.println("It's a draw!");
        }
    }
}
