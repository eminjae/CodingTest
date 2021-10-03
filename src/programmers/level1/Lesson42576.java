package programmers.level1;

import java.util.HashMap;
import java.util.Map;

/*
* 완주하지 못한 선수
* */
public class Lesson42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> paramMap = new HashMap<>();

        for(String s : participant) {
            if(!paramMap.containsKey(s)) {
                paramMap.put(s , 1);
            } else {
                paramMap.put(s, paramMap.get(s) + 1);
            }
        }
        for(String s : completion) {
            paramMap.put(s, paramMap.get(s) -1);
        }
        for(String key : paramMap.keySet()) {
            if(paramMap.get(key) == 1) {
                answer = key;
            }
        }
        return answer;
    }
}
