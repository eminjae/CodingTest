package codingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kakaobank4 {

    public int solution(int[] arr) {


        int answer = 0;
        List<Integer> result = new ArrayList<>();

        List<Integer> temp = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            temp.add(arr[i]);
        }
        if(temp.size() == 1 && temp.get(0) ==1){
            return 0;
        }
        while(true){

            if(result.size() == 1 && result.get(0) ==1){
                break;
            }
            result = new ArrayList<>();


            Loop1 :
            for(int i = 0 ; i < temp.size();){
                int cnt = 1;
                if(i == temp.size() -1 ) {
                    result.add(cnt);
                    break;
                }
                for(int j = i + 1 ; j < temp.size(); j++){
                    if(temp.get(i) == temp.get(j)){
                        cnt++;
                        if(j ==temp.size()-1){
                            result.add(cnt);
                            break Loop1;
                        }
                    }
                    else {
                        result.add(cnt);
                        i = j;
                        break;
                    }
                }
            }
            temp = new ArrayList<>();
            for(int i = 0 ; i < result.size(); i++){
                temp.add(result.get(i));
            }
            answer++;
        }


        return answer;
    }

    public static void main(String[] args){
//        System.out.println(new Kakaobank4().solution(new int[]{1, 1, 3, 3, 2, 2, 4, 5, 1, 1, 1, 3, 3, 3}));
     //   System.out.println(new Kakaobank4().solution(new int[]{1, 2, 3}));
//        System.out.println(new Kakaobank4().solution(new int[]{2, 2, 1, 1, 2, 2, 1, 1, 2, 2, 2, 1, 2}));
//        System.out.println(new Kakaobank4().solution(new int[]{2}));
//
//        System.out.println(new Kakaobank4().solution(new int[]{1}));
          System.out.println(new Kakaobank4().solution(new int[]{1000,100,500}));
    }
}


