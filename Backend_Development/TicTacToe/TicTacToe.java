import java.util.Scanner;

public class TicTacToe{

    public static void printBoard(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }
    }

    public static boolean hasWon(char[][] board, char symbol) {
        for (int i = 0; i < board.length; i++) {
            // Check rows
            for (int j = 0; j < board[i].length; j++) {
                if (symbol != board[i][j]) {
                    break;
                }
                else {
                    if (j == (board[i].length - 1) ) {
                        return true;
                    }
                }
            }

            // Check columns
            for (int j = 0; j < board[i].length; j++) {
                if (symbol != board[j][i]) {
                    break;
                }
                else {
                    if (j == (board[j].length - 1) ) {
                        return true;
                    }
                }
            }
        }

        // Check diagonal
        boolean diagonal1 = true;
        boolean diagonal2 = true;
        for (int i = 0; i < board.length; i++) {
            if (symbol != board[i][i]) {
                diagonal1 = false;
            }
            if (symbol != board[i][board.length - 1 - i]) {
                diagonal2 = false;
            }
        }

        if (diagonal1 || diagonal2) {
            return true;
        }

        return false;
    }
    
    public static void main(String[] args) {
        int n = 3;
        char board[][] = new char[n][n];

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name of player 1: ");
        String P1 = sc.nextLine();

        System.out.print("Enter Name of player 2: ");
        String P2 = sc.nextLine();

        printBoard(board);

        // True : player 1 turn
        Boolean turn = true;
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                board[i][j] = '-';
            }
        }
        int cnt = 0;
        
        while(true){
            char sym;
            printBoard(board);
            while(true){
                if(turn){
                    System.out.println( P1 + ", make turn :");
                    sym = 'X';
                }
                else{
                    System.out.println(P2 + ", make turn :");
                    sym = 'O';
                }

                System.out.println("Please input the row : ");
                int r = sc.nextInt();
                System.out.println("Please input the col : ");
                int c = sc.nextInt();
                
                if(r < 0 || r >= n || c < 0 || c >= n){
                    System.out.println("Invalid Move!");
                }
                else if(board[r][c] != '-'){
                    System.out.println("Move has been already done there");
                }
                else{
                    board[r][c] = sym;
                    c++;
                    break;
                }
            }
            if(hasWon(board, sym)){
                System.out.println("Winner is "+sym);
                break;
            }
            else if(cnt == 9){
                System.out.println("Draw");
                break;
            }

            turn = !turn;
        }

        sc.close();
    }
}