class Solution {
    public int solution(int n) {
        int numberOneCounter = countNumberOne(Integer.toBinaryString(n));
        
        while(true) {
            n++;
            if (countNumberOne(Integer.toBinaryString(n)) == numberOneCounter) {
                break;
            }
        }
        
        return n;
    }
    
    int countNumberOne(String binaryArray) {
        int counter = 0;
        for (char each : binaryArray.toCharArray()) {
            if (each == '1') {
                counter++;
            }
        }
        return counter;
    }
}
