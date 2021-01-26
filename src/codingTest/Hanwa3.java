package codingTest;

import java.util.Stack;

public class Hanwa3 {

    public int[] solution(int[] deposit){

        Stack<Integer> stack = new Stack<>();

        for(int i = 0 ; i < deposit.length; i++){
            if(deposit[i] > 0){
                stack.push(deposit[i]);
            }
            else {
                int outMoney = stack.pop();
                int temp = outMoney + deposit[i];
                while(temp < 0){
                    outMoney = stack.pop();
                    temp = outMoney + temp;
                }
                if(temp!=0) stack.push(temp);
            }
        }
        int[] answer = new int[stack.size()];
        for(int i = answer.length-1 ; i >= 0; i--){
            answer[i] = stack.pop();
        }
        return answer;
    }
    public static void main(String[] args){
        new Hanwa3().solution(new int[]{500,1000,-300,200,-400,100,-100});
        new Hanwa3().solution(new int[]{500,1000,2000,-1000,-1500,500});
    }
}
