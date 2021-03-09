package codingTest;

public class AutoEver1 {

    public int solution(int n) {
        String strNum = Integer.toString(n);
        int sum = 0 ;
        for(int i = 0 ;i <strNum.length(); i++){
            sum += Integer.parseInt(String.valueOf(strNum.charAt(i)));
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println(new AutoEver1().solution(1));
        System.out.println(new AutoEver1().solution(100000000));
    }
}
