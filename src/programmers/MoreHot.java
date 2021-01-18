package programmers;

import java.util.PriorityQueue;

public class MoreHot {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int i = 0 ; i< scoville.length ; i++) {
            priorityQueue.add(scoville[i]);
        }


        while(priorityQueue.peek() < K){
           int x = priorityQueue.poll();
           int y = priorityQueue.poll();
           int result = x + (y*2);

           if(priorityQueue.isEmpty() && result < K)
               return -1;
           priorityQueue.add(result);
           answer++;
        }

        return answer;
    }
    public static void main(String[] args){
        MoreHot moreHot = new MoreHot();

        System.out.println(moreHot.solution(new int[]{7,9,10,12},7));
    }
}
