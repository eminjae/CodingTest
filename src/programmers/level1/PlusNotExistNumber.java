package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class PlusNotExistNumber {
    public int solution(int[] numbers) {
        int answer = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i = 0 ; i < 10; i++) {
            hashMap.put(i,0);
        }
        for(int i : numbers) {
            hashMap.put(i, 1);
        }

        answer = hashMap.entrySet().stream().filter(i -> i.getValue() == 0).mapToInt(i -> i.getKey()).sum();

        return answer;
    }

    public static void main(String[] args) {
        PlusNotExistNumber plusNotExistNumber = new PlusNotExistNumber();

        int[] numbers = new int[]{1,2,3,4,6,7,8,0};

        System.out.println(plusNotExistNumber.solution(numbers));
    }
}
