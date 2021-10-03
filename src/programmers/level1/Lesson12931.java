package programmers.level1;

public class Lesson12931 {

    public int solution(int n) {
        int answer = 0;
        String[] str = Integer.toString(n).split("");
        for(String s : str) {
            answer += Integer.parseInt(s);
        }
        return answer;
    }
}
