package programmers;

import java.util.*;

public class FunctionDevelopment {
    public int[] solution(int[] progresses, int[] speeds) {


        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < progresses.length ; i++){
            int leftJob = 100 - progresses[i];
            int jobDay = leftJob%speeds[i] == 0 ? leftJob/speeds[i] : leftJob/speeds[i]+1;
            q.add(jobDay);
        }
        List<Integer> answer = new ArrayList<>();

        int temp = q.poll();
        int funcCnt = 1;
        while(!q.isEmpty()){
            if(temp>=q.peek()){
                q.poll();
                funcCnt++;
            }else {
                answer.add(funcCnt);
                temp = q.poll();
                funcCnt = 1;
            }
            if(q.isEmpty()) answer.add(funcCnt);
        }

        int[] result = new int[answer.size()];
        for(int i = 0 ;i < result.length ; i++){
            result[i] = answer.get(i);
        }
        return result;
    }
    public static void main(String[] args){
        FunctionDevelopment functionDevelopment = new FunctionDevelopment();
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};
        int[] result = functionDevelopment.solution(progresses, speeds);

        for(int i = 0 ; i < result.length ; i++){
            System.out.print(result[i] + " ");
        }
    }

}
