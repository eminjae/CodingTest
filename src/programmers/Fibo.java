package programmers;

public class Fibo {
    public int solution(int n) {
        int answer = 0;
        int[] result = new int[n+1];
        result[0] = 0;
        result[1] = 1;

        for(int i = 2 ; i <= n ; i++){
            result[i] = (result[i-1] + result[i-2]) % 1234567;
        }
        answer = result[n];
        return answer;
    }


    public static void main(String[] args){
        Fibo fibo = new Fibo();
        System.out.println(fibo.solution(3));
        System.out.println(fibo.solution(5));
        System.out.println(fibo.solution(100000));
    }
}
