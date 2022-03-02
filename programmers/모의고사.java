import java.util.*;

class Person {
    int personNum;
    int count;
    
    Person(int personNum) {
        this.personNum = personNum;
        this.count = 0;
    }
}

class Solution {
    public int[] solution(int[] answers) {
        
        // 각 번호마다 각 사람이 찍는 답을 알고리즘화
        // for문으로 문제마다 각 사람의 답 비교해서 Counting
        
        // first person : index % 5 + 1
        // second person : {2, 1, 2, 3, 2, 4, 2, 5} index % 8 로 반복
        // third person : {3, 3, 1, 1, 2, 2, 4, 4, 5, 5} index % 10으로 반복
        
        
        int[] secondPerson = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] thirdPerson = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        List<Person> personList = new ArrayList<>();
        personList.add(new Person(1));
        personList.add(new Person(2));
        personList.add(new Person(3));
        
        for (int i=0 ; i<answers.length ; i++) {
            int currentAns = answers[i];
            if (currentAns == i % 5 + 1) {
                personList.get(0).count += 1;
            }
            if (currentAns == secondPerson[i % 8]) {
                personList.get(1).count += 1;
            }
            if (currentAns == thirdPerson[i % 10]) {
                personList.get(2).count += 1;
            }
        }
        
        Collections.sort(personList, (p1,p2) -> p1.count > p2.count ? -1 : 1);
        
        List<Integer> answer = new ArrayList<>();
        
        int largest = personList.get(0).count;
        for (Person person : personList) {
            if (person.count == largest) {
                answer.add(person.personNum);
            }
        }
        
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}
