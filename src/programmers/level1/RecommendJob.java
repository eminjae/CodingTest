package programmers.level1;

import java.util.HashMap;
import java.util.Map;

public class RecommendJob {
    public String solution(String[] table, String[] languages, int[] preference) {
        String answer = "";
        int maxPreference = 0;
        Map<String, Map<String, Integer>> map = new HashMap<>();


        for(String str : table) {
            String[] splitedStr = str.split(" ");
            Map<String, Integer> tempMap = new HashMap<>();
            tempMap.put(splitedStr[1], 5);
            tempMap.put(splitedStr[2], 4);
            tempMap.put(splitedStr[3], 3);
            tempMap.put(splitedStr[4], 2);
            tempMap.put(splitedStr[5], 1);
            map.put(splitedStr[0], tempMap);
        }
        for(String key : map.keySet()) {
            Map<String, Integer> tempMap = map.get(key);
            int lanPreference = 0;
            for(int i = 0; i < languages.length; i++) {
                for (String innerKey : tempMap.keySet()) {

                    if (innerKey.equals(languages[i])) {
                        lanPreference = lanPreference + (tempMap.get(innerKey) * preference[i]);
                    }
                }
            }
            if(lanPreference > maxPreference) {
                maxPreference = lanPreference;
                answer = key;
            } else if(lanPreference == maxPreference) {
                int current = answer.charAt(0);
                int last = key.charAt(0);
                answer = current < last ? answer : key;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] table = new String[] {"SI JAVA JAVASCRIPT SQL PYTHON C#", "CONTENTS JAVASCRIPT JAVA PYTHON SQL C++", "HARDWARE C C++ PYTHON JAVA JAVASCRIPT", "PORTAL JAVA JAVASCRIPT PYTHON KOTLIN PHP", "GAME C++ C# JAVASCRIPT C JAVA"};
        String[] languages = new String[] {"PYTHON", "C++", "SQL"};
        int[] preference = new int[]{7,5,5};
        RecommendJob recommendJob = new RecommendJob();
        String result = recommendJob.solution(table,languages,preference);
        System.out.println(result);
    }

}
