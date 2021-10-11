package programmers.level2;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
* 다리를 지나는 트럭
* */
public class Lesson42583 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Truck> q = new LinkedList<>();
        Queue<Truck> bridgeQueue = new LinkedList<>();

        for(int i = 0 ; i < truck_weights.length; i++) {
            q.add(new Truck(0, truck_weights[i]));
        }
        int totalWeight = 0;
        while(!q.isEmpty() || !bridgeQueue.isEmpty()) {
            answer++;
            if(!bridgeQueue.isEmpty()) {
                Truck bridgeTruck = bridgeQueue.peek();
                if (answer - bridgeTruck.second >= bridge_length) {
                    bridgeQueue.poll();
                    totalWeight -= bridgeTruck.weight;
                }
            }
            if(!q.isEmpty()) {
                Truck truck = q.peek();
                if ((totalWeight + truck.weight <= weight)) {
                    totalWeight += truck.weight;
                    q.poll();
                    bridgeQueue.add(new Truck(answer, truck.weight));
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Lesson42583 lesson42583 = new Lesson42583();
        System.out.println(lesson42583.solution(2,10, new int[]{7,4,5,6}));
        System.out.println(lesson42583.solution(100,100, new int[]{10}));
        System.out.println(lesson42583.solution(100,100, new int[]{10,10,10,10,10,10,10,10,10,10}));

    }
}
class Truck {
    int second;
    int weight;

    public Truck(int second, int weight) {
        this.second = second;
        this.weight = weight;
    }
}
