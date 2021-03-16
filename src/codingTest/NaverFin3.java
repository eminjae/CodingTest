package codingTest;

import java.util.List;
import java.util.*;

public class NaverFin3 {



    public int solution(int A, int B, int C, int D) {
        int[] input = new int[]{A,B,C,D};
        boolean[] visited = new boolean[4];
        String[] result = new String[4];
        int cnt = 0;
        HashSet<String> set = new HashSet<>();
        TimeCombination(4, 0, input, result, visited, set);
        for(String s : set){
            int hour = Integer.parseInt(String.valueOf(s.charAt(0)) + String.valueOf(s.charAt(1)));
            int minute = Integer.parseInt(String.valueOf(s.charAt(2)) + String.valueOf(s.charAt(3)));
            if(hour <= 23 && minute <= 59)
                cnt++;
        }
        return cnt;

    }
    public void TimeCombination(int endPoint, int dept, int[] input, String[] result, boolean[] visited, HashSet<String> set){
        if(dept == endPoint){
            set.add(result[0]+result[1]+result[2]+result[3]);

            return;
        }

        for(int i = 0; i < input.length; i++){
            if(!visited[i]){
                visited[i] = true;
                result[dept] = Integer.toString(input[i]);
                TimeCombination(endPoint, dept+1, input, result, visited, set);
                visited[i] = false;
            }


        }
    }
    public static void main(String[] args) {
            NaverFin3 naverFin3 = new NaverFin3();
//            System.out.println(naverFin3.solution(1,8,3,2));
//            System.out.println(naverFin3.solution(2,3,3,2));
            System.out.println(naverFin3.solution(0,3,4,7));
    }
}
