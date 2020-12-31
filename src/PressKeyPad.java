import java.util.Arrays;

public class PressKeyPad {

    public static String solution(int[] numbers, String hand) {

        int currentRight = -1;
        int currentLeft = -2;
        StringBuffer answer = new StringBuffer();
        int[][] keyPad = {{1,2,3},{4,5,6},{7,8,9},{-2,0,-1}};

        for(int x : numbers){
            if(x == 1 || x == 4 || x == 7){
                currentLeft = x;
                answer.append("L");
            } else if(x == 3 || x == 6 || x == 9){
                currentRight = x;
                answer.append("R");
            } else {
                int leftX = 0;
                int leftY = 0;
                int rightX = 0;
                int rightY = 0;

                int targetX = 0;
                int targetY = 0;

                for(int i = 0 ; i < 4; i++){
                    for(int j = 0 ; j < 3; j++){
                        if(keyPad[i][j] == currentLeft){
                            leftX = i;
                            leftY = j;
                        }
                        if(keyPad[i][j] == currentRight){
                            rightX = i;
                            rightY = j;
                        }
                        if(keyPad[i][j] == x){
                            targetX = i;
                            targetY = j;
                        }
                    }
                }

                int powLeft = Math.abs(leftX - targetX) + Math.abs(leftY - targetY);
                int powRight = Math.abs(rightX - targetX) + Math.abs(rightY - targetY);

                if(powLeft > powRight){
                    currentRight = x;
                    answer.append("R");
                } else if(powLeft < powRight){
                    currentLeft = x;
                    answer.append("L");
                } else {
                    if(hand.equals("right")){
                        currentRight = x;
                        answer.append("R");
                    }else if(hand.equals("left")){
                        currentLeft = x;
                        answer.append("L");
                    }
                }

            }
        }

        return answer.toString();
    }
    public static void main(String[] args) {
        System.out.println(solution(new int[]{4,5,0}, "right"));
        System.out.println("LLR");

        System.out.println(solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}, "right"));
        System.out.println("LLRLLRLLRL");
    }
}
