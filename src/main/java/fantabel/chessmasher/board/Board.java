package fantabel.chessmasher.board;

import fantabel.chessmasher.util.BitBoardUtil;

public class Board {
	private long whitePawns;
	private long whiteRooks;
	private long whiteKnights;
	private long whiteBishops;
	private long whiteQueen;
	private long whiteKing;

	private long blackPawns;
	private long blackRooks;
	private long blackKnights;
	private long blackBishops;
	private long blackQueen;
	private long blackKing;

	public Board() {
		whitePawns = BitBoardUtil.WHITE_PAWN_STARTING_POSITION;
		whiteRooks = BitBoardUtil.WHITE_ROOK_STATRING_POSITION;
		whiteKnights = BitBoardUtil.WHITE_KNIGHT_STARTING_POSITION;
		whiteBishops = BitBoardUtil.WHITE_BISHOP_STARTING_POSITION;
		whiteQueen = BitBoardUtil.WHITE_QUEEN_STARTING_POSITION;
		whiteKing = BitBoardUtil.WHITE_KING_STARTING_POSITION;

		blackPawns = BitBoardUtil.BLACK_PAWN_STARTING_POSITION;
		blackRooks = BitBoardUtil.BLACK_ROOK_STARTING_POSITION;
		blackKnights = BitBoardUtil.BLACK_KNIGHT_STARTING_POSITION;
		blackBishops = BitBoardUtil.BLACK_BISHOP_STARTING_POSITION;
		blackQueen = BitBoardUtil.BLACK_QUEEN_STARTING_POSITION;
		blackKing = BitBoardUtil.BLACK_KING_STARTING_POSITION;

		System.out.println("Creating a board");
		StringBuffer sb = new StringBuffer();
		sb.append("h g f e d c b a  \n" +
				"+-+-+-+-+-+-+-+-+ \n" +
				"|r|n|b|q|k|b|n|r|1\n" +
				"+-+-+-+-+-+-+-+-+ \n" +
				"|p|p|p|p|p|p|p|p|2\n" +
				"+-+-+-+-+-+-+-+-+ \n" +
				"| |.| |.| |.| |.|3\n" +
				"+-+-+-+-+-+-+-+-+ \n" +
				"|.| |.| |.| |.| |4\n" +
				"+-+-+-+-+-+-+-+-+ \n" +
				"| |.| |.| |.| |.|5\n" +
				"+-+-+-+-+-+-+-+-+ \n" +
				"|.| |.| |.| |.| |6\n" +
				"+-+-+-+-+-+-+-+-+ \n" +
				"|P|P|P|P|P|P|P|P|7\n" +
				"+-+-+-+-+-+-+-+-+ \n" +
				"|R|N|B|Q|K|B|N|R|8\n" +
				"+-+-+-+-+-+-+-+-+ \n");
		sb.reverse();
		System.out.println(sb.toString());
		System.out.println(BitBoardUtil.toStringBB(0x8000000000000000L));

		System.out.println("--------");
		System.out.println(BitBoardUtil.toStringBB(0x8000000000000000L >>> 1));
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();

		sb.append("\n  +-+-+-+-+-+-+-+-+\n");
		for (int i = 0 ; i < 64 ; i++) {
			int row = ((64 - i) / 8);
			String color = (i / 8) % 2 == 0 ? " " : ".";
			String noColor = (i / 8) % 2 == 0 ? "." : " ";
			
			if (i % 8 == 0) {
				sb.append(row);
				sb.append(" ");
			}

			sb.append("|");
			
			long currentPos = 0x8000000000000000L >>> i;
			if ((currentPos & whitePawns) != 0) {
				sb.append("P");
			
			} else if ((currentPos & whiteRooks) != 0) {
				sb.append("R");
			
			} else if ((currentPos & whiteKnights) != 0) {
				sb.append("N");
			
			} else if ((currentPos & whiteBishops) != 0) {
				sb.append("B");
			
			} else if ((currentPos & whiteQueen) != 0) {
				sb.append("Q");
			
			} else if ((currentPos & whiteKing) != 0) {
				sb.append("K");
			
			} else if ((currentPos & blackPawns) != 0) {
				sb.append("p");
			
			} else if ((currentPos & blackRooks) != 0) {
				sb.append("r");
			
			} else if ((currentPos & blackKnights) != 0) {
				sb.append("n");
			
			} else if ((currentPos & blackBishops) != 0) {
				sb.append("b");
			
			} else if ((currentPos & blackQueen) != 0) {
				sb.append("q");
			
			} else if ((currentPos & blackKing) != 0) {
				sb.append("k");
			
			} else {
				sb.append(i % 2 == 0 ? color : noColor);
			
			}
			
			sb.append(i % 8 == 7 ? "|\n  +-+-+-+-+-+-+-+-+\n" : "");
		}
		
		sb.append("   a b c d e f g h\n");

		return sb.toString();
	}
}
