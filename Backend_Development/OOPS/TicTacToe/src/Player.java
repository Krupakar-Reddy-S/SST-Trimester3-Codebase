public class Player {
    private String name;
    private Symbol symbol;
    private PlayerType type;

    public Player(String name, Symbol symbol, PlayerType type) {
        this.name = name;
        this.symbol = symbol;
        this.type = type;
    }

    public Player(String name, Symbol symbol) {
        this(name, symbol, PlayerType.HUMAN);
    }
}
