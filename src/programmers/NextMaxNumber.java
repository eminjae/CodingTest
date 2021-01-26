package programmers;

public class NextMaxNumber {

    public int solution(int n) {

        String str = Integer.toBinaryString(n);

        int cnt = 0;
        for(int i = 0 ; i < str.length(); i++){
            if(str.charAt(i) == '1'){
                cnt++;
            }
        }

        int answer = 0;
        int otherN = n;
        while(true){
            int tempCnt = 0;
            otherN++;
            String temp = Integer.toBinaryString(otherN);
            for(int i = 0 ; i < temp.length(); i++){
                if(temp.charAt(i) == '1'){
                    tempCnt++;
                }
            }
            if(cnt == tempCnt){
                answer = otherN;
                break;
            }

        }

        return answer;
    }

    public static void main(String[] args){
        Level2Test1 level2Test1 = new Level2Test1();

        System.out.println(level2Test1.solution(78));
        System.out.println(level2Test1.solution(15));
    }
}
