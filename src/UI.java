public class UI {
    public UI(){
    }
    public void printBoard(Board board){
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
    public void selectMode(){
        System.out.println("Select Game Mode:");
        System.out.println("Press 1 for Single Player");
        System.out.println("Press 2 for PvP");
        System.out.print("Input number: ");
    }
    public void modeSelected(int mode){
        if (mode == 1) {
            System.out.println("Player vs Computer has been selected");
        } else if (mode == 2) {
            System.out.println("Player vs Player has been selected");
        }
        else {
            System.out.println("Please input a valid game mode");
        }
    }
    public void invalid(){
        System.out.println("Invalid number, try again");
    }
    public void playerNext(int x){
        System.out.println("Player " + x + " next.");
    }
    public void xIn(){
        System.out.println("Input X Coordinate:");
    }
    public void yIn(){
        System.out.println("Input Y Coordinate:");
    }
    public void cpuMove(){
        System.out.println("CPU Moves");
    }
    public void winNotification(int winner){
        System.out.println("Player " + winner + " has WON!");
    }
}
