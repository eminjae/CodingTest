package programmers.level2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lesson42883 {

    int max = -1;
    int removeLen;
    public String solution(String number, int k) {
        String answer = "";

        removeLen = number.length() - k;
        String[] splitNumber = number.split("");
        recursion(splitNumber, 0, 0, "");
        return Integer.toString(max);
    }
    public void recursion(String[] splitNumber, int num, int index, String value) {
        if(num == removeLen) {
            max = Math.max(max, Integer.parseInt(value));
            return;
        }
        if(index == splitNumber.length) return;

        recursion(splitNumber, num, index+1, value);
        recursion(splitNumber,num+1, index+1, value + splitNumber[index]);
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();


    }
}
