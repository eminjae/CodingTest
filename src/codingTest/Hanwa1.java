package codingTest;

import java.util.*;

public class Hanwa1 {

    public int solution(String s) {
        int answer = 0;
        List<Integer> numberOneList = new ArrayList<>();

        String[] splitStr = s.split("0");
        for(int i = 0 ; i < splitStr.length ; i++){
            answer = Math.max(answer, splitStr[i].length());
        }
        return answer;
    }
    public static void main(String[] args){
        System.out.println(new Hanwa1().solution("110111"));
        System.out.println(new Hanwa1().solution("00000"));
    }
}