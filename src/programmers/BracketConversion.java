package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;

public class BracketConversion {

    public String solution(String p) {



        String answer = checkRightBracket(p)==true ? p : recursion(p);
        return answer;
    }

    public String recursion(String p){

        if(p.equals("")) return "";


        StringBuffer strU = new StringBuffer();
        String strV = "";
        for(int i = 0 ; i < p.length() ; i++){
            strU.append(p.charAt(i));
            if(checkBalancedBracket(strU.toString()) == true){
                strV = i + 1 >= p.length() ? "" :p.substring(i+1, p.length());
                break;
            }
        }

        if(checkRightBracket(strU.toString())==true){
           return strU + recursion(strV);
        } else {
            StringBuffer sb = new StringBuffer();
            sb.append("(");
            String temp = recursion(strV);
            sb.append(temp);
            sb.append(")");

            strU.deleteCharAt(strU.length()-1);
            strU.deleteCharAt(0);

            for(int i = 0 ; i < strU.length(); i++){
                if(strU.charAt(i) == '('){
                    strU.setCharAt(i,')');
                } else {
                    strU.setCharAt(i,'(');
                }
            }


            return sb.toString() + strU.toString();

        }

    }

    boolean checkBalancedBracket(String s) {
        boolean answer = true;

        int leftBracketCnt = 0;
        int rightBracketCnt = 0;
        for(int i = 0 ; i< s.length(); i++){
            if(s.charAt(i) == '('){
                leftBracketCnt++;
            }else if(s.charAt(i) == ')'){
                rightBracketCnt++;
            }
        }
        if(leftBracketCnt != rightBracketCnt) answer = false;

        return answer;
    }
    boolean checkRightBracket(String s) {

        boolean answer = true;

        int leftBracketCnt = 0;

        for(int i = 0 ; i< s.length(); i++){

            if(s.charAt(i) == '('){
                leftBracketCnt++;
            }else if(s.charAt(i) == ')'){
                leftBracketCnt--;
                if(leftBracketCnt < 0){
                    answer =false;
                    break;
                }

            }

        }
        if(leftBracketCnt > 0) answer = false;

        return answer;
    }

    public static void main(String[] args){
        BracketConversion bracketConversion = new BracketConversion();
        System.out.println(bracketConversion.solution("(()())()"));
        System.out.println(bracketConversion.solution(")("));
        System.out.println(bracketConversion.solution("()))((()"));
    }
}
