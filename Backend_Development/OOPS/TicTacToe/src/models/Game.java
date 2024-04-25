package models;

import exceptions.InvalidMoveException;
import models.Board;
import models.GameState;
import models.Move;
import models.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState gameState;
    private Player winner;
    private int nextPlayerMoveIndex;

    public Game(int dimension, List<Player> players) {
        this.board = new Board(dimension);
        this.players = players;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.winner = null;
        this.nextPlayerMoveIndex = 0;
    }

    public void printBoard() {
        this.board.printBoard();
    }

    public boolean validMove(Move move) {
        int row = move.getCell().getRow();
        int column = move.getCell().getCol();

        if (row < 0 || row >= board.getSize() || column < 0 || column >= board.getSize()) {
            return false;
        }

        return board.getBoard().get(row).get(column).getCellState().equals(CellState.EMPTY);
    }

    public void makeMove(Game game) throws InvalidMoveException {
        Player currentPlayer = game.getPlayers().get(game.getNextPlayerMoveIndex());

        // Move that currentPlayer wants to make
        Move move = currentPlayer.makeMove(board);

        // validate move before making it
        if (! validMove(move)) {
            throw new InvalidMoveException("Invalid move made by: " + currentPlayer.getName());
        }

        int row = move.getCell().getRow();
        int column = move.getCell().getCol();

        Cell cellToChange = board.getBoard().get(row).get(column);
        cellToChange.setPlayer(currentPlayer);
        cellToChange.setCellState(CellState.FILLED);

        Move finalMove = new Move(currentPlayer, cellToChange);
        moves.add(finalMove);

        if (checkWin(currentPlayer, row, column)) {
            gameState = GameState.ENDED;
            winner = currentPlayer;
            return;
        }
        else if (checkDraw()) {
            gameState = GameState.DRAW;
        }

        // printBoard();

        nextPlayerMoveIndex = (nextPlayerMoveIndex + 1) % players.size();
    }

    public boolean checkWin(Player currentPlayer, int row, int col) {
       boolean win = true;

        for (int i = 0; i < board.getSize(); i++) {
            if (board.getBoard().get(i).get(col).getPlayer() != (currentPlayer)) {
                win = false;
                break;
            }
        }

        if (win) {
            return true;
        }

        win = true;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getBoard().get(row).get(i).getPlayer() != (currentPlayer)) {
                win = false;
                break;
            }
        }

        if (win) {
            return true;
        }

        win = true;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getBoard().get(i).get(i).getPlayer() != (currentPlayer)) {
                win = false;
                break;
            }
        }

        if (win) {
            return true;
        }

        win = true;
        for (int i = 0; i < board.getSize(); i++) {
            if (board.getBoard().get(i).get(board.getSize() - i - 1).getPlayer() != (currentPlayer)) {
                win = false;
                break;
            }
        }

        return win;
    }

    public boolean checkDraw() {
        for (List<Cell> row : board.getBoard()) {
            for (Cell cell : row) {
                if (cell.getCellState().equals(CellState.EMPTY)) {
                    return false;
                }
            }
        }

        return true;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }
}
