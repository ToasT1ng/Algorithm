class Solution {
    public String solution(String s, int n) {
        String answer = "";
        for (char each : s.toCharArray()) {
            if (String.valueOf(each).equals(" "))  {
                answer += each;
            } else {
                int ascii = each + n;
                if ((ascii >= 91 && Character.isUpperCase(each)) || ascii >= 123) ascii -= 26;
                answer += String.valueOf((char) ascii);
            }
        }
        return answer;
    }
}
