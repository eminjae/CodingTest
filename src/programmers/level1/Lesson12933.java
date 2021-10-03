package programmers.level1;


import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/*
* 정수 내림차순으로 배치하기
* */
public class Lesson12933 {

    public long solution(long n) {
        String[] str = Long.toString(n).split("");
        Arrays.sort(str, Comparator.reverseOrder());

        return Long.parseLong(Arrays.stream(str).collect(Collectors.joining()));
    }
}
