// https://programmers.co.kr/learn/courses/30/lessons/42889#

import java.util.*;

class Failure /*implements Comparable<Failure>*/{
    public double failure;
    public int position;

    public Failure(double failure, int position) {
        this.failure = failure;
        this.position = position;
    }
    
    // @Override
    // public int compareTo(Failure target) {
    //     return Double.compare(target.failure, this.failure);
    // }

    @Override
    public String toString(){
        return failure + " / " + position;
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        int[] player = new int[N+1];
        int[] notClear = new int[N+1];
        for (int stage : stages) {
            if (stage == N+1) {
                stage = N;
            } else {
                notClear[stage] += 1;
            }
            for (int j=1 ; j<stage+1 ; j++) {
                player[j] += 1;
            }
        }
        
        List<Failure> failureList = new ArrayList<>();
        for (int i=1 ; i<N+1 ; i++) {
            if (player[i] == 0) {
                failureList.add(new Failure(0, i));
            } else {
                double currentFailure = (double) notClear[i] / player[i];
                failureList.add(new Failure(currentFailure, i));
            }
        }
        
        Collections.sort(failureList, ((f1, f2) -> Double.compare(f2.failure, f1.failure)));
        
        int index=0;
        for (Failure each : failureList) {
            answer[index] = each.position;
            index++;
        }
        
        return answer;
    }
}
