package programmers;

public class LCM {
    public int solution(int[] arr) {
        int answer = 0;

        int value = calculate(arr[0],arr[1]);
        for(int i = 2 ; i < arr.length; i++){
            value = calculate(value, arr[i]);
        }
        return value;
    }
    public int calculate(int x, int y){
        int min = Math.min(x,y);
        int max = Math.max(x,y);
        int gcd = 0;
        int temp = 1;
        while(temp!=0){
            temp = max % min;
            max = min;
            min = temp;
        }
        gcd = x*y/max;
        return gcd;
    }
    public static void main(String[] args){
        System.out.println(new LCM().solution(new int[]{2,6,8,14}));
        System.out.println(new LCM().solution(new int[]{1,2,3}));
    }
}
