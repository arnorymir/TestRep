package is.gogg.tictactoe;

import java.io.Console;
import java.util.Random;

public class Player
{
	private char marker;
	private boolean isHuman;
	
	Player()
	{
		marker = 'X';
		isHuman = true;
	}
	
	// Initializes mark to 'X' if isHuman is true, 'O' otherwise
	public Player(boolean isHuman)
	{
		if(isHuman)
		{
			marker = 'X';
		}
		else
		{
			marker = 'O';
		}
	}
	
	public Player(boolean species, char sign)
	{
		marker = sign;
		isHuman = species;
	}
	
	public char getMarker()
	{
		return marker;
	}
	
	public boolean isHuman()
	{
		return isHuman;
	}
	
	public int getPlayerMove()
	{
		if(isHuman)
		{
			return getHumanMove();
		}
		return getComputerMove();
	}
	
	public int getHumanMove()
	{
		Console console = System.console();
		String input = console.readLine("Select a square and press enter: ");
		return getHumanMove(input);
	}
	
	public int getHumanMove(String coord)
	{
		char letter = Character.toUpperCase(coord.charAt(0));
		int multiplier = ((int) letter) - 65;
		return multiplier * 3 + Character.getNumericValue(coord.charAt(1)) - 1;
	}
	
	public int getComputerMove()
	{
		Random randomGenerator = new Random();
		int index = randomGenerator.nextInt(9);
		return index;
	}
}