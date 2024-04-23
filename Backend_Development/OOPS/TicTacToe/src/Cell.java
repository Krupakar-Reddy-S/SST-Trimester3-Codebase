public class Cell {
    private Symbol symbol;
    private int row;
    private int col;

    public Cell() {
        this.symbol = new Symbol(' ');
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
