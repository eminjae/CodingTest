package programmers;

import java.util.ArrayList;
import java.util.*;

public class CalculateMax {
    public long solution(String expression) {
        long answer = Long.MIN_VALUE;

        int plus = plusCheck(expression);
        int sub = substractCheck(expression);
        int mul = multipleCheck(expression);
        int total = plus + sub + mul;

        List<String[]> priority = new ArrayList<>();

        if(total == 2){
            if(plus == 1 && sub ==1){
                priority.add(new String[]{"+","-"});
                priority.add(new String[]{"-","+"});
            }else if(plus == 1 && mul == 1){
                priority.add(new String[]{"+","*"});
                priority.add(new String[]{"*","+"});
            }else if(sub == 1 && mul == 1){
                priority.add(new String[]{"-","*"});
                priority.add(new String[]{"*","-"});
            }

        } else if (total == 3){
            priority.add(new String[]{"*","+","-"});
            priority.add(new String[]{"*","-","+"});
            priority.add(new String[]{"+","*","-"});
            priority.add(new String[]{"+","-","*"});
            priority.add(new String[]{"-","*","+"});
            priority.add(new String[]{"-","+","*"});
        }
//        String[] splitExpression = expression.split("\\*|-|\\+");
//
//
//        List<String> originSign = new ArrayList<>();
//
//        for(int x = 0 ;x < expression.length(); x++){
//            if(expression.charAt(x) == '*' || expression.charAt(x) == '-' || expression.charAt(x) == '+'){
//                originSign.add(String.valueOf(expression.charAt(x)));
//            }
//        }
   //     List<String> number = Arrays.asList(splitExpression);
        for(int i = 0 ;i < priority.size(); i++){
            String[] prior = priority.get(i);
            StringBuffer str = new StringBuffer();
            str.append(expression);
            String[] splitStr = str.toString().split("\\*|-|\\+");

            List<String> originSign = new ArrayList<>();

            for(int x = 0 ;x < str.length(); x++){
                if(str.charAt(x) == '*' || str.charAt(x) == '-' || str.charAt(x) == '+'){
                    originSign.add(String.valueOf(str.charAt(x)));
                }
            }
            for(int j = 0 ; j < prior.length; j++){


            }
        }


        return answer;
    }
    public int calculate(String number1, String number2, String sign){

        int num1 = Integer.parseInt(number1);
        int num2 = Integer.parseInt(number2);

        if(sign.equals("*")){
            return num1*num2;
        }
        else if(sign.equals("+")){
            return num1+num2;
        }
        else if(sign.equals("-")){
            return num1-num2;
        }
        return 0;
    }
    public int plusCheck(String exp){
        if(exp.contains("+")) return 1;

        return 0;
    }
    public int substractCheck(String exp){
        if(exp.contains("-")) return 1;

        return 0;
    }
    public int multipleCheck(String exp){
        if(exp.contains("*")) return 1;

        return 0;
    }

    public static void main(String[] args) {
        String s = "100-200*300-500+20";
        String s2 = "50*6-3*2";
        System.out.println(new CalculateMax().solution(s));
        System.out.println(new CalculateMax().solution(s2));

    }
}
