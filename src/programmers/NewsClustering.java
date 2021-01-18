package programmers;

import java.util.ArrayList;
import java.util.*;
import java.util.regex.Pattern;

public class NewsClustering {
    public int solution(String str1, String str2) {

        HashMap<String, Integer> param1 = new HashMap<>();
        HashMap<String, Integer> param2 = new HashMap<>();


        for(int i = 0 ; i < str1.length()-1 ; i++){
            String temp = str1.toUpperCase().substring(i,i+2);
            if(!param1.containsKey(temp)){
                param1.put(temp, 1);
            }
            else {
                param1.put(temp, param1.get(temp) + 1);
            }
        }

        for(int i = 0 ; i < str2.length()-1 ; i++){
            String temp = str2.toUpperCase().substring(i,i+2);
            if(!param2.containsKey(temp)){
                param2.put(temp, 1);
            }
            else {
                param2.put(temp, param2.get(temp) + 1);
            }
        }

        List<String> common = new ArrayList<>();
        List<String> total = new ArrayList<>();

        for(String key1 : param1.keySet()){
            if(!Pattern.matches("^[a-zA-Z]*$",key1)){
                continue;
            }

           if(param2.containsKey(key1)){
                int count1 = param1.get(key1);
                int count2 = param2.get(key1);

                for(int i = 0 ; i < Math.min(count1,count2) ; i++) common.add(key1);
                for(int i = 0 ; i < Math.max(count1,count2) ; i++) total.add(key1);
           } else {

               for(int i = 0 ; i < param1.get(key1); i++) total.add(key1);

           }
        }

        for(String key2 : param2.keySet()){
            if(!Pattern.matches("^[a-zA-Z]*$",key2)){
                continue;
            }

            if(!param1.containsKey(key2)){
                for(int i = 0 ; i < param2.get(key2); i++) total.add(key2);
            }
        }
        if(common.size() == 0 && total.size() == 0) return 65536;

        double result = common.size() / (double) total.size();
        int answer = (int) (result * 65536);
        return answer;
    }

    public static void main(String[] args){
        String str1 = "FRANCE";
        String str2 = "french";
        NewsClustering nc = new NewsClustering();

        System.out.println(nc.solution(str1,str2));


//        printf(%d\r\n, solution(AA_bb_aa_AA, BBB));
//        printf(%d\r\n, solution(CCDEFGHH, ABCCC));
//

    }

}
