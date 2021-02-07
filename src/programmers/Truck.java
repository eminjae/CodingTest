package programmers;

import java.util.*;

public class Truck {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> waitingQ = new LinkedList<>();
        Queue<Integer> bridgeQ = new LinkedList<>();

        for(int i = 0 ; i < truck_weights.length; i++){
            waitingQ.add(truck_weights[i]);
        }
        HashMap<Integer, Integer> param = new HashMap<>();

        while(!waitingQ.isEmpty() && !bridgeQ.isEmpty()){
            int currentWeight = 0;
            while(currentWeight + waitingQ.peek() <= weight){
                int truck = waitingQ.poll();
                currentWeight += truck;
                bridgeQ.add(truck);

            }



        }
        return answer;
    }
}
