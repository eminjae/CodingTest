package codingTest;


import java.util.Stack;

public class Kakaobank1 {

    public long solution(String[] p) {

        Stack<String> stack = new Stack<>();

        for(int i = 0 ; i < p.length; i++){

            if(p[i].equals("+") || p[i].equals("-") || p[i].equals("/") || p[i].equals("*")){
                String s1 = stack.pop();
                String s2 = stack.pop();
                int result = 0 ;

                if(p[i].equals("+")) result = Integer.parseInt(s2) + Integer.parseInt(s1);
                else if(p[i].equals("-")) result = Integer.parseInt(s2) - Integer.parseInt(s1);
                else if(p[i].equals("/")) result = Integer.parseInt(s2) / Integer.parseInt(s1);
                else if(p[i].equals("*")) result = Integer.parseInt(s2) * Integer.parseInt(s1);

                stack.push(Integer.toString(result));
            }else {
                stack.push(p[i]);
            }

        }
        long answer = Integer.parseInt(stack.pop());
        return answer;
    }



    public static void main(String[] args){
        String[] p1 = {"12","2","5","+","*","9","3","/","-"};
        String[] p2 = {"1","1","+","1","1","+","*"};
        System.out.println(new Kakaobank1().solution(p1));
        System.out.println(new Kakaobank1().solution(p2));
    }
}
