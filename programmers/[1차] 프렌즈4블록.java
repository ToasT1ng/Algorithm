// https://programmers.co.kr/learn/courses/30/lessons/17679

import java.util.*;

class Node {
    int i;
    int j;
    public Node(int i, int j) {
        this.i = i;
        this.j = j;
    }
    
    @Override
    public String toString() {
        return "{i=" + this.i + ",j=" + this.j + "}";
    }
    
    // public String toSetString() {
    //     return this.i + "_" + this.j;
    // }
    
    @Override
    public boolean equals(Object o) {
        Node node = (Node) o;
        return (this.i == node.i) && (this.j == node.j);
    }
    
    @Override
    public int hashCode() {
        return i * 1000 + j;
    }
    
}

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        
        for (int i=0 ; i<m ; i++) {
            for (int j=0 ; j<n ; j++) {
                Set<Node> result = catchBlocks(m,n,board,i,j);
                answer += result.size();
                eraseBlocks(result, board);
            }
        }
        return answer;
    }
    
    public void eraseBlocks(Set<Node> result, String[] board) {
        for (Node eachNode : result) {
            StringBuilder builder = new StringBuilder(board[eachNode.i]);
            builder.setCharAt(eachNode.j, 'E');
            board[eachNode.i] = builder.toString();
        }
        for (int i=0 ; i<board.length ; i++) {
            for (int j=0 ; j<board[i].length() ; j++) {
                if (i != 0 && Character.compare(board[i].charAt(j), 'E') == 0) {
                    StringBuilder up = new StringBuilder(board[i-1]);
                    char temp = up.charAt(j);
                    up.setCharAt(j, 'E');
                    board[i-1] = up.toString();
                    
                    StringBuilder current = new StringBuilder(board[i]);
                    current.setCharAt(j, temp);
                    board[i] = current.toString();
                }
            }
        }
    }
    
    public Set<Node> catchBlocks(int m, int n, String[] board, int firstIIndex, int firstJIndex) {
        
        boolean[][] visited = new boolean[m][n];
        
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(firstIIndex,firstJIndex));
        
        
        visited[firstIIndex][firstJIndex] = true;
        
        int[] nextI = {0,1,1};
        int[] nextJ = {1,0,1};
        
        Set<Node> totalSet = new LinkedHashSet<>();
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            char currentChar = board[current.i].charAt(current.j);
            if (Character.compare(currentChar, 'E') == 0) {
                continue;
            }
            
            visited[current.i][current.j] = true;
            
            Set<Node> set = new LinkedHashSet<>();
            set.add(current);
            for (int nextIndex=0 ; nextIndex < nextI.length ; nextIndex++) {
                int nextIIndex = current.i + nextI[nextIndex];
                int nextJIndex = current.j + nextJ[nextIndex];
                if (nextIIndex >= 0 && nextJIndex >= 0 && nextIIndex < m && nextJIndex < n) {
                    if (!visited[nextIIndex][nextJIndex]) {
                        char nextChar = board[nextIIndex].charAt(nextJIndex); 
                        if (Character.compare(currentChar, nextChar) == 0) {
                            Node next = new Node(nextIIndex, nextJIndex);
                            queue.offer(next);
                            visited[nextIIndex][nextJIndex] = true;
                            set.add(next);
                        }
                    }
                }
            }
            if (set.size() >= 4) totalSet.addAll(set);
            for (Node eachNode : set) {
                visited[eachNode.i][eachNode.j] = false;
            }
        }
        
        for (Node eachNode : totalSet) {
            visited[eachNode.i][eachNode.j] = true;
        }
        // System.out.println(Integer.toString(firstIIndex) + " " + Integer.toString(firstJIndex) + totalSet.toString());
        
        return totalSet;
    }
}
