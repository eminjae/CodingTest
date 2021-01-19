package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class StockPrice {
    public int[] solution(int[] prices) {

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < prices.length ; i++){
            q.add(prices[i]);
        }
        int seq = 0;
        int[] answer = new int[prices.length];
        while(!q.isEmpty()){
            int price = q.poll();
            seq++;
            int cnt = 0;
            for(int i = seq ; i < prices.length; i++){
                cnt++;
                if(price > prices[i]) {
                    break;
                }
            }
            answer[seq-1] = cnt;
        }

        return answer;
    }

    public static void main(String[] args){
        StockPrice stockPrice = new StockPrice();
        int[] prices = {1, 2, 3, 2, 3};

        int[] result = stockPrice.solution(prices);

        for(int i = 0 ; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }

}
