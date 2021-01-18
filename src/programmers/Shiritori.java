package programmers;

import java.util.*;

public class Shiritori {

    public int[] solution(int n, String[] words) {

        List<String> usedWords = new ArrayList<>();

        char lastCh = words[0].charAt(0);

        int num = 0;
        HashMap<Integer, Integer> param = new HashMap<>();

        int[] answer = {0,0};

        for(int i = 0 ; i < words.length ; i++){

            num = num >= n ? 1 : num+1;

            if(!param.containsKey(num)) param.put(num, 1);
            else param.put(num, param.get(num) + 1);

            if(usedWords.contains(words[i]) || (lastCh != words[i].charAt(0))){
                answer = new int[]{num, param.get(num)};
                break;
            }
            usedWords.add(words[i]);

            lastCh = words[i].charAt(words[i].length()-1);
        }




        return answer;
    }

    public static void main(String[] args){

        Shiritori shiritori = new Shiritori();
        String[] str = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        int[] result = shiritori.solution(3,str);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
