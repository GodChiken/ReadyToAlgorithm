package kbh.com.practice.codeTestPractice.hash;

import java.util.Map;
import java.util.TreeMap;

import static java.util.stream.Collectors.toList;

public class FindNotCompleteRunner {
    public static void main(String[] args) {
        solution(new String[]{"leo", "kiki", "eden"}, new String[]{"eden", "kiki"});
        solution(new String[]{"marina", "josipa", "nikola", "vinko", "filipa"}, new String[]{"josipa", "filipa", "marina", "nikola"});
        solution(new String[]{"mislav", "stanko", "mislav", "ana"}, new String[]{"stanko", "ana", "mislav"});
    }

    public static String solution(String[] participant, String[] completion) {

        Map<String, Integer> map = new TreeMap<>();

        for (String aParticipant : participant) {
            if (map.containsKey(aParticipant)) {
                int count = map.get(aParticipant);
                map.put(aParticipant, ++count);
            } else {
                map.put(aParticipant, 1);
            }
        }
        for (String aCompletion : completion) {
            if (map.containsKey(aCompletion)) {
                int count = map.get(aCompletion);
                map.put(aCompletion, --count);
            }
        }
        return map.entrySet().stream().filter(entrySet -> entrySet.getValue() == 1).map(Map.Entry::getKey).collect(toList()).get(0);
    }
}
