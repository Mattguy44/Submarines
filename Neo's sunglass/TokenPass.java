
public class TokenPass {
    private int[] board;
    private int currentPlayer;

    public TokenPass(int playerCount) {
        /* to be completed in part (a) */
        board=new int [playerCount];
  for(int ix=0;ix<playerCount;ix++){
  board[ix]=(int)(Math.random()*10+1);
  }
  currentPlayer=(int)(Math.random()*playerCount);

    }
    
    public void distributeCurrentPlayerTokens()
    {
        /* to be completed in part (b) */
        int index=currentPlayer;
  int total=board[currentPlayer];
  board[currentPlayer]=0;
  for(;total>0;total--)
  {
      if(currentPlayer==board.length-1) currentPlayer=0;
      else currentPlayer++;
      board[currentPlayer]++;
  }

    }

    //added for testing
    public int[] getBoard(){return board;}
    //added for testing
    public int getCurrentPlayer(){return currentPlayer;}
    
}
