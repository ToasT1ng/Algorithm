class Solution {
    public String solution(String p) {
        return makeV(p, "");
    }
    
    public String makeV(String oldU, String result) {
        // 1
        if (oldU == "") {
            return "";
        }
        
        // 2
        int uIndex = getUIndex(oldU);
        if (uIndex == -1) {
            return result;
        }
        String u = oldU.substring(0, uIndex+1);
        String v = oldU.substring(uIndex+1, oldU.length());
        
        // 3
        if (isRightString(u)) {
            // 3-1
            return u + makeV(v, result);
            
        // 4
        } else {
            // 4-1
            String temp = "(";
            
            // 4-2
            temp += makeV(v, result);
            
            // 4-3
            temp += ")";
            
            // 4-4
            String newU = u.substring(1, u.length()-1);
            for (int i=0 ; i<newU.length() ; i++) {
                if (newU.charAt(i) == '(') {
                    temp += ")";
                } else {
                    temp += "(";
                }
            }
            
            // 4-5
            return temp;
        }
    }
    
    public int getUIndex(String p) {
        char first = '\0';
        int firstCount = 0;
        for (int i=0 ; i<p.length() ; i++) {
            char current = p.charAt(i);
            if (i == 0) {
                first = current;
                firstCount++;
            } else {
                if (first == current) {
                    firstCount++;
                } else {
                    firstCount--;
                    if (firstCount == 0) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
    
    public boolean isRightString(String u) {
        if (u.charAt(0) != '(') {
            return false;
        }
        if (u.charAt(u.length()-1) == '(') {
            return false;
        }
        int leftCount = 0;
        int rightCount = 0;
        for (int i=0 ; i<u.length() ; i++) {
            if (u.charAt(i) == '(') {
                leftCount++;
            } else {
                rightCount++;
            }
            if (leftCount < rightCount) {
                return false;
            }
        }
        return true;
    }
}
