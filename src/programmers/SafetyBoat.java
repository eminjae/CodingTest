package programmers;

import java.util.*;

public class SafetyBoat {
    public int solution(int[] people, int limit) {
        int answer = 0;

        Deque<Integer> deque = new ArrayDeque<>();

        Arrays.sort(people);
        for(int i = people.length-1 ; i >=0 ; i--) deque.add(people[i]);

        while(!deque.isEmpty()){

            int temp = limit - deque.poll();

            if(!deque.isEmpty() && deque.peekLast() <= temp){
                deque.pollLast();
            }

            answer++;

        }
        return answer;
    }

    public static void main(String[] args){
        SafetyBoat safetyBoat = new SafetyBoat();

        System.out.println(safetyBoat.solution(new int[]{10,20,30,40,50,60,70,80,90},100));
    }

}
