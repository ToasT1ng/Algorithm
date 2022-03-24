import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> basket = new Stack<>();
        int count = 0;
        for (int eachMove : moves) {
            int jIndex = eachMove-1;
            for (int i=0 ; i<board[0].length ; i++) {
                int currentDoll = board[i][jIndex];
                if (currentDoll != 0) {
                    System.out.println(currentDoll);
                    if (!basket.isEmpty() && basket.peek() == currentDoll) {
                        basket.pop();
                        count += 2;
                    } else {
                        basket.push(currentDoll);
                    }   
                    board[i][jIndex] = 0;
                    break;
                }
            }
        }
        return count;
    }
}
