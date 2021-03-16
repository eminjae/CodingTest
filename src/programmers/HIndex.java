package programmers;

import java.util.*;
public class HIndex {

    public int solution(int[] citations) {

        Arrays.sort(citations);
        int num = citations.length / 2;

        return citations[num];
    }
    public static void main(String[] args){
        int[] array = new int[]{3,0,6,1,5};
        System.out.println(new HIndex().solution(array));
    }
}
