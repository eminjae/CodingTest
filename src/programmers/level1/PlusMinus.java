package programmers.level1;

import java.util.stream.IntStream;

public class PlusMinus {
    public int solution(int[] absolutes, boolean[] signs) {

        return IntStream.range(0, signs.length).map(i -> {
            if(signs[i]) return absolutes[i];
            else return -absolutes[i];
        }).sum();
    }

    public static void main(String[] args) {
        PlusMinus plusMinus = new PlusMinus();
        int[] absolutes = new int[]{4,7,12};
        boolean[] signs = new boolean[]{true,false,true};

        System.out.println(plusMinus.solution(absolutes,signs));
    }
}
