
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

/**
 * The test class TokenPassTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class TokenPassTest
{
    /**
     * Default constructor for test class TokenPassTest
     */
    public TokenPassTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void tokenPassConstructorValues()
    {
        TokenPass tokenPas1;
        boolean oneToTen = true;
        for(int i =0;i<20;i++){
            tokenPas1= new TokenPass(10);
            int[] board = tokenPas1.getBoard();

            for(int x:board){
                if(x<1||x>10){
                    oneToTen = false;
                }
            }
        }
        assertTrue("All tokens assigned should be between 1 and 10, inclusive",oneToTen);
    }

    @Test
    public void tokenPassConstructorSize()
    {
        TokenPass tokenPas1= new TokenPass(10);
        assertEquals("The board size is incorrect",10,tokenPas1.getBoard().length);
    }
    
    
    @Test
    public void distributeTokens()
    {
        int numPlayers =5;
        TokenPass tokenPas1= new TokenPass(numPlayers);
        int[] board = tokenPas1.getBoard();
        int currentPlayer = tokenPas1.getCurrentPlayer();
        int[] expected = Arrays.copyOf(board,board.length);
        tokenPas1.distributeCurrentPlayerTokens();
        
        int nextPlayer = currentPlayer;
        int numToDistribute = expected[currentPlayer];
        expected[currentPlayer] = 0;
        while (numToDistribute > 0){
            nextPlayer = (nextPlayer + 1) % expected.length;
            expected[nextPlayer]++;
            numToDistribute--;
        } 
        assertArrayEquals("Tokens were not distributed correctly",expected, tokenPas1.getBoard());
    }
}

