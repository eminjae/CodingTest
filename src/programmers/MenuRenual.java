package programmers;

import java.util.*;
import java.util.Comparator;
import java.util.stream.Collectors;

public class MenuRenual {
    public String[] solution(String[] orders, int[] course) {

        List<String> list = Arrays.asList(orders).stream()
                .sorted(Comparator.comparing(String::length)).collect(Collectors.toList());

        HashMap<String, Integer> param = new HashMap<>();

        for(int i = 0 ; i < list.size(); i++){
            if(!param.containsKey(list.get(i))) param.put(list.get(i),1);
            else param.put(list.get(i), param.get(list.get(i))+1);
        }
        String[] answer = {};
        return answer;
    }

    public static void main(String[] args) {
        MenuRenual menuRenual  = new MenuRenual();
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        System.out.println(Arrays.toString(menuRenual.solution(orders,course)));
    }
}
