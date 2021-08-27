package programmers.level1;

import java.util.Arrays;

public class Lotto {
    public int[] solution(int[] lottos, int[] win_nums) {

        long zero_cnt = Arrays.stream(lottos).filter(value -> value == 0).count();
        int cnt = 0;
        for(int i = 0 ; i < win_nums.length; i++) {
            for(int j = 0 ; j < lottos.length; j++){
                if(win_nums[i] == lottos[j]) {
                    cnt++;
                    break;
                }
            }
        }
        if(zero_cnt == 0 && cnt == 0) {
            return new int[]{6,6};
        }
        if(cnt ==0) {
            return new int[]{1,6};
        }
        return new int[]{ checkRate((int) (cnt+zero_cnt)), checkRate(cnt)};
    }
    public int checkRate(int answer_cnt) {
        if(answer_cnt == 6) return 1;
        else if(answer_cnt == 5) return 2;
        else if(answer_cnt == 4) return 3;
        else if(answer_cnt == 3) return 4;
        else if(answer_cnt == 2) return 5;
        else return 6;
    }
    public static void main(String[] args) {
        int[] lottos = new int[]{44, 1, 0, 0, 31, 25};
        int[] win_nums = new int[]{31, 10, 45, 1, 6, 19};
        System.out.println(new Lotto().solution(lottos,win_nums));
    }
}
