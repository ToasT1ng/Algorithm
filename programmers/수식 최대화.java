// https://programmers.co.kr/learn/courses/30/lessons/67257#

import java.util.*;

class Solution {
    List<String> priorityOfCommand = new ArrayList<>();
    public long solution(String expression) {
        long answer = 0;
        
        // 1. * + - 의 우선순위 만들기
        // 2. 우선순위대로 계산하여 최대 절댓값 찾기
        //  2-1. split 사용해서 number 와 연산자 분리
        //  
        
        String[] command = {"*", "+", "-"};
        boolean[] visited = new boolean[3];
        makePriority(0, command, visited, "");
        
        List<String> commandList = new ArrayList<>(Arrays.asList(expression.split("[0-9]+")));
        commandList.remove(0);
        List<String> numberList = new ArrayList<>(Arrays.asList(expression.split("[*,+,-]")));
        
        int largestValue = 0;
        
        for (String commandStrings : priorityOfCommand) {
            List<String> tempCommandList = new ArrayList<>(commandList);
            List<String> tempNumberList = new ArrayList<>(numberList);
            char[] commandArray = commandStrings.toCharArray();
            int commandIndex = 0;
            
            while (tempCommandList.size() != 0) {   
                String currentCommand = String.valueOf(commandArray[commandIndex]);
                int iteration = tempCommandList.size();
                int i=0;
                while (i<iteration) {
                    if (tempCommandList.get(i).equals(currentCommand)) {
                        iteration--;
                        int computeValue = compute(tempNumberList.get(i), tempNumberList.get(i+1), currentCommand);
                        tempCommandList.remove(i);
                        tempNumberList.set(i, String.valueOf(computeValue));
                        tempNumberList.remove(i+1);
                        i--;
                    }
                    i++;
                }

                commandIndex++;
            }

            largestValue = Math.max(Math.abs(Integer.parseInt(tempNumberList.get(0))), largestValue);
        }
        
        
        return largestValue;
    }
    
    public void makePriority(int index, String[] command, boolean[] visited, String result) {
        if (index >= command.length) {
            priorityOfCommand.add(result);
            return;
        }
        for (int i=0 ; i<command.length ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result += command[i];
                makePriority(index+1, command, visited, result);
                result = result.substring(0, result.length()-1);
                visited[i] = false;
            }
        }
    }
    
    public int compute(String a, String b, String command) {
        if (command.equals("+")) {
            return Integer.parseInt(a) + Integer.parseInt(b);
        } else if (command.equals("-")) {
            return Integer.parseInt(a) - Integer.parseInt(b);
        } else {
            return Integer.parseInt(a) * Integer.parseInt(b);
        }
        
    }
}
