import java.util.*;

class FileName implements Comparable<FileName>{
    String originName;
    String head;
    int number;
    String tail;
    
    FileName(String originName, String head, String number, String tail) {
        this.originName = originName;
        this.head = head;
        this.number = Integer.parseInt(number);
        this.tail = tail;
    }
    
    @Override
    public int compareTo(FileName f) {
        int result = 0;
        if (f.head.compareTo(head) == 0) {
            if (f.number == number) {
                result = 0;
            } else {
                if (f.number > number) {
                    result = 1;
                } else {
                    result = -1;
                }
            }
        } else {
            result = f.head.compareTo(head);
        }
        return -1 * result;
    }
    
    @Override
    public String toString() {
        return "fileName=" + originName;
    }
}

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        List<FileName> fileNames = new ArrayList<>();
        for (String file : files) {
            char[] fileCharArray = file.toLowerCase().toCharArray();
            
            int positionPointer = 0;
            String head = "";
            String number = "";
            String tail = "";
            for (char fileChar : fileCharArray) {
                if (positionPointer == 0) {
                    if (!Character.isDigit(fileChar)) {
                        head += fileChar;
                    } else {
                        positionPointer++;
                        number += fileChar;
                    }
                } else if (positionPointer == 1) {
                    if (Character.isDigit(fileChar)) {
                        number += fileChar;
                    } else {
                        positionPointer++;
                        tail += fileChar;
                    }
                } else {
                    tail += fileChar;
                }
            
            }
            
            FileName f = new FileName(file, head, number, tail);
            fileNames.add(f);
            
        }
        
        Collections.sort(fileNames);
        
        for (int i=0 ; i<fileNames.size() ; i++) {
            answer[i] = fileNames.get(i).originName;
        }
        
        return answer;
    }
}
