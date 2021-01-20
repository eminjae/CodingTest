package programmers;

import java.util.*;


public class Cache {

    static final int HIT = 1;
    static final int MISS = 5;

    public int solution(int cacheSize, String[] cities) {

        List<String> cacheList = new ArrayList<>();

        int answer = 0;

        for (int i = 0; i < cities.length; i++) {

            if (!cacheList.contains(cities[i].toUpperCase())) {
                cacheList.add(cities[i].toUpperCase());
                answer += MISS;
                if(cacheList.size() > cacheSize)
                    cacheList.remove(0);
            } else {
                cacheList.remove(cacheList.indexOf(cities[i].toUpperCase()));
                cacheList.add(cities[i].toUpperCase());
                answer += HIT;
            }


        }


        return answer;
    }
    public static void main(String[] args){
        Cache cache = new Cache();
        String[] str = {"Jeju", "Pangyo", "NewYork", "newyork"};
        System.out.println(cache.solution(2,str));
    }
}
