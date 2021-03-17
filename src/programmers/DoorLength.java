package programmers;

import java.util.HashSet;
import java.util.Set;

public class DoorLength {
    /*
    U: 위쪽으로 한 칸 가기  x, y+1
    D: 아래쪽으로 한 칸 가기 x, y-1
    R: 오른쪽으로 한 칸 가기 x+1, y
    L: 왼쪽으로 한 칸 가기 x-1,y
    */
    public int solution2(String dirs) {

        HashSet<String> hashSet = new HashSet<>();

        int x = 0;
        int y = 0;

        for(int i = 0 ; i < dirs.length(); i++){
            String temp = String.valueOf(dirs.charAt(i));
            int dx = x;
            int dy = y;
            if("U".equals(temp)){
                dy = y+1;

            }else if("D".equals(temp)){
                dy = y-1;

            }else if("R".equals(temp)){
                dx = x+1;

            }else if("L".equals(temp)){
                dx = x-1;

            }
            if(dx > 5 || dx <-5 || dy>5 || dy<-5){

                continue;
            }
            StringBuffer sb = new StringBuffer();
            sb.append(x).append(y).append(dx).append(dy);

            StringBuffer check = new StringBuffer();
            check.append(dx).append(dy).append(x).append(y);

            if(!hashSet.contains(check.toString())){
                hashSet.add(sb.toString());

            }

            x = dx;
            y = dy;


        }

        return hashSet.size();

    }
    public int solution(String dirs) {

        Set<HashsetNode> hashset = new HashSet<>();
        int x = 0;
        int y = 0;
        for(int i = 0 ; i < dirs.length(); i++) {
            String temp = String.valueOf(dirs.charAt(i));

            int dx = x;
            int dy = y;
            if("U".equals(temp)){
                dy = y+1;

            }else if("D".equals(temp)){
                dy = y-1;

            }else if("R".equals(temp)){
                dx = x+1;

            }else if("L".equals(temp)){
                dx = x-1;

            }

            if(dx > 5 || dx <-5 || dy>5 || dy<-5){
                continue;
            }
            HashsetNode hashsetNode = new HashsetNode(String.valueOf(x)+y, String.valueOf(dx)+dy);
            HashsetNode otherwiseHsashsetNode = new HashsetNode(String.valueOf(dx)+dy, String.valueOf(x)+y);

            if(!hashset.contains(otherwiseHsashsetNode)) hashset.add(hashsetNode);

            x = dx;
            y = dy;

        }


        return hashset.size();
    }

    public static void main(String[] args) {
        DoorLength doorLength = new DoorLength();
        System.out.println(doorLength.solution("ULURRDLLU"));
        System.out.println(doorLength.solution("LULLLLLLU"));
        System.out.println(doorLength.solution("UDU"));
    }
}
class HashsetNode{
    String start;
    String end;
    public HashsetNode(String start, String end){
        this.start = start;
        this.end = end;
    }
    @Override
    public boolean equals(Object obj){
        HashsetNode node = (HashsetNode) obj;

        return node.start.equals(this.start) && node.end.equals(this.end);
    }
    @Override
    public int hashCode(){
        return (start+end).hashCode();
    }
}
