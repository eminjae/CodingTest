package programmers.level1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class MinSquare {
    public int solution(int[][] sizes) {

        int[] width = new int[sizes.length];
        int[] height = new int[sizes.length];
        for(int i = 0 ; i < sizes.length; i++) {
            width[i] = sizes[i][0] > sizes[i][1] ? sizes[i][0] : sizes[i][1];
            height[i] = sizes[i][0] > sizes[i][1] ? sizes[i][1] : sizes[i][0];
        }
        Arrays.sort(width);
        Arrays.sort(height);
        return width[sizes.length-1] * height[sizes.length-1];
    }

    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        MinSquare minSquare = new MinSquare();
        System.out.println(minSquare.solution(sizes));
    }
}
