package is.gogg.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import org.junit.Test;

public class BoardTest {
/*
    @Test
    public void checkForWinTest()
    {
    
    	TicTacToeGame game = new TicTacToeGame();
   		
   		game.makeTurn('x',0);
		game.makeTurn('x',1);
   		game.makeTurn('x',2);

    	assertTrue(game.isGameOver());

    }
*/

	@Test
	public void testMakeTurnWithInvalidIndex()
	{
		Board b = new Board();
		for(int i = 9; i < 2500; i = i * 2)
		{
			assertFalse(b.makeTurn('X', i));
		}
		for(int i = -4; i < 600; i = i * 3)
		{
			assertFalse(b.makeTurn('X', i));
		}
	}
	
	@Test
	public void testMakeTurnWithValidIndex()
	{
		Board b = new Board();
		for(int i = 0; i <= 8; i++)
		{
			assertTrue(b.makeTurn('X', i));
		}
	}
	
	@Test
	public void testMakeTurnWithInvalidSquare()
	{
		Board b = new Board();
		boolean temp;
		for(int i = 0; i <= 8; i++)
		{
			temp = b.makeTurn('X', i);
		}
		for(int i = 0; i <= 8; i++)
		{
			assertFalse(b.makeTurn('X', i));
		}
	}
	
	@Test
    public void checkForWinTest()
    {

	    // all possible winning combinationi
	    int[] number = new int[] {0,1,2,3,4,5,6,7,8,0,3,6,1,4,7,2,5,8,0,4,8,2,4,6};
		boolean temp;
   	    for(int i = 0; i < 24; i = i + 3)
	     {
		    Board game = new Board();
			temp = game.makeTurn('X',number[i]);
		    temp = game.makeTurn('X',number[i+1]);
   		    temp = game.makeTurn('X',number[i+2]);

    	   	assertTrue(game.checkForWin('X'));
	     }
    }

	@Test
        public void isTakenTest(){
       	
       	Board game = new Board();
     	assertFalse(game.isTaken(0));
     	for (int i  = 0 ; i < 9 ; i++)
     	{
     		game.makeTurn('X',i);
		
     		assertTrue(game.isTaken(i));
		if (i < 8)
		{
			assertFalse(game.isTaken(i+1));
		} 
	}

     	}

	@Test
	public void isTieTest()
	{
		Board game = new Board();
		for (int i = 0; i < 9; i++)
		{
		   if(i == 0 || i == 1 || i == 5 || i == 6 || i ==8)
			{
			   game.makeTurn('X', i);
			}
		  else {
			game.makeTurn('O', i);
			}
		}
		
		assertTrue(game.isTie());
	}
}
