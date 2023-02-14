// https://school.programmers.co.kr/learn/courses/30/lessons/150370

import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Date todayDate = makeStringDateToDate(today);
        List<Integer> answerList = new ArrayList<>();
        
        Map<String, Integer> termsMap = new HashMap<>();
        for (String eachTerm : terms) {
            String[] eachTermSplit = eachTerm.split(" ");
            termsMap.put(eachTermSplit[0], Integer.parseInt(eachTermSplit[1]));
        }
        
        for (int i=0 ; i<privacies.length ; i++) {
            String eachPrivacy = privacies[i];
            String[] eachPrivacySplit = eachPrivacy.split(" ");
            Date currentDate = makeStringDateToDate(eachPrivacySplit[0]);
            currentDate = makeExpireDate(currentDate, termsMap.getOrDefault(eachPrivacySplit[1], 0));
    
            if (isExpired(todayDate, currentDate)) answerList.add(i+1);
        }
    
        int[] result = new int[answerList.size()];
        for (int i=0 ; i<answerList.size() ; i++) {
            result[i] = answerList.get(i);
        }
        return result;
    }
    
    public Date makeStringDateToDate(String date) {
        String[] dateSplit = date.split("\\.");
        
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, Integer.parseInt(dateSplit[0]));
        cal.set(Calendar.MONTH, Integer.parseInt(dateSplit[1])-1);
        cal.set(Calendar.DATE, Integer.parseInt(dateSplit[2]));
        
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        
        return cal.getTime();
    }
    
    public Date makeExpireDate(Date currentDate, int month) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.DATE, -1);
        cal.add(Calendar.MONTH, month);
        return cal.getTime();
    }
    
    
    public boolean isExpired(Date todayDate, Date currentDate) {
        return todayDate.compareTo(currentDate) >= 0;
    }
}
