class Solution {
    public int solution(String name) {
        int answer = 0;
        // 각 자리가 A에서 가까운지 Z에서 가까운지 확인
        // 그 다음 자리로 갈때, 다음 알파벳이 A 일 경우 언제까지 A인지 확인하고, A가 아닌 알파벳이 있는 자리로 뒤로가는 것과 앞으로 가는 것중 어느것이 더 빠른지 비교
        
        int length = name.length();
        int temp = length-1;
        
        for (int i=0 ; i<length ; i++) {
            char each = name.charAt(i);
            int compare = Math.min(Math.abs(each-'A'), Math.abs(each-'Z') + 1);
            answer += compare;
            
            int nextIndexExceptA = i + 1;
            while (nextIndexExceptA < length && name.charAt(nextIndexExceptA) == 'A'){
                nextIndexExceptA++;
            }
            
            temp = Math.min(temp, i * 2 + length - nextIndexExceptA);
            temp = Math.min(temp, (length - nextIndexExceptA) * 2 + i);
        }
        return answer + temp;
    }
    
}
