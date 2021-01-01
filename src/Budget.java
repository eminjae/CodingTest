import java.util.*;

public class Budget {

    static public int solution(int[] d, int budget) {

        int[] sortArray = Arrays.copyOf(d, d.length);

        Arrays.sort(sortArray);
        int sum = 0;

        int answer = 0;

        for (int i = 0; i < sortArray.length; i++) {
            sum += sortArray[i];
            if (sum > budget)
                break;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,2,3,3}, 10));
    }
}
