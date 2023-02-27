import java.util.ArrayList;
import java.util.List;

public class Board {
    private int [][] board;
    private int board_size = 15;

    public Board(){
        this.board = new int[board_size][board_size];
    }
    public boolean placeStone(int x, int y, int player){
        if(this.board[y-1][x-1]!=0) return false;
        this.board[y-1][x-1]=player;
        return true;
    }
    public int[][] getBoard() {
        return board;
    }
    public int getSize(){
        return board_size;
    }
//    public List<int[]> getNeighbors(int x, int y){
//        List<int[]> neighbors = new ArrayList<>();
//        if(x>0 && x<board_size && y>0 && y<board_size){
//            for(int i = -1; i<2; i++){
//                for (int j = -1; j<2; j++){
//                    if(board[y+][x] == 0)
//                }
//            }
//        }
//
//    }
    public boolean isGameWon(Player player){
        boolean outcome = false;
        for (int i = 0; i < board_size; i++){
            for(int j = 0; j < board_size; j++){
                if (board[i][j] != 0){
                    outcome = check5(player);
                    if(outcome){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean check5(Player player){
        //horizontal
        for(int i=0; i<board_size; i++){
            int csqstones = 0;
            for(int j=0; j<board_size; j++){
                if(board[i][j] == player.pNum){
                    csqstones++;
                    if (csqstones == 5){
                        return true;
                    }
                }
                else {
                    csqstones = 0;
                }
            }
        }
        //vertical
        for(int i=0; i<board_size; i++){
            int csqstones = 0;
            for(int j=0; j<board_size; j++){
                if(board[j][i] == player.pNum){
                    csqstones++;
                    if (csqstones == 5){
                        return true;
                    }
                }
                else {
                    csqstones = 0;
                }
            }
        }
        //diagonal (/ top-down)
        for(int i = 0; i<board_size-4; i++){
            for(int j = 4; j<board_size; j++){
                int csqstones = 0;
                if(board[i][j] == player.pNum) {
                    for (int k = 0; k < 5; k++) {
                        if (board[i + k][j - k] == player.pNum) {
                            csqstones++;
                            if (csqstones == 5) {
                                return true;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        //diagonal (\ top-down)
//        System.out.println("pnum = "+player.pNum);
        for(int i = 0; i<board_size-4; i++){
            for(int j = 0; j<board_size-4; j++){
                int csqstones = 0;
                if(board[i][j] == player.pNum){
                    for(int k = 0; k<5; k++) {
                        if (board[i + k][j + k] == player.pNum) {
//                            System.out.println("board coordinate " + (i + k) + " " + (j + k) + " board val " + board[i + k][j + k] + " pnum " + player.pNum);
                            csqstones++;
//                            System.out.println("csqstones = " + csqstones);
                            if (csqstones == 5) {
                                return true;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return false;
    }

}
