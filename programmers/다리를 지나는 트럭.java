import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;
        int truckIndex = 0;
        int currentTotalWeight = 0;
        
        boolean queueAddBool = true;
        
        while (true) {
            count++;
            
            if (queueAddBool) {
                int currentTruckWeight = weight+1;
                if (truckIndex <= truck_weights.length-1) {
                    currentTruckWeight = truck_weights[truckIndex];
                }
                if (currentTotalWeight + currentTruckWeight <= weight) {
                    currentTotalWeight += currentTruckWeight;
                    queue.offer(truck_weights[truckIndex]);
                    if (truckIndex < truck_weights.length) {
                        truckIndex++;   
                    }
                } else {
                    queue.offer(0);
                }
                
                if (queue.size() == bridge_length) {
                    queueAddBool = false;
                }
                
            } else if (queue.size() == bridge_length) {
                queueAddBool = false;
                int firstIn = queue.poll();
                currentTotalWeight -= firstIn;
                
                int currentTruckWeight = weight+1;
                if (truckIndex <= truck_weights.length-1) {
                    currentTruckWeight = truck_weights[truckIndex];
                }
                
                if (currentTotalWeight + currentTruckWeight <= weight) {
                    currentTotalWeight += currentTruckWeight;
                    queue.offer(truck_weights[truckIndex]);
                    if (truckIndex <= truck_weights.length) {
                        truckIndex++;   
                    }
                } else {
                    if (currentTotalWeight != 0) {
                        queue.offer(0);
                    }
                }
                
            
            } else {
                count--;
                break;
            }
            
            if (queue.isEmpty()) {
                break;
            }
            
        }
            
        answer = count;
        return answer;
    }
}
