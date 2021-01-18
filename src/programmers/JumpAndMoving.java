package programmers;

public class JumpAndMoving {


    public int solution(int n) {


        int ans = 0;
        int current = n;
        while(current!=0){

            if(current%2 == 0){
                current = current/2;
            } else {
                current = current-1;
                ans++;
            }
        }
        return ans;
    }


    public static void main(String[] args){
        JumpAndMoving jumpAndMoving = new JumpAndMoving();

        System.out.println(jumpAndMoving.solution(5000));


    }
}
