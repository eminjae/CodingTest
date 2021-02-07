package programmers;

public class MaxAndMin {
    public String solution(String s) {

        String[] splitS = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0 ; i < splitS.length; i++){
            max = Math.max(max, Integer.parseInt(splitS[i]));
            min = Math.min(min, Integer.parseInt(splitS[i]));
        }
        StringBuffer sb = new StringBuffer();
        sb.append(min);
        sb.append(" ");
        sb.append(max);
        return sb.toString();
    }

    public static void main(String[] args){
        System.out.println(new MaxAndMin().solution("1 2 3 4"));
        System.out.println(new MaxAndMin().solution("-1 -2 -3 -4"));
        System.out.println(new MaxAndMin().solution("-1 -1"));
    }
}
