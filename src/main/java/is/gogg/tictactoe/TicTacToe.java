package is.gogg.tictactoe;

import java.util.Scanner;
import static spark.Spark.*;
import spark.*;

public class TicTacToe
{
		private static Board board;
		private static Player p1;
		private static Player p2;
		
		public TicTacToe(Board b, Player player1, Player player2)
		{
			board = b;
			p1 = player1;
			p2 = player2;
		}
		
		public void playGame()
		{
			boolean p1Turn;
			if(p1.getMarker() == 'X')
			{
				p1Turn = true;
			}
			else
			{
				p1Turn = false;
			}
			for(int i = 0; i < 9; i++)
			{
				board.draw();
				boolean validTurn;
				if(p1Turn)
				{
					do
					{
						validTurn = board.makeTurn(p1.getMarker(), p1.getPlayerMove());
					}while(!validTurn);
					if(board.checkForWin(p1.getMarker()))
					{
						System.out.println(p1.getMarker() + " is winner!");
						return;
					}
				}
				else
				{
					do
					{
						validTurn = board.makeTurn(p2.getMarker(), p2.getPlayerMove());
					}while(!validTurn);
					if(board.checkForWin(p1.getMarker()))
					{
						System.out.println(p1.getMarker() + " is winner!");
						return;
					}
				}
				p1Turn = !p1Turn;
			}
		}
		
        public static void main(String[] args)
        {
			Scanner sc = new Scanner(System.in);
			char marker;
			do
			{
				System.out.println("Welcome to tic-tac-toe, would you like to play as x or o? ");
				marker = Character.toUpperCase(sc.findInLine(".").charAt(0));
			}while(marker != 'x' && marker != 'X' && marker != 'o' && marker != 'O');
			Player human = new Player(true, marker);
			Player cpu;
			if(marker == 'X')
			{
				cpu = new Player(false, 'O');
			}
			else
			{
				cpu = new Player(false, 'X');
			}
            System.out.println("Let's play");
			Board b = new Board();
			TicTacToe tictactoe = new TicTacToe(b, human, cpu);
			tictactoe.playGame();
        }
}
