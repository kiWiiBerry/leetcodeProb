package com.yiyiwii.leetcode.editor.en;
//
//PersonA is playing checkers with his friend PersonB. Checkers is a board game in which both
// players take tums to move their pawns. PersonA has just one pawn left, and he is going to
// take a final turn, beating as many of PersonB's pawns as possible.
//
//Pawns in checkers move diagonally. The pawn always moves one step in the up-right or up-left
// direction. If PersonA's pawn moves and its target field is occupied by one of PersonB's pawns,
// PersonB's pawn can be beaten: PersonA's pawn leaps over PersonB's pawn. taking two steps
// In the chosen direction and removing PersonB's pawn from the board. PersonA can beat PersonB's pawn
// in this way only when the field beyond PersonB's pawn is empty.
//
//After beating PersonB's pawn. PersonA can continue his turn and make another move, but only if he will
// again beat another one of PersonB's pawns Of course. after this additional move, PersonA can continue
// his turn again by beating another of PersonB's pawns, and so on for as long as there are further pawns
// to beat. When it is no longer possible to beat one of PersonB's pawns, PersonA's turn ends The maximum
// number of pawns owned by PersonB that PersonA can beat in his turn
//
//This is the algorithm which, gives a square board of N x N size describing PersonB and PersonA pawns,
// returns the maximum number of pawns personA can beat in one turn. If none of personB’s pawns can be
// beaten, the algorithm should return 0. Person’s pawn is describing by the ‘O’ character, PersonB’s pawns
// by ‘X’ character and empty fields by ‘.’(dots). The board is describing from top to bottom and from the
// left to right.
//
//For example, given, B[0] = “..X…” B[1] = “……” B[2] = “….X.” B[3] = “.X.…” B[4] = “..X.X.” B[5] = “…O..”
//
//The function returns 2
//
//Given input B[0] = “X….” B[1] = ”.X…” B[2] = “..O..” B[3] = “…X.” B[4] = “…..”
//
//This functions returns 0.
//}

import java.util.Stack;

public class JafarCheckerGame {
    // Similar as Max Depth of Binary Tree
    // Iterative method
    public int solution(String[] B) {
        char jafar = 'O';
        char aladdin = 'X';
        int max = 0;
        int colN = B[0].length();
        int jafarPosCol = 0, jafarPosRow = 0;
        for(int i = 0; i < B.length; i++) {
            String value = B[i];
            if (value.indexOf(jafar) > 0) {
                jafarPosCol = value.indexOf(jafar);
                jafarPosRow = i;
            }
        }

        Stack<int[]> stack = new Stack<>();
        Stack<Integer> cnt = new Stack<>();
        stack.push(new int[]{jafarPosRow, jafarPosCol});
        cnt.push(0);

        while (!stack.isEmpty()) {
            int[] currNode = stack.pop();
            int temp = cnt.pop();
            max = Math.max(temp, max);
            if (currNode[0] < 2) {
                continue;
            } else {
                int jafarPos = currNode[1];
                String alaFirstR = B[currNode[0] - 1];
                String alaSecondR = B[currNode[0] - 2];

                if (jafarPos >= 2 && alaFirstR.charAt(jafarPos - 1) == aladdin
                        && alaSecondR.charAt(jafarPos - 2) == '.') {
                    stack.push(new int[]{currNode[0] - 2, jafarPos - 2});
                    cnt.push(temp + 1);
                }
                if (jafarPos < colN - 2 && alaFirstR.charAt(jafarPos + 1) == aladdin
                        && alaSecondR.charAt(jafarPos + 2) == '.') {
                    stack.push(new int[]{currNode[0] - 2, jafarPos + 2});
                    cnt.push(temp + 1);
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String input[]= {
                "..X...",
                "......",
                "....X.",
                ".X.O..",
                "..X.X.",
                "......"
        };
        String input2[]= {
                "X....",
                ".X...",
                "..O..",
                "...X.",
                ".....",
        };
        String input3[]= {
                "..X...",
                "......",
                "....X.",
                "......",
                "..X.X.",
                "...O.."
        };
        JafarCheckerGame ch=new JafarCheckerGame();
        System.out.println(ch.solution(input));
        System.out.println(ch.solution(input2));
        System.out.println(ch.solution(input3));
    }
}