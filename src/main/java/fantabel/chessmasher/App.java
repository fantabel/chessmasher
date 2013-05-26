package fantabel.chessmasher;

import fantabel.chessmasher.util.BitBoardUtil;
import fantabel.chessmasher.board.Board;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
	System.out.println(BitBoardUtil.toStringBB(1L));
	System.out.println("Finally");
	Board myBoard = new Board();
	System.out.println(myBoard.toString());

    }
}
