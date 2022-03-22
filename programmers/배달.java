// https://programmers.co.kr/learn/courses/30/lessons/12978

class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[][] floyd = new int[N][N];
        final int INF = N * 10000 + 1;
        
        for (int i=0 ; i<N ; i++) {
            for (int j=0 ; j<N ; j++) {
                if (i != j) floyd[i][j] = INF;
            }
        }
        
        for (int i=0 ; i<road.length ; i++) {
            int x = road[i][0]-1;
            int y = road[i][1]-1;
            int weight = road[i][2];
            floyd[x][y] = Math.min(weight, floyd[x][y]);
            floyd[y][x] = Math.min(weight, floyd[y][x]);
        }
        
        for (int k=0 ; k<N ; k++) {
            for (int i=0 ; i<N ; i++) {
                for (int j=0 ; j<N ; j++) {
                    floyd[i][j] = Math.min(floyd[i][k]+floyd[k][j], floyd[i][j]);
                }

            }
        }
        
        for (int j=0 ; j<N ; j++) {
            if (floyd[0][j] <= K) answer++;
        }
        

        return answer;
    }
}
