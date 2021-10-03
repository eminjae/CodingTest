package programmers.level1;

public class Lesson12930 {

    public String solution(String s) {
        String answer = "";

        String[] str = s.split(" ", -1);

        for(int i = 0 ;i < str.length; i++) {
            String[] alphabet = str[i].split("");

            for(int j = 0 ; j < alphabet.length; j++) {
                if( (j%2) == 0 ) {
                    answer += alphabet[j].toUpperCase();
                } else {
                    answer += alphabet[j].toLowerCase();
                }
            }
            if(i!=str.length-1) answer += " ";
        }
        return answer;
    }

    public static void main(String[] args) {
        Lesson12930 lesson12930 = new Lesson12930();
        System.out.println(lesson12930.solution("try hello  #world  "));
    }
}
