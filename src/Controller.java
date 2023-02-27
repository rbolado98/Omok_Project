import java.util.Scanner;

public class Controller {
     private Board board;
     private Player p1;
     private Player p2;
     private int mode;

     public Controller(){
          this.board = new Board();
     }

     public void gameMode(int mode){
         this.mode = mode;
     }
     public void printBoard(){
          System.out.print("  X");
          for(int i = 0; i < board.getSize(); i++){
               System.out.print("\t" + (i+1));
          }
          System.out.println();
          System.out.println("Y");

          for (int i = 0; i < board.getSize(); i++){
               System.out.print(i+1 + "\t");
               for (int j = 0; j < board.getSize(); j++){
                    System.out.print(board.getBoard()[i][j] + "\t");
               }
               System.out.println();
          }
     }
     public void play(){
          Scanner scanner = new Scanner(System.in);
          System.out.println("Select Game Mode:");
          System.out.println("Press 1 for Single Player");
          System.out.println("Press 2 for PvP");
          System.out.print("Input number: ");
          switch (scanner.nextLine()) {
               case "1" -> {
                    mode = 1;
               }
               case "2" -> {
                    mode = 2;
               }
               default -> play();
          }
          if (mode == 1){
               System.out.println("Player vs Computer has been selected");
               Player player1 = new HumanPlayer(1);
               Player player2 = new CPUPlayer(2);
               Player current = player1;
               printBoard();
               while(true){
                    System.out.println("Player " + current.pNum + " next.");
                    System.out.println("Input X Coordinate:");
                    int x = scanner.nextInt();
                    System.out.println("Input Y Coordinate:");
                    int y = scanner.nextInt();
                    //!board.placeStone(x, y, current.getpNum()) THIS WAS INSIDE IF BELOW
                    if (!current.makeMove(x, y, board)) continue;
                    if(board.isGameWon(current)){
                         printBoard();
                         System.out.println("Player " + current.pNum + " has WON!");
                         break;
                    }
                    current = player1 == current? player2 : player1; //short if statement
                    printBoard();
               }
          }
          if (mode == 2){
               System.out.println("Player vs Player has been selected");
               Player player1 = new HumanPlayer(1);
               Player player2 = new HumanPlayer(2);
               Player current = player1;
               printBoard();
               while(true){
                    System.out.println("Player " + current.pNum + " next.");
                    System.out.println("Input X Coordinate:");
                    int x = scanner.nextInt();
                    System.out.println("Input Y Coordinate:");
                    int y = scanner.nextInt();
                    //!board.placeStone(x, y, current.getpNum()) THIS WAS INSIDE IF BELOW
                    if (!current.makeMove(x, y, board)) continue;
                    if(board.isGameWon(current)){
                         printBoard();
                         System.out.println("Player " + current.pNum + " has WON!");
                         break;
                    }
                    current = player1 == current? player2 : player1; //short if statement
                    printBoard();
               }
          }
     }
}

