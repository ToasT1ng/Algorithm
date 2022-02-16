class Solution
{
    public int solution(int n, int a, int b)
    {
        int round = 0;
        while (true) {
            round++;
            
            if (Math.abs(a-b) <= 1 && Math.max(a,b) % 2 == 0) {
                break;
            }
            
            a = a/2 + a%2;
            b = b/2 + b%2;
                
        }

        return round;
    }
}
