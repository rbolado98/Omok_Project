public class CPUPlayer extends Player{
    public CPUPlayer(int pnum){
        super.pNum = pnum;
    }
    public boolean makeMove(int x, int y, Board board){
        //board.placeStone(x, y, pNum);
        //horizontal
        for(int i = 0; i< board.getSize(); i++){
            for(int j = 0; j< board.getSize(); i++){
                if(board.getBoard()[i][j] == 1){

                }
            }
        }
        return true;
    }
}
