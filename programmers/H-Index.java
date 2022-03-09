import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        // sorting 한 후, 나올때까지 확인? -> 나온 이후에는 확인할 필요가 없음 논문 수보다 length 가 더 작아질 수 밖에 없기 때문에
        // 0 1 3 5 6 7이면 
        // index 0 : 6개의 논문이 0번이상 
        // index 1 : 5개의 논문이 1번이상
        // index 2 : 4개의 논문이 3번이상
        Arrays.sort(citations);
        for (int i=0 ; i<citations.length ; i++) {
            int h = citations.length-i;
            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }
        return answer;
    }
}
