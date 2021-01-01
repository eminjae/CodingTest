
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SkillTree {

    static public int solution(String skill, String[] skill_trees) {

        String[] arraySkill = skill.split("");

        int answer = 0;

        for(String s : skill_trees){
            Queue q = new LinkedList();
            String[] temp = s.split("");
            for(int i = 0 ; i < temp.length ; i++){
                if(Arrays.asList(arraySkill).contains(temp[i])){
                    q.add(temp[i]);
                }
            }
            int index = 0;
            while(!q.isEmpty()){
                if(index >= arraySkill.length){
                    index = 0;
                }
                if(arraySkill[index].equals(q.peek())){
                    q.poll();
                    index++;
                }
                else {
                    break;
                }
            }
            if(q.isEmpty()) answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("CBDK", new String[]{"CB","CXYB","BD","AECD","ABC","AEX","CDB","CBKD","IJCB","LMDK"}));
        System.out.println(solution("BDC", new String[]{"AAAABACA"}));

    }
}
