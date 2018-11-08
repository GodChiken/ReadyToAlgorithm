package kbh.com.practice.codeTestPractice.hash;

import java.util.*;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class CheckPhoneNumberDuplicate {
    public static void main(String[] args) {
        System.out.println(solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(solution(new String[]{"123", "456", "789"}));
        System.out.println(solution(new String[]{"12", "123", "1235", "567", "88"}));
        System.out.println(solution(new String[]{"12232332", "12", "222222"}));
        System.out.println(solution(new String[]{"911", "97625999", "91125426"}));
        System.out.println(solution(new String[]{"113", "12340", "123440", "12345", "98346"}));
    }

    public static boolean solution(String[] phone) {

        Map<Character, Set<String>> phoneBook = new TreeMap<>();
        boolean isFind = false;

        Arrays.stream(phone).forEach(phoneNumber -> {
            Character phoneBookIndex = phoneNumber.charAt(0);
            if (phoneBook.containsKey(phoneBookIndex)) {
                Set<String> phoneNumberSetByIndex = phoneBook.get(phoneBookIndex);
                phoneNumberSetByIndex.add(phoneNumber);
                phoneBook.put(phoneBookIndex, phoneNumberSetByIndex);
            } else {
                Set<String> defaultPhoneSet = new TreeSet<>();
                defaultPhoneSet.add(phoneNumber);
                phoneBook.put(phoneBookIndex, defaultPhoneSet);
            }
        });

        List<Character> indexList = phoneBook.keySet().stream().collect(toList());

        for (Character index : indexList) {
            Set<String> phoneNumberSetInCategory = phoneBook.get(index);
            for (Iterator<String> phoneIterator = phoneNumberSetInCategory.iterator(); phoneIterator.hasNext(); ) {
                String phoneNumber = phoneIterator.next();
                Set<String> existStandardPhoneNumber = phoneNumberSetInCategory.stream()
                        .filter(element -> !element.equals(phoneNumber))
                        .filter(element -> element.length() >= phoneNumber.length())
                        .collect(toSet());
                isFind = existStandardPhoneNumber.stream()
                        .anyMatch(element -> element.startsWith(phoneNumber));
                if (isFind) {
                    return !isFind;

                }
            }
        }
        return !isFind;
    }
}
