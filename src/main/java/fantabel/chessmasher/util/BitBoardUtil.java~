package com.nightmare.chess.util;

import java.util.ArrayList;
import java.util.List;

public class BitBoardUtil {
    enum Position { A1, B1, C1, D1, E1, F1, G1, H1,
                    A2, B2, C2, D2, E2, F2, G2, H2,
                    A3, B3, C3, D3, E3, F3, G3, H3,
                    A4, B4, C4, D4, E4, F4, G4, H4,
                    A5, B5, C5, D5, E5, F5, G5, H5,
                    A6, B6, C6, D6, E6, F6, G6, H6,
                    A7, B7, C7, D7, E7, F7, G7, H7,
                    A8, B8, C8, D8, E8, F8, G8, H8 };

    public static String padLeft(String s, int n) {
        StringBuffer sb = new StringBuffer();
        for (int prepend = n - s.length() ; prepend > 0 ; prepend--) {
            sb.append("0");
        }
        sb.append(s);
        return sb.toString();
    }

    public static String format8by8(String s) {
        StringBuffer sb = new StringBuffer();
        sb.append(s.substring(0, 8));
        sb.append("\n");
        sb.append(s.substring(8, 16));
        sb.append("\n");
        sb.append(s.substring(16, 24));
        sb.append("\n");
        sb.append(s.substring(24, 32));
        sb.append("\n");
        sb.append(s.substring(32, 40));
        sb.append("\n");
        sb.append(s.substring(40, 48));
        sb.append("\n");
        sb.append(s.substring(48, 56));
        sb.append("\n");
        sb.append(s.substring(56, 64));
        sb.append("\n");

        return sb.toString();
    }

    public static String toStringBB(long BB) {
        return format8by8(padLeft(Long.toBinaryString(BB), 64));
    }
    
    public static int getNextPiecePos(long BB) {
        int i = 0;
        while ( ((BB & (1L << i)) == 0) && (i < 64) ) {
            i++;
        }
        return i != 64 ? i : -1;
    }
    
    public static List<Integer> getListPiecePos(long BB) {
        int pos = BitBoardUtil.getNextPiecePos(BB);
        ArrayList<Integer> posList = new ArrayList<Integer>();
        while (pos != -1) {
            
            posList.add(pos);
            BB = BB ^ 1L << pos;
            pos = BitBoardUtil.getNextPiecePos(BB);
        }
        
        return posList;
    }

