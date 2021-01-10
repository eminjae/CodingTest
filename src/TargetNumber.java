import java.lang.annotation.Target;

public class TargetNumber {

    static int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, target,0);
        return answer;
    }

    void dfs(int[] numbers, int target, int k){

        if(k == numbers.length){
            int sum = 0;
            for(int n : numbers)
                sum += n;
            if(sum==target) answer++;
            return;
        } else {
           numbers[k] = numbers[k] * 1;
           dfs(numbers, target, k+1);
           numbers[k] = numbers[k] * (-1);
           dfs(numbers, target, k+1);
        }
    }

    public static void main(String[] args){
        TargetNumber tn = new TargetNumber();
        System.out.println(tn.solution(new int[]{1,1,1,1,1},3));
    }
}
