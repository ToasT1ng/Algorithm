import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int lowest = arr[0];
        for (int arrEach : arr) {
            lowest = Math.min(lowest, arrEach);
        }
        for (int arrEach : arr) {
            if (lowest != arrEach) {
                list.add(arrEach);
            }
        }
        if (list.size() == 0) {
            list.add(-1);
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}
