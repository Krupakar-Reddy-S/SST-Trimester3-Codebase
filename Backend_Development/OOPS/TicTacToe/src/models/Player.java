package models;

import java.util.Scanner;

public class Player {
    private String name;
    private Symbol symbol;
    private PlayerType type;
    private static Scanner scanner = new Scanner(System.in);

    public Player(String name, Symbol symbol) {
        this(name, symbol, PlayerType.HUMAN);
    }

    public Player(String name, Symbol symbol, PlayerType type) {
        this.name = name;
        this.symbol = symbol;
        this.type = type;
    }

    public Move makeMove(Board board) {
        System.out.println("Player " + name + " turn:");

        System.out.print("Enter row: ");
        int row = scanner.nextInt();

        System.out.print("Enter column: ");
        int column = scanner.nextInt();

        return new Move(this, board.getBoard().get(row).get(column));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public PlayerType getType() {
        return type;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

}
