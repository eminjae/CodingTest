package programmers;

import java.util.regex.Pattern;

public class JadenCaseString {
    public String solution(String s) {

        String[] str = s.replace(" ","#@").split("@");
        for(int i = 0 ; i < str.length;i++){
            String temp = str[i].substring(0,1);
            if(!Pattern.matches("^[0-9]*$",temp)){
                str[i] = temp.toUpperCase() + str[i].substring(1).toLowerCase();
            }else {
                str[i] = str[i].toLowerCase();
            }


        }
        String answer = "";
        for(int i = 0 ; i <str.length; i++){
            answer += str[i];
        }

        return answer.replace("#"," ");
    }
    public static void main(String[] args){
        System.out.println(new JadenCaseString().solution("  3people unFollowed me"));
        System.out.println(new JadenCaseString().solution("for the last week"));
    }
}
