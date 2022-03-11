import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> answer = new ArrayList<>();
        for (int each : arr) {
            if (each % divisor == 0) answer.add(each);
        }
        if (answer.size() == 0) return new int[] {-1};
        Collections.sort(answer);
        return answer.stream().mapToInt(i->i).toArray();
    }
}
