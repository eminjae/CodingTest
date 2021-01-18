package programmers;

import java.util.*;

public class DartGame {

    public static int solution(String dartResult) {

        String[] str = dartResult.split("");
        int answer = 0;

        int index = 0;
        List<Integer> result = new ArrayList<>();
        for(int i = 0 ; i < str.length ; i++){

            int sign = 1;
            int num = 0;
            int pow = 1;

            if(str[i].matches("^[0-9]*$")){

                num = Integer.parseInt(str[i]);

                if(str[i].equals("1") && str[i+1].equals("0")) {
                    num = 10;
                    i++;
                }

                if(Arrays.asList("S","D","T").contains(str[i+1])){
                    pow = str[i+1].equals("D") ? 2 : str[i+1].equals("T") ? 3 : 1;

                    if(i+2 < str.length && Arrays.asList("#","*").contains(str[i+2])){
                        sign = str[i+2].equals("*") ? 2 : -1;
                        if(index != 0 && sign == 2){
                            result.set(index-1, result.get(index-1)*sign);
                        }
                    }
                    result.add((int) (Math.pow(num , pow) * sign));
                    index++;
                }

            }

        }
        for(Integer x : result){
            answer += x;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("1D2S0T"));
    }
}
