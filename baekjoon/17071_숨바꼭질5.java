import java.util.*;
import java.io.*;

class Main {
    static int MAX_VALUE = 500000;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int subin = Integer.parseInt(st.nextToken());
        int sibling = Integer.parseInt(st.nextToken());
        
        bfs(subin, sibling);

    }

    public static void bfs(int subin, int sibling) {
        int time = 0;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(subin);
        boolean[][] visited = new boolean[MAX_VALUE+1][2];
        visited[subin][time] = true;

        while (!queue.isEmpty()) {
            if (sibling > MAX_VALUE) {
                System.out.println(-1);
                return;
            }

            int timeRemain = time%2;
            if (visited[sibling][timeRemain]) {
                System.out.println(time);
                return;
            }

            int currentQueueSize = queue.size();
            for (int i=0; i<currentQueueSize ; i++) {
                int current = queue.poll();
                int nextTimeRemain = (time + 1) % 2;
                int next = current;


                next = current + 1;
                if (next <= MAX_VALUE && !visited[next][nextTimeRemain]) {
                    visited[next][nextTimeRemain] = true;
                    queue.offer(next);
                }

                next = current - 1;
                if (next >= 0 && !visited[next][nextTimeRemain]) {
                    visited[next][nextTimeRemain] = true;
                    queue.offer(next);
                }

                next = current * 2;
                if (next <= MAX_VALUE && !visited[next][nextTimeRemain]) {
                    visited[next][nextTimeRemain] = true;
                    queue.offer(next);
                }
            }

            time++;
            sibling += time;
        }
        return;
    }
}

