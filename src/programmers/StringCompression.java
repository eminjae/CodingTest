package programmers;

import java.util.*;

public class StringCompression {

    public int solution(String s) {

        int answer = s.length();
        int len = s.length();
        List<String> result = new ArrayList<>();
        for(int i = 1 ; i <= len/2; i++){
           List<String> str = new ArrayList<>();
           int index = 0;
           while(index< len){
               String temp = index+i >= len ? s.substring(index) : s.substring(index, index+i);
               str.add(temp);
               index = index + i;
           }
           StringBuffer sb = new StringBuffer();
           for(int j = 0; j < str.size();j++){
               int cnt = 1;
               String sample = str.get(j);
               while(j+1 < str.size() && str.get(j).equals(str.get(j+1))){
                    cnt++;
                    j++;
               }
               if(cnt == 1) {
                   sb.append(str.get(j));
               }else {
                   sb.append(cnt);
                   sb.append(sample);
               }



           }
            result.add(sb.toString());
        }
        for(int i= 0; i < result.size(); i++){
            answer = Math.min(answer, result.get(i).length());
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new StringCompression().solution("aabbaccc"));
        System.out.println(new StringCompression().solution("ababcdcdababcdcd"));
        System.out.println(new StringCompression().solution("abcabcdede"));
        System.out.println(new StringCompression().solution("abcabcabcabcdededededede"));
        System.out.println(new StringCompression().solution("xababcdcdababcdcd"));
    }
}
