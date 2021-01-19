package programmers;

public class ExpectedMatch {

    public int solution(int n, int a, int b)
    {

        int left = Math.min(a,b);
        int right = Math.max(a,b);
        int answer = 0;
        for(int i = 0 ; i < n/2 ; i++){
            answer++;
            if(right%2 == 0 && right-left == 1){
                break;
            }

            left = left%2 == 0 ? left/2 : left/2+1;
            right = right%2 == 0 ? right/2 : right/2+1;

        }

        return answer;
    }
    public static void main(String[] args){
        ExpectedMatch expectedMatch = new ExpectedMatch();
        System.out.println(expectedMatch.solution(8,4,7));
    }
}
