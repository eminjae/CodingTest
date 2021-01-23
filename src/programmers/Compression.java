package programmers;

import java.util.*;

public class Compression {
    public int[] solution(String msg) {

        List<String> indexList = new ArrayList<>();

        List<Integer> result = new ArrayList<>();

        for (int i = 65; i <= 90; i++) {
            String temp = String.valueOf((char) i);
            indexList.add(temp);
        }
        String[] splitMsg = msg.split("");

        for (int i = 0; i < splitMsg.length; i++) {
            String selectedMsg = "";
            String prvSelectedMsg = "";
            boolean checkEnd = false;
            int index = i;
            while (!checkEnd) {
                if(index >= splitMsg.length) {
                    i = index-1;
                    result.add(indexList.indexOf(selectedMsg)+1);
                    break;
                }
                prvSelectedMsg = selectedMsg;
                selectedMsg += splitMsg[index];
                if (indexList.contains(selectedMsg)) {
                    index++;
                } else {
                    i = index-1;
                    result.add(indexList.indexOf(prvSelectedMsg) + 1);
                    indexList.add(selectedMsg);
                    checkEnd = true;
                }
            }
        }

        int[] answer = new int[result.size()];

        for(int i = 0 ; i < answer.length; i++){
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {

        Compression compression = new Compression();
        System.out.println(compression.solution("KAKAO"));
    }
}
