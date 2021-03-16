package codingTest;

import java.util.ArrayList;
import java.util.List;

public class Kia2 {
    public String solution(String message){
        String[] str = new String[message.length()+1];
        for(int i = 1; i < str.length;i++){
            str[i] = String.valueOf(message.charAt(i-1));
        }
        List<String> result = new ArrayList<>();
        dfs(1, str.length, result, str);

        StringBuffer sb = new StringBuffer();
        for(int i = 0 ; i <result.size(); i++){
            sb.append(result.get(i));
        }
        return sb.toString();
    }
    void dfs(int index, int end, List<String> result, String[] str){
        if(index >= end) return;

        dfs(index*2, end, result, str);
        dfs(index*2+1, end, result, str);
        result.add(str[index]);
    }

    public static void main(String[] args) {
        String message = "ABCDEF";
        Kia2 kia2 = new Kia2();
        System.out.println(kia2.solution(message));
    }
}
