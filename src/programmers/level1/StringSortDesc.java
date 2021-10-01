package programmers.level1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class StringSortDesc {

    public String solution(String s) {

        return Arrays.stream(s.split("")).sorted(Comparator.reverseOrder()).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        StringSortDesc stringSortDesc = new StringSortDesc();

        System.out.println(stringSortDesc.solution("Zbcdefg"));
    }
}
