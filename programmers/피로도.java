import java.util.*;

class Dungeon {
    int necessary;
    int consume;
    
    public Dungeon(int necessary, int consume) {
        this.necessary = necessary;
        this.consume = consume;
    }
    
    @Override
    public String toString() {
        return "Dungeon{necessary=" + this.necessary + ", consume=" + this.consume + "}";
    }
}

class Solution {
    int answer = -1;
    public int solution(int k, int[][] dungeons) {
        // 처음부터 불가능한 CASE 를 제외한다. 배열대신 class 를 사용한다.
        List<Dungeon> list = new ArrayList<>();
        for (int[] dungeon : dungeons) { 
            if (dungeon[0] <= k) list.add(new Dungeon(dungeon[0], dungeon[1]));
        }
        // dfs 로 돌 수 있는 최댓값을 구한다?
        dfs(0, k, list, new boolean[list.size()], 0);
        return answer;
    }
    
    public void dfs(int index, int k, List<Dungeon> list, boolean[] visited, int result) {
        for (int i=0 ; i<list.size() ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result++;
                if (k-list.get(i).necessary >= 0) {
                    k -= list.get(i).consume;
                    dfs(index+1, k, list, visited, result);
                    k += list.get(i).consume;
                }
                visited[i] = false;
                result--;
            }
        }
        answer = Math.max(answer, result);
    }
}
