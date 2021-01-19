package programmers;

import java.util.*;

public class CandidateKey {
    public int solution(String[][] relation) {

        int x = relation.length;
        int y = relation[0].length;
        int answer = 0;

        StringBuffer candidateKeyList = new StringBuffer();

        int n = 0;
        while(n < y){

            n++;
            for(int j = 0 ; j < y ; j++){
                boolean checkCandidateKey = true;
                List<String> temp = new ArrayList<>();
                for(int i = 0 ; i < x ; i++){
                    String data = relation[i][j];
                    for(int k = 0 ; k < n; k++){
                        if(j+k >= y) break;
                        data += relation[i][j+k];
                    }
                    if(!temp.contains(data)){
                        temp.add(data);
                    }
                    else{
                        checkCandidateKey = false;
                        break;
                    }

                }

                if(!candidateKeyList.toString().contains(Integer.toString(j+n)) && checkCandidateKey == true) {
                    candidateKeyList.append(Integer.toString(j+n));
                    answer++;
                }
            }
        }


        return answer;
    }
    public static void main(String[] args){
        CandidateKey candidateKey = new CandidateKey();
        String[][] str = {{"100","ryan","music","2"},{"200","apeach","math","2"},
                {"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        System.out.println(candidateKey.solution(str));
    }
}
