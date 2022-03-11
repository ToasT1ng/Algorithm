// https://programmers.co.kr/learn/courses/30/lessons/49994

import java.util.*;

class Dot {
    int x;
    int y;
    Dot(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void addX(int amount) {
        this.x += amount;
    }
    
    public void addY(int amount) {
        this.y += amount;
    }
    
    @Override
    public String toString() {
        return "{x=" + this.x + ", y=" + this.y + "}";
    }
}

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        HashSet<String> set = new HashSet<>();
        Dot currentDot = new Dot(0,0);
        for (char each : dirs.toCharArray()) {
            String current = String.valueOf(each);
            Dot nextDot = new Dot(currentDot.x, currentDot.y);;
            if (current.equals("U") && currentDot.y < 5) {
                nextDot.addY(1);
                
            } else if (current.equals("D") && currentDot.y > -5) {
                nextDot.addY(-1);
                
            } else if (current.equals("R") && currentDot.x < 5) {
                nextDot.addX(1);
                
            } else if (current.equals("L") && currentDot.x > -5) {
                nextDot.addX(-1);
                
            } else {
                continue;
            }
            set.add(makeString(currentDot, nextDot));
            currentDot = nextDot;
        }
        return set.size();
    }
    
    public String makeString(Dot current, Dot next) {
        if (current.x > next.x) {
            return current.toString() + next.toString();
        } else if (current.x == next.x) {
            if (current.y > next.y) {
                return current.toString() + next.toString();
            } else {
                return next.toString() + current.toString();
            }
        } else {
            return next.toString() + current.toString();
        }
    }
}
