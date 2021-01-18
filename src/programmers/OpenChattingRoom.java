package programmers;

import java.util.*;

public class OpenChattingRoom {
    public static String[] solution(String[] record) {

        HashMap<String, String> param = new HashMap<>();

        List<String> list = new ArrayList<>();
        for(int i = 0 ; i < record.length ; i++){
            String[] splitRecode = record[i].split(" ");

            if(splitRecode[0].equals("Enter")){
                param.put(splitRecode[1], splitRecode[2]);
                list.add(splitRecode[1] + "님이 들어왔습니다.");
            }else if(splitRecode[0].equals("Leave")){
                list.add(splitRecode[1] + "님이 나갔습니다.");
            }else if(splitRecode[0].equals("Change")){
                param.put(splitRecode[1], splitRecode[2]);
            }

        }
        String[] answer = new String[list.size()];
        for(int i = 0 ;i < list.size() ; i++){
            if(param.keySet().contains(list.get(i).split("님이")[0])){
                list.set(i,param.get(list.get(i).split("님이")[0])+ "님이" + list.get(i).split("님이")[1]);
            }
        }

        answer = list.toArray(answer);
        return answer;
    }

    public static void main(String[] args){

        String[] recode = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] result = solution(recode);
        for(int i = 0 ; i < result.length ; i++){
            System.out.println(result[i]);
        }
    }
}
