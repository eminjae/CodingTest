package programmers;

import java.util.*;

public class RateSearch {

    public int[] solution(String[] info, String[] query) {

        String[][] result = new String[info.length][5];
        int[] answer = new int[query.length];

        for(int i = 0 ; i < info.length; i++){
            int now = 0;
            int next = 0;
            int index = 0;
            while((next = info[i].indexOf(" ", now)) > 0){
                result[i][index] = info[i].substring(now, next);
                if(index==3) {
                    result[i][index+1] = info[i].substring(next+1);
                }
                now = next+1;
                index++;
            }
        }

        for(int i = 0 ; i < query.length; i++){
            int cnt = 0;
            String str = query[i].replaceAll("and ","");
            String[] temp = new String[5];

            int now = 0;
            int next = 0;
            int index = 0;
            while((next = str.indexOf(" ", now)) > 0){
                temp[index] = str.substring(now, next);
                if(index==3){
                    temp[4] = str.substring(next+1);
                }
                now = next+1;
                index++;
            }

            String lang = temp[0];
            String type = temp[1];
            String career = temp[2];
            String food = temp[3];
            int score = Integer.parseInt(temp[4]);

            for(int j = 0 ; j < result.length; j++){

                int check = 0;
                if(lang.equals("-") || lang.equals(result[j][0])){
                   check++;
                } else {
                    continue;
                }

                if(type.equals("-") || type.equals(result[j][1])){
                    check++;
                } else {
                    continue;
                }

                if(career.equals("-") || career.equals(result[j][2])){
                    check++;
                } else {
                    continue;
                }
                if(food.equals("-") || food.equals(result[j][3])){
                    check++;
                } else {
                    continue;
                }
                if(score <= Integer.parseInt(result[j][4])){
                    check++;
                } else {
                    continue;
                }

                if(check ==5) cnt++;
            }



            answer[i] = cnt;

        }

        return answer;
    }

    public static void main(String[] args) {

        //String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        //String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        String[] info = {"java backend junior pizza 150", "java frontend senior pizza 10"};
        String[] query = {"java and - and - and pizza 10"};
        RateSearch rateSearch = new RateSearch();
        System.out.println(Arrays.toString(rateSearch.solution(info,query)));
    }
}
