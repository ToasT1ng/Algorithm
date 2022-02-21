import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int moveIndex = 0 ; moveIndex < moves.length ; moveIndex++) {
            for (int i=0 ; i<board.length ; i++) {
                int currentBox = board[i][moves[moveIndex]-1];
                if (currentBox != 0) {
                    if (!stack.isEmpty() && stack.peek() == currentBox) {
                        answer += 2;
                        stack.pop();
                    } else {
                        stack.push(currentBox);
                    }
                    board[i][moves[moveIndex]-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}
