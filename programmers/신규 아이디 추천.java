class Solution {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();
        
        answer = answer.replaceAll("[^a-z0-9-_.]","");
        
        String temp = "";
        for (int i=0 ; i<answer.length() ; i++) {
            String currentString = answer.substring(i,i+1);
            temp += currentString;
            if (currentString.contains(".")) {
                for (int j=i+1 ; j<answer.length() ; j++) {
                    if (answer.substring(j,j+1).equals(".")) {
                        i++;
                    } else {
                        break;
                    }
                }
            }
        }
        answer = temp;
        
        
        if (answer.length() > 0) {
            if (answer.charAt(0) == '.') {
                answer = answer.substring(1, answer.length());
            }
            
        }
        if (answer.length() > 0) {
            if (answer.charAt(answer.length()-1) == '.') {
                answer = answer.substring(0,answer.length()-1);
            }
        }
        
        if (answer.equals("")) {
            answer = "a";
        }
        
        
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            
            if (answer.length() > 0) {
                if (answer.charAt(answer.length()-1) == '.') {
                    answer = answer.substring(0,answer.length()-1);
                }
            }
        }
        
        
        if (answer.length() <= 2) {
            int currentLength = answer.length();
            String lastString = answer.substring(answer.length()-1);
            for (int i=currentLength ; i<3 ; i++) {
                answer += lastString;
            }
        }
        
        return answer;
    }
}
