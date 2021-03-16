package programmers;

import com.apple.eawt.AppEvent;

import java.math.BigInteger;

public class MaxNum {
    StringBuffer max = new StringBuffer();
    public String solution(int[] numbers) {

        int endPoint = numbers.length;
        int[] answer = new int[endPoint];
        boolean[] visited = new boolean[endPoint];
        permutation(endPoint, 0, numbers, answer, visited);

        return max.toString();
    }
    public void permutation(int endPoint, int dept, int[] input,int[] answer, boolean[] visited){
        if(dept == endPoint){
            StringBuffer sb = new StringBuffer();
            for(int i = 0 ; i < answer.length; i++){
                sb.append(answer[i]);
            }

           // max = max.compareTo(new BigInteger(sb.toString())) > 0 ? max : new BigInteger(sb.toString());
            return;
        }

        for(int i = 0 ; i < input.length; i++){
            if(!visited[i]){
                visited[i] = true;
                answer[dept] = input[i];
                permutation(endPoint, dept+1, input, answer,visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args){
        int[] array1 = new int[]{0,5,10,15,20};
        int[] array2 = new int[]{1000,0,5,99,100};
        System.out.println(new MaxNum().solution(array1));
        System.out.println(new MaxNum().solution(array2));
    }
}
