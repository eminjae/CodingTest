package programmers;

import java.util.*;

public class Printer {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Node> queue = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0 ;i < priorities.length; i++){
            queue.add(new Node(i,priorities[i]));
            priorityQueue.add(priorities[i]);
        }

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int index = node.index;
            int temp = node.priority;

            if(temp == priorityQueue.peek()){
                answer++;
                priorityQueue.poll();
                if(index == location) break;
            }else {
                queue.add(node);
            }

        }

        return answer;
    }


    public static void main(String[] args){
        Printer printer = new Printer();
        System.out.println(printer.solution(new int[]{1,1,1},2));
        System.out.println(printer.solution(new int[]{1,1,9,1,1,1},0));
    }
}
class Node{
    int index;
    int priority;
    Node(int index, int priority){
        this.index = index;
        this.priority = priority;
    }
}
