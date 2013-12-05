package is.gogg.tictactoe;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import org.junit.Test;
import java.util.ArrayList;


public class PlayerTest {
	@Test
	public void testBoolConstructor() {
		Player p1 = new Player(true);
		assertEquals('X', p1.getMarker());
		
		Player p2 = new Player(false);
		assertEquals('O', p2.getMarker());
   	 }
	 
	 @Test
	 public void testHumanMove()
	 {
		Player p = new Player();
		assertEquals(0, p.getHumanMove("A1"));
		assertEquals(0, p.getHumanMove("a1"));
		assertEquals(1, p.getHumanMove("a2"));
		assertEquals(2, p.getHumanMove("a3"));
		assertEquals(3, p.getHumanMove("b1"));
		assertEquals(4, p.getHumanMove("b2"));
		assertEquals(5, p.getHumanMove("b3"));
		assertEquals(6, p.getHumanMove("c1"));
		assertEquals(7, p.getHumanMove("c2"));
		assertEquals(8, p.getHumanMove("c3"));
	 }
	 
	 @Test
	 public void testComputerMove()
	 {
		// Function returns a random number in the range 0-8, so very rarely this test may fail
		Player p = new Player();
		ArrayList<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < 100; i++)
		{
			int a = p.getComputerMove();
			assertTrue(a >= 0 && a <= 8);
			list.add(a);
		}
		for(int i = 0; i <= 8; i++)
		{
			assertTrue(list.contains(i));
		}
	 }
}