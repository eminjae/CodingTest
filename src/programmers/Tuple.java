package programmers;

import java.util.*;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Tuple {
    public int[] solution(String s) {



        String str = s.replaceAll("},","");

        StringBuffer sb = new StringBuffer();
        sb.append(str);
        sb.deleteCharAt(str.length()-1);
        sb.deleteCharAt(str.length()-2);
        sb.deleteCharAt(1);
        sb.deleteCharAt(0);

        String[] splitS = sb.toString().split("\\{");

        List<String> sortedList = Arrays.stream(splitS).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());

        List<Integer> result = new ArrayList<>();

        for(int i = 0 ; i < sortedList.size(); i++){
            if(sortedList.get(i).contains(",")){
                String[] temp = sortedList.get(i).split(",");
                for(String x : temp){
                    if(!result.contains(Integer.parseInt(x))){
                        result.add(Integer.parseInt(x));
                    }
                }
            }else {
                result.add(Integer.parseInt(sortedList.get(i)));
            }
        }
        int[] answer = new int[result.size()];
        for(int i = 0 ;i < result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }

    public static void main(String[] args){
        Tuple tuple = new Tuple();

        System.out.println(tuple.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"));
    }
}
