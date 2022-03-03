class Solution {
    public int solution(int left, int right) {
        int answer = 0;

        // 제곱수인 경우 약수의 개수가 홀수
        // 제곱수가 아닌 경우 약수의 개수가 짝수
        for (int i=left; i<=right ; i++) {
            if (i % Math.sqrt(i) == 0) answer -= i;
            else answer += i;
        }

        return answer;
    }
    
    public int oldSolution(int left, int right) {
        int answer = 0;
        for (int i=left ; i<=right ; i++) {
            answer += convertNumber(i);
        }
        return answer;
    }
    
    public int convertNumber(int number) {
        int result = howMany(number);
        if (result % 2 == 0) return number;
        else return number *= -1;
    }
    
    public int howMany(int number) {
        if (number == 1) return 1;
        int result = 2;
        for (int i=2 ; i<number/2+1 ; i++) {
            if (number%i == 0) result++;
        }
        return result;
    }
}
