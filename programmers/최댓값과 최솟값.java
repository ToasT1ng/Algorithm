class Solution {
    public String solution(String s) {
        String[] split = s.split(" ");
        int min = 0;
        int max = 0;
        for (int i=0 ; i<split.length ; i++) {
            int number = Integer.parseInt(split[i]);
            if (i==0) {
                min = number;
                max = number;
            } else {
                min = Math.min(min, number);
                max = Math.max(max, number);
            }
        }
        return min + " " + max;
    }
}
