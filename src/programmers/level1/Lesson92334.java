package programmers.level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Lesson92334 {

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> userMap = new HashMap<>();
        for(String id : id_list) {
            userMap.put(id, 0);
        }
        List<String> distinctReports = Arrays.stream(report).distinct().collect(Collectors.toList());

        Map<String, Integer> reportMap = new HashMap<>();
        for(String distinctReport : distinctReports) {
            String userId = distinctReport.split(" ")[0];
            String reportedId = distinctReport.split(" ")[1];
            if(reportMap.containsKey(reportedId)) {
                reportMap.put(reportedId, reportMap.get(reportedId) + 1);
            } else {
                reportMap.put(reportedId, 1);
            }
        }

        for(String distinctReport : distinctReports) {
            String userId = distinctReport.split(" ")[0];
            String reportedId = distinctReport.split(" ")[1];

            if(reportMap.get(reportedId) >= k) {
                userMap.put(userId, userMap.get(userId) + 1);
            }
        }

        for(int i = 0 ; i < id_list.length; i++) {
            answer[i] = userMap.get(id_list[i]);
        }

        return answer;
    }

    public static void main(String[] args) {
        Lesson92334 lesson92334 = new Lesson92334();
        String[] id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] report = new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
        int k = 2;
        int[] result = lesson92334.solution(id_list, report, k);
        System.out.println(Arrays.toString(result));
    }
}
