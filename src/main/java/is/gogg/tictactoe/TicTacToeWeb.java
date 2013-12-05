package is.gogg.tictactoe;

import java.util.Scanner;
import static spark.Spark.*;
import spark.*;

public class TicTacToeWeb
{
		private static Board board;
		private static Player p1;
		private static Player p2;
		
		public TicTacToeWeb(Board b, Player player1, Player player2)
		{
			board = b;
			p1 = player1;
			p2 = player2;
		}
		
        public static void main(String[] args)
        {
			staticFileLocation("/public");
			setPort(Integer.valueOf(System.getenv("PORT")));
			post(new Route("/setMarker") {
	

            @Override
            public Object handle(Request request, Response response) {
                char marker = Character.toUpperCase(String.valueOf(request.queryParams("marker")).charAt(0));
				System.out.println(marker);
                p1 = new Player(true, marker);
				if(marker == 'X')
				{
					p2 = new Player(false, 'O');
				}
				else
				{
					p2 = new Player(false, 'X');
				}
				board = new Board();
				return marker;
            }
        });
		post(new Route("/getSquare") {
            @Override
            public Object handle(Request request, Response response) {
				String square = String.valueOf(request.queryParams("square"));
				String valueToReturn = "";
				int p1Square;
				int p2Square;
				boolean valid;
				if(p1.getMarker() == 'X')
				{
					p1Square = p1.getHumanMove(square);
					valid = board.makeTurn(p1.getMarker(), p1Square);
					do
					{
						p2Square = p2.getPlayerMove();
						
						if(board.isTie())
						{
							
							return (String.valueOf(p1Square) + "ht"); 
						}
						valid = board.makeTurn(p2.getMarker(), p2Square);
						
					}while(!valid);
				}
				else
				{
					do
					{
						p2Square = p2.getPlayerMove();
						valid = board.makeTurn(p2.getMarker(), p2Square);
					}while(!valid);
					p1Square = p1.getHumanMove(square);
					valid = board.makeTurn(p1.getMarker(), p1Square);
				}
				valueToReturn = valueToReturn + String.valueOf(p1Square) + String.valueOf(p2Square);
				
				if(board.checkForWin(p1.getMarker()))
				{
					valueToReturn =  valueToReturn + 'w';
				}
				else if(board.checkForWin(p2.getMarker()))
				{
					valueToReturn = valueToReturn + 'l';
				}
				
				return valueToReturn;
            }
        });
        }
}
