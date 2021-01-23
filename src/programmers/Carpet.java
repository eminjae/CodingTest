package programmers;

public class Carpet {
    public int[] solution(int brown, int yellow) {

        int total = brown + yellow;
        int[] answer = new int[2];
        for(int i = 1 ; i < brown; i++){
            for (int j = 1 ; j < brown; j++){
                if((i*j == total) && (i*2+j*2-4)==brown){
                    answer[0] = i;
                    answer[1] = j;
                    break;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args){
        Carpet carpet = new Carpet();
        System.out.println(carpet.solution(10,2));
        System.out.println(carpet.solution(8,1));
        System.out.println(carpet.solution(24,24));
    }
}
