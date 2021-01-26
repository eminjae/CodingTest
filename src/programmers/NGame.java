package programmers;

import java.util.ArrayList;
import java.util.List;

public class NGame {
    public String solution(int n, int t, int m, int p) {

        int[] numberArray = new int[t*m];
        for(int i = 0 ; i < numberArray.length; i++){
            numberArray[i] = i;
        }
        List<String> strList = new ArrayList<>();
        strList.add("0");

        for(int i = 1 ; i <numberArray.length; i++){
            int remainder = numberArray[i] % n;
            int quotient = numberArray[i] / n;
            StringBuilder sb = new StringBuilder();

            while(quotient != 0){
                if(Integer.toString(remainder).equals("10")) sb.append("A");
                else if(Integer.toString(remainder).equals("11")) sb.append("B");
                else if(Integer.toString(remainder).equals("12")) sb.append("C");
                else if(Integer.toString(remainder).equals("13")) sb.append("D");
                else if(Integer.toString(remainder).equals("14")) sb.append("E");
                else if(Integer.toString(remainder).equals("15")) sb.append("F");
                else sb.append(remainder);
                remainder = quotient % n;
                quotient = quotient / n;

            }
            if(Integer.toString(remainder).equals("10")) sb.append("A");
            else if(Integer.toString(remainder).equals("11")) sb.append("B");
            else if(Integer.toString(remainder).equals("12")) sb.append("C");
            else if(Integer.toString(remainder).equals("13")) sb.append("D");
            else if(Integer.toString(remainder).equals("14")) sb.append("E");
            else if(Integer.toString(remainder).equals("15")) sb.append("F");
            else sb.append(remainder);
            sb.reverse();
            for(int j = 0 ; j < sb.length() ; j++){
                strList.add(String.valueOf(sb.charAt(j)));
            }

        }

        StringBuilder sb = new StringBuilder();
        int check = 0;
        for(int i = 0 ; i < strList.size(); i++){
            if(sb.length() >= t) break;
            check++;
            if(check > m) check = 1;
            if(check==p) sb.append(strList.get(i));

        }

        String answer = sb.toString();
        return answer;
    }
    public static void main(String[] args){
        System.out.println(new NGame().solution(2,4,2,1));
        System.out.println(new NGame().solution(16,16,2,1));
        System.out.println(new NGame().solution(16,16,2,2));

    }
}
