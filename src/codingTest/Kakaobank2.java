package codingTest;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Kakaobank2 {


    public int[] solution(String[] reqs) {
        HashMap<String, Integer> accountMap = new HashMap<>();
        int[] answer = new int[reqs.length];

        for(int i = 0 ; i < reqs.length; i++){
            StringBuilder sb = new StringBuilder();
            sb.append(reqs[i]);
            StringTokenizer st = new StringTokenizer(sb.toString()," ");

            String requestMethod = st.nextToken();
            String customerId = st.nextToken();
            int value = Integer.parseInt(st.nextToken());

            if(requestMethod.equals("CREATE")){
                if(accountMap.containsKey(customerId)){
                    answer[i] =  403;
                }else {
                    accountMap.put(customerId, value);
                    answer[i] =200 ;
                }
            }else if(requestMethod.equals("DEPOSIT")){
                if(!accountMap.containsKey(customerId)){
                    answer[i] = 404;
                }else {
                    accountMap.put(customerId, accountMap.get(customerId)+value);
                    answer[i] = 200;
                }
            }else if(requestMethod.equals("WITHDRAW")){
                if(!accountMap.containsKey(customerId)){
                    answer[i] = 404;
                }else {

                    if(accountMap.get(customerId) - value < 0){
                        answer[i] = 403;
                    }
                    else {
                        accountMap.put(customerId, accountMap.get(customerId)-value);
                        answer[i] = 200;
                    }
                }
            }

        }


        return answer;
    }

    public static void main(String[] args){
        //String[] str1 = {"DEPOSIT 3a 10000", "CREATE 3a 300000", "WITHDRAW 3a 150000", "WITHDRAW 3a 150001"};
        String[] str2 = {"CREATE 3a 1000000", "CREATE 3a3a 1000000", "DEPOSIT 3a 1000000", "DEPOSIT 3a3a 2000000", "DEPOSIT 3a3a3a 2000000"};
        //System.out.println(new Kakaobank2().solution(str1));
        System.out.println(new Kakaobank2().solution(str2));
    }
}
