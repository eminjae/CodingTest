package programmers;

import java.util.*;

public class Printer {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> q = new LinkedList<>();


        for(int i = 0 ; i < priorities.length; i++){
            q.add(priorities[i]);

        }
        int cnt = -1;
        while(!q.isEmpty()){
            Queue<Integer> tempQ = new LinkedList<>();
            int current = q.poll();
            cnt++;
            tempQ.poll();
            while(!tempQ.isEmpty()){
                int temp = tempQ.poll();
                if(temp>current){
                    q.add(current);
                }
            }
        }

        return answer;
    }
}
