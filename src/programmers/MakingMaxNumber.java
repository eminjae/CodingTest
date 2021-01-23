package programmers;
import java.util.*;

public class MakingMaxNumber {
    public String solution(String number, int k) {

        String[] splitNumber = number.split("");

        List<Integer> intList = new ArrayList<>();
        for(int i = 0 ; i < splitNumber.length; i++){
            intList.add(Integer.parseInt(splitNumber[i]));
        }
        Collections.sort(intList);

        int index = 0;
        List<Integer> removeList = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        sb.append(number);
        while(k!=0){
            int min = intList.get(index);
            removeList.add(min);

            k--;
            index++;
        }
        for(int i = 0 ; i < removeList.size(); i++){
            int removeIndex = sb.indexOf(String.valueOf(removeList.get(i)));
            sb.deleteCharAt(removeIndex);
        }
        String answer = sb.toString();
        return answer;
    }
    public static void main(String[] args){
        MakingMaxNumber makingMaxNumber = new MakingMaxNumber();
      // System.out.println(makingMaxNumber.solution("1924",2));
       // System.out.println(makingMaxNumber.solution("1231234",3));
        System.out.println(makingMaxNumber.solution("4177252841",4));
    }

}
