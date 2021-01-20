package programmers;

import java.util.HashMap;

public class Camouflage {
    public int solution(String[][] clothes) {

        HashMap<String, Integer> param = new HashMap<>();
        int answer = 1;

        for (int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];
            if(!param.containsKey(type))
                param.put(type, 2);
            else
                param.put(type, param.get(type)+1);
        }
        for(String key : param.keySet()){
            answer *= param.get(key);
        }
        answer--;
        return answer;
    }
    public static void main(String[] args){
        Camouflage camouflage = new Camouflage();
        String[][] str = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(camouflage.solution(str));
    }
}
