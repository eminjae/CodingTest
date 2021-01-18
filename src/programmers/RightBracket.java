package programmers;


public class RightBracket {
    boolean solution(String s) {

        boolean answer = true;
        int leftBracketCnt = 0;

        for(int i = 0 ; i< s.length(); i++){

            if(s.charAt(i) == '('){
               leftBracketCnt++;
            }else if(s.charAt(i) == ')'){
                leftBracketCnt--;
                if(leftBracketCnt < 0){
                    answer =false;
                    break;
                }

            }

        }
        if(leftBracketCnt > 0) answer = false;

        return answer;
    }

    public static void main(String[] args){
        RightBracket rightBracket = new RightBracket();
        System.out.println(rightBracket.solution("()()"));
        System.out.println(rightBracket.solution("(())()"));
        System.out.println(rightBracket.solution(")()("));
        System.out.println(rightBracket.solution("(()("));
    }
}
