package programmers;
import java.util.*;

public class MakingMaxNumber {
    static int max = Integer.MIN_VALUE;
    public String solution(String number, int k) {


        String[] input = new String[number.length()];
        for(int i = 0 ; i < number.length(); i++){
            input[i] = String.valueOf(number.charAt(i));
        }
        String[] answer = new String[number.length()-k];
        removeRecursion(number.length()-k, 0, input, answer, 0);
        return Integer.toString(max);
    }
    public void removeRecursion(int endPoint, int dept, String[] input, String[] answer, int index){

        if(dept == endPoint){
            StringBuffer sb = new StringBuffer();
            for(int i = 0 ; i < answer.length; i++){
                sb.append(answer[i]);
            }
            max = Math.max(max, Integer.parseInt(sb.toString()));
            return;
        }

        for(int i = index; i < input.length; i++){
            answer[dept] = input[i];
            removeRecursion(endPoint,dept+1, input, answer, i+1);
        }

    }
    public static void main(String[] args){
        MakingMaxNumber makingMaxNumber = new MakingMaxNumber();
      // System.out.println(makingMaxNumber.solution("1924",2));
       // System.out.println(makingMaxNumber.solution("1231234",3));
        System.out.println(makingMaxNumber.solution("87654321",3));
    }

}