    public static void main(String[] args) {
        long WP, WR, WN, WB, WK, WQ, BP, BR, BN, BB, BK, BQ;

        long FULL_BOARD = 0xffffffffffffffffL;

        WP = 0xff00L;
        WR = 0x81L;
        WN = 0x42L;
        WB = 0x24L;
        WK = 0x8L;
        WQ = 0x10L;

        BP = 0xff000000000000L;
        BR = 0x8100000000000000L;
        BN = 0x4200000000000000L;
        BB = 0x2400000000000000L;
        BK = 0x800000000000000L;
        BQ = 0x1000000000000000L;

        long FA, FB, FC, FD, FE, FF, FG, FH;
        long R1, R2, R3, R4, R5, R6, R7, R8;

        FA = 0x8080808080808080L;
        FB = 0x4040404040404040L;
        FC = 0x2020202020202020L;
        FD = 0x1010101010101010L;
        FE = 0x808080808080808L;
        FF = 0x404040404040404L;
        FG = 0x202020202020202L;
        FH = 0x101010101010101L;

        R1 = 0xffL;
        R2 = 0xff00L;
        R3 = 0xff0000L;
        R4 = 0xff000000L;
        R5 = 0xff00000000L;
        R6 = 0xff0000000000L;
        R7 = 0xff000000000000L;
        R8 = 0xff00000000000000L;
        
        long DA1, DB1, DC1, DD1, DE1, DF1, DG1, DH1, DH2, DH3, DH4, DH5, DH6, DH7, DH8;
        long ADA8, ADA7, ADA6, ADA5, ADA4, ADA3, ADA2, ADA1, ADB1, ADC1, ADD1, ADE1, ADF1, ADG1, ADH1;
        
        DA1 = 0x80L;
        DB1 = 0x8040L;
        DC1 = 0X804020L;
        DD1 = 0X80402010L;
        DE1 = 0X8040201008L;
        DF1 = 0X804020100804L;
        DG1 = 0X80402010080402L;
        DH1 = 0X8040201008040201L;
        DH2 = 0X4020100804020100L;
        DH3 = 0X2010080402010000L;
        DH4 = 0X1008040201000000L;
        DH5 = 0X804020100000000L;
        DH6 = 0X402010000000000L;
        DH7 = 0X201000000000000L;
        DH8 = 0X100000000000000L;
        
        ADA8 = Long.reverseBytes(DA1);
        ADA7 = Long.reverseBytes(DB1);
        ADA6 = Long.reverseBytes(DC1);
        ADA5 = Long.reverseBytes(DD1);
        ADA4 = Long.reverseBytes(DE1);
        ADA3 = Long.reverseBytes(DF1);
        ADA2 = Long.reverseBytes(DG1);
        ADA1 = Long.reverseBytes(DH1);
        ADB1 = Long.reverseBytes(DH2);
        ADC1 = Long.reverseBytes(DH3);
        ADD1 = Long.reverseBytes(DH4);
        ADE1 = Long.reverseBytes(DH5);
        ADF1 = Long.reverseBytes(DH6);
        ADG1 = Long.reverseBytes(DH7);
        ADH1 = Long.reverseBytes(DH8);

        long meow = WP | WR | WN | WB | WK | WQ | BP | BR | BN | BB | BK | BQ;
        long time;
        long prev_time = System.currentTimeMillis();
        
        long temp =
                0L << 63 | 0L << 62 | 0L << 61 | 0L << 60 | 0L << 59 | 0L << 58 | 0L << 57 | 0L << 56 |
                0L << 55 | 0L << 54 | 0L << 53 | 0L << 52 | 0L << 51 | 0L << 50 | 0L << 49 | 0L << 48 |
                0L << 47 | 0L << 46 | 0L << 45 | 0L << 44 | 0L << 43 | 0L << 42 | 0L << 41 | 0L << 40 |
                0L << 39 | 0L << 38 | 0L << 37 | 0L << 36 | 0L << 35 | 0L << 34 | 0L << 33 | 0L << 32 |
                0L << 31 | 0L << 30 | 0L << 29 | 0L << 28 | 0L << 27 | 0L << 26 | 0L << 25 | 0L << 24 |
                0L << 23 | 0L << 22 | 0L << 21 | 0L << 20 | 0L << 19 | 0L << 18 | 0L << 17 | 0L << 16 |
                1L << 15 | 1L << 14 | 1L << 13 | 0L << 12 | 0L << 11 | 0L << 10 | 0L << 9  | 0L << 8  |
                1L << 7  | 0L << 6  | 1L << 5  | 0L << 4  | 0L << 3  | 0L << 2  | 0L << 1  | 0L << 0;
        
        long pos = 0x800L;
        // Kings move generation
        pos = 
                pos << 9L & (FH ^ FULL_BOARD) | pos << 8L | pos << 7L & (FA ^ FULL_BOARD) |
                pos << 1L & (FH ^ FULL_BOARD) |    0L     | pos >> 1L & (FA ^ FULL_BOARD) |
                pos >> 7L & (FH ^ FULL_BOARD) | pos >> 8L | pos >> 9L & (FA ^ FULL_BOARD);

        long[] KING_ATTACKS = new long[64];
        for (int i = 0 ; i < KING_ATTACKS.length ; i++) {
            pos = 1L << i;
            KING_ATTACKS[i] = pos <<  9L & (FH ^ FULL_BOARD) | pos <<  8L | pos <<  7L & (FA ^ FULL_BOARD) |
                              pos <<  1L & (FH ^ FULL_BOARD) |     0L     | pos >>> 1L & (FA ^ FULL_BOARD) |
                              pos >>> 7L & (FH ^ FULL_BOARD) | pos >>> 8L | pos >>> 9L & (FA ^ FULL_BOARD);
        }
        
        long[] ROOK_ATTACKS = new long[64];
        
        for (int i = 0 ; i < ROOK_ATTACKS.length ; i++) {
            pos = 1L << i;
            
            ROOK_ATTACKS[i] = ((pos & FA) == 0L) ? ROOK_ATTACKS[i] : FA;
            ROOK_ATTACKS[i] = ((pos & FB) == 0L) ? ROOK_ATTACKS[i] : FB;
            ROOK_ATTACKS[i] = ((pos & FC) == 0L) ? ROOK_ATTACKS[i] : FC;
            ROOK_ATTACKS[i] = ((pos & FD) == 0L) ? ROOK_ATTACKS[i] : FD;
            ROOK_ATTACKS[i] = ((pos & FE) == 0L) ? ROOK_ATTACKS[i] : FE;
            ROOK_ATTACKS[i] = ((pos & FF) == 0L) ? ROOK_ATTACKS[i] : FF;
            ROOK_ATTACKS[i] = ((pos & FG) == 0L) ? ROOK_ATTACKS[i] : FG;
            ROOK_ATTACKS[i] = ((pos & FH) == 0L) ? ROOK_ATTACKS[i] : FH;
            
            ROOK_ATTACKS[i] = ((pos & R1) == 0L) ? ROOK_ATTACKS[i] : ROOK_ATTACKS[i] | R1;
            ROOK_ATTACKS[i] = ((pos & R2) == 0L) ? ROOK_ATTACKS[i] : ROOK_ATTACKS[i] | R2;
            ROOK_ATTACKS[i] = ((pos & R3) == 0L) ? ROOK_ATTACKS[i] : ROOK_ATTACKS[i] | R3;
            ROOK_ATTACKS[i] = ((pos & R4) == 0L) ? ROOK_ATTACKS[i] : ROOK_ATTACKS[i] | R4;
            ROOK_ATTACKS[i] = ((pos & R5) == 0L) ? ROOK_ATTACKS[i] : ROOK_ATTACKS[i] | R5;
            ROOK_ATTACKS[i] = ((pos & R6) == 0L) ? ROOK_ATTACKS[i] : ROOK_ATTACKS[i] | R6;
            ROOK_ATTACKS[i] = ((pos & R7) == 0L) ? ROOK_ATTACKS[i] : ROOK_ATTACKS[i] | R7;
            ROOK_ATTACKS[i] = ((pos & R8) == 0L) ? ROOK_ATTACKS[i] : ROOK_ATTACKS[i] | R8;
            
            ROOK_ATTACKS[i] = ROOK_ATTACKS[i] ^ pos;
        }
        
        long[] BISHOP_ATTACKS = new long[64];
        
        for (int i = 0 ; i < BISHOP_ATTACKS.length ; i++) {
            pos = 1L << i;
            BISHOP_ATTACKS[i] = ((pos & DA1) == 0L) ? BISHOP_ATTACKS[i] : DA1;
            BISHOP_ATTACKS[i] = ((pos & DB1) == 0L) ? BISHOP_ATTACKS[i] : DB1;
            BISHOP_ATTACKS[i] = ((pos & DC1) == 0L) ? BISHOP_ATTACKS[i] : DC1;
            BISHOP_ATTACKS[i] = ((pos & DD1) == 0L) ? BISHOP_ATTACKS[i] : DD1;
            BISHOP_ATTACKS[i] = ((pos & DE1) == 0L) ? BISHOP_ATTACKS[i] : DE1;
            BISHOP_ATTACKS[i] = ((pos & DF1) == 0L) ? BISHOP_ATTACKS[i] : DF1;
            BISHOP_ATTACKS[i] = ((pos & DG1) == 0L) ? BISHOP_ATTACKS[i] : DG1;
            BISHOP_ATTACKS[i] = ((pos & DH1) == 0L) ? BISHOP_ATTACKS[i] : DH1;
            BISHOP_ATTACKS[i] = ((pos & DH2) == 0L) ? BISHOP_ATTACKS[i] : DH2;
            BISHOP_ATTACKS[i] = ((pos & DH3) == 0L) ? BISHOP_ATTACKS[i] : DH3;
            BISHOP_ATTACKS[i] = ((pos & DH4) == 0L) ? BISHOP_ATTACKS[i] : DH4;
            BISHOP_ATTACKS[i] = ((pos & DH5) == 0L) ? BISHOP_ATTACKS[i] : DH5;
            BISHOP_ATTACKS[i] = ((pos & DH6) == 0L) ? BISHOP_ATTACKS[i] : DH6;
            BISHOP_ATTACKS[i] = ((pos & DH7) == 0L) ? BISHOP_ATTACKS[i] : DH7;
            BISHOP_ATTACKS[i] = ((pos & DH8) == 0L) ? BISHOP_ATTACKS[i] : DH8;
            
            BISHOP_ATTACKS[i] = ((pos & ADA8) == 0L) ? BISHOP_ATTACKS[i] : BISHOP_ATTACKS[i] | ADA8;
            BISHOP_ATTACKS[i] = ((pos & ADA7) == 0L) ? BISHOP_ATTACKS[i] : BISHOP_ATTACKS[i] | ADA7;
            BISHOP_ATTACKS[i] = ((pos & ADA6) == 0L) ? BISHOP_ATTACKS[i] : BISHOP_ATTACKS[i] | ADA6;
            BISHOP_ATTACKS[i] = ((pos & ADA5) == 0L) ? BISHOP_ATTACKS[i] : BISHOP_ATTACKS[i] | ADA5;
            BISHOP_ATTACKS[i] = ((pos & ADA4) == 0L) ? BISHOP_ATTACKS[i] : BISHOP_ATTACKS[i] | ADA4;
            BISHOP_ATTACKS[i] = ((pos & ADA3) == 0L) ? BISHOP_ATTACKS[i] : BISHOP_ATTACKS[i] | ADA3;
            BISHOP_ATTACKS[i] = ((pos & ADA2) == 0L) ? BISHOP_ATTACKS[i] : BISHOP_ATTACKS[i] | ADA2;
            BISHOP_ATTACKS[i] = ((pos & ADA1) == 0L) ? BISHOP_ATTACKS[i] : BISHOP_ATTACKS[i] | ADA1;
            BISHOP_ATTACKS[i] = ((pos & ADB1) == 0L) ? BISHOP_ATTACKS[i] : BISHOP_ATTACKS[i] | ADB1;
            BISHOP_ATTACKS[i] = ((pos & ADC1) == 0L) ? BISHOP_ATTACKS[i] : BISHOP_ATTACKS[i] | ADC1;
            BISHOP_ATTACKS[i] = ((pos & ADD1) == 0L) ? BISHOP_ATTACKS[i] : BISHOP_ATTACKS[i] | ADD1;
            BISHOP_ATTACKS[i] = ((pos & ADE1) == 0L) ? BISHOP_ATTACKS[i] : BISHOP_ATTACKS[i] | ADE1;
            BISHOP_ATTACKS[i] = ((pos & ADF1) == 0L) ? BISHOP_ATTACKS[i] : BISHOP_ATTACKS[i] | ADF1;
            BISHOP_ATTACKS[i] = ((pos & ADG1) == 0L) ? BISHOP_ATTACKS[i] : BISHOP_ATTACKS[i] | ADG1;
            BISHOP_ATTACKS[i] = ((pos & ADH1) == 0L) ? BISHOP_ATTACKS[i] : BISHOP_ATTACKS[i] | ADH1;
            
            BISHOP_ATTACKS[i] = BISHOP_ATTACKS[i] ^ pos;
        }
        
        long[] QUEEN_ATTACK = new long[64];
        
        for (int i = 0 ; i < BISHOP_ATTACKS.length ; i++) {
            pos = 1L << i;
            QUEEN_ATTACK[i] = ((pos & DA1) == 0L) ? QUEEN_ATTACK[i] : DA1;
            QUEEN_ATTACK[i] = ((pos & DB1) == 0L) ? QUEEN_ATTACK[i] : DB1;
            QUEEN_ATTACK[i] = ((pos & DC1) == 0L) ? QUEEN_ATTACK[i] : DC1;
            QUEEN_ATTACK[i] = ((pos & DD1) == 0L) ? QUEEN_ATTACK[i] : DD1;
            QUEEN_ATTACK[i] = ((pos & DE1) == 0L) ? QUEEN_ATTACK[i] : DE1;
            QUEEN_ATTACK[i] = ((pos & DF1) == 0L) ? QUEEN_ATTACK[i] : DF1;
            QUEEN_ATTACK[i] = ((pos & DG1) == 0L) ? QUEEN_ATTACK[i] : DG1;
            QUEEN_ATTACK[i] = ((pos & DH1) == 0L) ? QUEEN_ATTACK[i] : DH1;
            QUEEN_ATTACK[i] = ((pos & DH2) == 0L) ? QUEEN_ATTACK[i] : DH2;
            QUEEN_ATTACK[i] = ((pos & DH3) == 0L) ? QUEEN_ATTACK[i] : DH3;
            QUEEN_ATTACK[i] = ((pos & DH4) == 0L) ? QUEEN_ATTACK[i] : DH4;
            QUEEN_ATTACK[i] = ((pos & DH5) == 0L) ? QUEEN_ATTACK[i] : DH5;
            QUEEN_ATTACK[i] = ((pos & DH6) == 0L) ? QUEEN_ATTACK[i] : DH6;
            QUEEN_ATTACK[i] = ((pos & DH7) == 0L) ? QUEEN_ATTACK[i] : DH7;
            QUEEN_ATTACK[i] = ((pos & DH8) == 0L) ? QUEEN_ATTACK[i] : DH8;
            
            QUEEN_ATTACK[i] = ((pos & ADA8) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | ADA8;
            QUEEN_ATTACK[i] = ((pos & ADA7) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | ADA7;
            QUEEN_ATTACK[i] = ((pos & ADA6) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | ADA6;
            QUEEN_ATTACK[i] = ((pos & ADA5) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | ADA5;
            QUEEN_ATTACK[i] = ((pos & ADA4) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | ADA4;
            QUEEN_ATTACK[i] = ((pos & ADA3) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | ADA3;
            QUEEN_ATTACK[i] = ((pos & ADA2) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | ADA2;
            QUEEN_ATTACK[i] = ((pos & ADA1) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | ADA1;
            QUEEN_ATTACK[i] = ((pos & ADB1) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | ADB1;
            QUEEN_ATTACK[i] = ((pos & ADC1) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | ADC1;
            QUEEN_ATTACK[i] = ((pos & ADD1) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | ADD1;
            QUEEN_ATTACK[i] = ((pos & ADE1) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | ADE1;
            QUEEN_ATTACK[i] = ((pos & ADF1) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | ADF1;
            QUEEN_ATTACK[i] = ((pos & ADG1) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | ADG1;
            QUEEN_ATTACK[i] = ((pos & ADH1) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | ADH1;
            
            QUEEN_ATTACK[i] = ((pos & FA) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | FA;
            QUEEN_ATTACK[i] = ((pos & FB) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | FB;
            QUEEN_ATTACK[i] = ((pos & FC) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | FC;
            QUEEN_ATTACK[i] = ((pos & FD) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | FD;
            QUEEN_ATTACK[i] = ((pos & FE) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | FE;
            QUEEN_ATTACK[i] = ((pos & FF) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | FF;
            QUEEN_ATTACK[i] = ((pos & FG) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | FG;
            QUEEN_ATTACK[i] = ((pos & FH) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | FH;
            
            QUEEN_ATTACK[i] = ((pos & R1) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | R1;
            QUEEN_ATTACK[i] = ((pos & R2) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | R2;
            QUEEN_ATTACK[i] = ((pos & R3) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | R3;
            QUEEN_ATTACK[i] = ((pos & R4) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | R4;
            QUEEN_ATTACK[i] = ((pos & R5) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | R5;
            QUEEN_ATTACK[i] = ((pos & R6) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | R6;
            QUEEN_ATTACK[i] = ((pos & R7) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | R7;
            QUEEN_ATTACK[i] = ((pos & R8) == 0L) ? QUEEN_ATTACK[i] : QUEEN_ATTACK[i] | R8;
            
            QUEEN_ATTACK[i] = QUEEN_ATTACK[i] ^ pos;
        }
        
        List<Integer> liste = BitBoardUtil.getListPiecePos(FA);
        
        System.out.println(BitBoardUtil.toStringBB(QUEEN_ATTACK[29]));
        
        /*      
        KING_ATTACKS[0] = 0xc040L;
        KING_ON_A2 = 0xe0a0L;
        KING_ON_A3 = 0x7050L;
        KING_ON_A4 = 0x3828L;
        KING_ON_A5 = 0x1c14L;
        KING_ON_A6 = 0xe0aL;
        KING_ON_A7 = 0x705L;
        KING_ON_A8 = 0x302L;
        KING_ON_B1 = 0x0L;
        KING_ON_B2 = 0xe0a0e0L;
        KING_ON_B3 = 0x0L;
        KING_ON_B4 = 0x0L;
        KING_ON_B5 = 0x0L;
        KING_ON_B6 = 0x0L;
        KING_ON_B7 = 0x0L;
        KING_ON_B8 = 0x0L;

        System.out.println(toStringBB(pos));
        System.out.println(Long.toHexString(pos));
        System.out.println(temp);
*/        
        /*
        time = System.currentTimeMillis() - prev_time;

        System.out.println("Time after " + time);
        */
    }
}
