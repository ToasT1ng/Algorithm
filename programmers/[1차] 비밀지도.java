// https://programmers.co.kr/learn/courses/30/lessons/17681#

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String format = "%" + n + "s";
        for (int i = 0; i < n; i++) {
            String current = String.format(format, Integer.toBinaryString(arr1[i] | arr2[i]));
            current = current.replaceAll("1", "#");
            current = current.replaceAll("0", " ");
            answer[i] = current;
        }
        
        return answer;
    }
    
    public String[] oldSolution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String format = "%0" + n + "d";
        for (int i=0 ; i<n ; i++) {
            String string1 = String.format(format, Long.parseLong(Integer.toBinaryString(arr1[i])));
            String string2 = String.format(format, Long.parseLong(Integer.toBinaryString(arr2[i])));
            String result = "";
            for (int j=0 ; j<n ; j++) {
                if (string1.charAt(j) == '0' && string2.charAt(j) == '0') {
                    result += " ";
                } else {
                    result += "#";
                }
            }
            answer[i] = result;
        }
        return answer;
    }
    
}
