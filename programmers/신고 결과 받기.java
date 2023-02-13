// https://school.programmers.co.kr/learn/courses/30/lessons/92334

import java.util.*;

class Solution {
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] result = new int[id_list.length];

		Map<String, Set<String>> reportingMap = new HashSet<>();
		Map<String, Integer> mailCountingMap = new HashMap<>();

		for (String eachReport : report) {
			String[] eachReportSplit = eachReport.split(" ");
			String reporterName = eachReportSplit[0];
			String reporteeName = eachReportSplit[1];
			Set<String> reportees = reportingMap.getOrDefault(reporteeName, new HashSet());
			reportees.add(reporterName);
			reportingMap.put(reporteeName, reportee);
		}

		for (String reporteeName : reportingMap.keySet()) {
			Set<String> reportees = reportingMap.getOrDefault(reporteeName, new HashSet());
			if (reportees.size() >= k) {
				for (String reporterName : reportees) {
					mailCountingMap.put(reporterName, mailCountingMap.getOrDefault(reporterName, 0)+1);
				}
			}
		}

		for (int i=0 ; i<result.length ; i++) {
			result[i] = mailCountingMap.getOrDefault(id_list[i], 0);
		}

		return result;
	}
}


// import java.util.*;

// class Solution {
//     public int[] solution(String[] id_list, String[] report, int k) {
//         int[] answer = new int[id_list.length];
//         Map<String, Set<String>> reportRelationMap = new HashMap<>();
//         for (String reportEach : report) {
//             String[] split = reportEach.split(" ");
//             String reporter = split[0];
//             String reportee = split[1];
            
//             Set<String> reporters = new HashSet<>();
//             if (reportRelationMap.containsKey(reportee)) {
//                 reporters = reportRelationMap.get(reportee);
//             } 
            
//             reporters.add(reporter);
//             reportRelationMap.put(reportee, reporters);
//         }
        
//         Map<String, Integer> reportMailCounterMap = new HashMap<>();
//         Set<String> reportRelationMapKeySet = reportRelationMap.keySet();
//         for (String key : reportRelationMapKeySet) {
//             Set<String> reporters = reportRelationMap.get(key);
//             if (reporters.size() >= k) {
//                 for (String reporter : reporters) {
//                     int currentCounter = 0;
//                     if (reportMailCounterMap.containsKey(reporter)) {
//                         currentCounter = reportMailCounterMap.get(reporter);
//                     }
//                     currentCounter++;
//                     reportMailCounterMap.put(reporter, currentCounter);
//                 }
                
//             }
//         }
        
//         System.out.println(reportMailCounterMap.toString());
        
//         for (int i=0 ; i<id_list.length ; i++) {
//             if (reportMailCounterMap.containsKey(id_list[i])) {
//                 answer[i] = reportMailCounterMap.get(id_list[i]);
//             } else {
//                 answer[i] = 0;
//             }
//         }
        
//         return answer;
//     }
// }
