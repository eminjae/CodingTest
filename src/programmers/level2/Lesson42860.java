package programmers.level2;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lesson42860 {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();
        boolean[] isCheck = new boolean[len];

        String start = IntStream.range(0, len).mapToObj(operand -> "A").collect(Collectors.joining());

        if(!name.equals(start)) {

            for(int index = 0 ; index < len; index++) {
                int distance = name.charAt(index) - start.charAt(index);
                int reverseDistance = Math.abs(name.charAt(index) - 'Z') + 1;
                answer += Math.min(distance, reverseDistance);
            }


        }

        return answer-1;
    }
    public int getLeftDistance(int currentIndex, String name, boolean[] isCheck) {
        for(int i = currentIndex-1; i >=0; i--) {
            if(name.charAt(i) != 'A') {
                if(!isCheck[i]) return currentIndex-i;
                else return 0;
            }
        }
        return 1;
    }
    public int getRightDistance(int currentIndex, String name, boolean[] isCheck) {
        for(int i = currentIndex+1; i < name.length(); i++) {
            if(name.charAt(i) != 'A') {
                if(!isCheck[i]) return i-currentIndex;
                else return 0;
            }
        }
        return 1;
    }
    public boolean isAllCheck(boolean[] isCheck) {
        for(int i = 0 ; i < isCheck.length ; i++) {
            if(!isCheck[i]) return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Lesson42860 lesson42860 = new Lesson42860();
      //  System.out.println(lesson42860.solution("JEROEN"));
      //  System.out.println(lesson42860.solution("JAN"));
        System.out.println(lesson42860.solution("JEROEN"));
        System.out.println(lesson42860.solution("JAN"));
        System.out.println(lesson42860.solution("AABAA"));


    }
}
