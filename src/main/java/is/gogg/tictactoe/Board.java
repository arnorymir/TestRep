package is.gogg.tictactoe;

public class Board
{
	private char[] squares;

	public Board()
	{
		squares = new char[9];
	}
	
	public Board(char[] theSquares)
	{
		squares = theSquares;
	}

	public boolean makeTurn(char sign, int index)
	{
		// This should never happen since valid index checking is done previously
		if(index < 0 || index > 8)
		{
			return false;
		}
		// Makes a player turn, puts the player's sign in the correct index
		if(!isTaken(index))
		{
			squares[index] = sign;
			return true;
		}
		return false;
	}
	
	public boolean checkForWin(char sign)
	{
		if (squares[0] == sign &&
               	squares[1] == sign &&
               	squares[2] == sign) {
                    return true;
                }

                if (squares[3] == sign &&
                   squares[4] == sign &&
                   squares[5] == sign) {
                    return true;
                }

                if (squares[6] == sign &&
                   squares[7] == sign &&
                   squares[8] == sign) {
                    return true;
                }

                if (squares[0] == sign &&
                   squares[3] == sign &&
                   squares[6] == sign) {
                    return true;
                }

                if (squares[1] == sign &&
                   squares[4] == sign &&
                   squares[7] == sign) {
                    return true;
                }

                if (squares[2] == sign &&
                   squares[5] == sign &&
                   squares[8] == sign) {
                    return true;
                }

                if (squares[0] == sign &&
                   squares[4] == sign &&
                   squares[8] == sign) {
                    return true;
                }

                if (squares[2] == sign &&
                   squares[4] == sign &&
                   squares[6] == sign) {
                    return true;
                }
		return false;
		// Checks if the game is over
	}

	public void draw()
	{
		// This function draws up the board
		char[] letters = new char[3];
		letters[0] = 'A';
		letters[1] = 'B';
		letters[2] = 'C';
		System.out.println("");
		System.out.print("   1 | 2 | 3 ");
		for (int i = 0; i < 9; i++)
		{
			if(i % 3 == 0)
			{
				System.out.println("");
				System.out.print("  -----------");
				System.out.println("");
				System.out.print(letters[((i + 3) / 3) - 1]);
			}
			System.out.print("| " + squares[i] + " ");			
		}
		System.out.println("");
	}

	public boolean isTaken(int number)
        {
        	if (this.squares[number] == 'X' || this.squares[number] == 'O')
        	{
        		return true;
        	}
                return false;
        }

    public boolean isTie()
    {
    	for (int i = 0; i < 9; i++)
    	{
    		if (!isTaken(i))
    		{
    			return false;
    		}
    	}
    	return true;
    }
}