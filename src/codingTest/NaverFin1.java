package codingTest;

import java.util.*;

public class NaverFin1 {

    public int solution(String[] A) {
        HashMap<String, Integer> param = new HashMap<>();

        for(int i = 0 ;i < A.length; i++){
            if(!param.containsKey(A[i])){
                param.put(A[i],1);
            }else {
                param.put(A[i],param.get(A[i])+1);
            }
        }
        int max = 0;
        for(Map.Entry<String, Integer> entry : param.entrySet()){
            max = Math.max(max, entry.getValue());
        }

        return max;
    }
    public static void main(String[] args) {

    }
}
