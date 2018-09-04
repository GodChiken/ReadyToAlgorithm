package kbh.com.practice.level2;

import java.util.Arrays;
import java.util.IntSummaryStatistics;

import static java.util.Comparator.naturalOrder;
import static java.util.stream.Collectors.toList;

public class StringConverterForMaxAndMinNumber {
    public static void main(String[] args) {
        solution("1 2 3 4");
        solution("-1 -2 -3 -4");
        solution("-1 -1");
    }
    public static String solution(String s) {
        String[] splitArray = s.split(" ");
        String maxNumberString = Arrays.stream(splitArray)
                .map(stringNumber -> Integer.valueOf(stringNumber))
                .collect(toList()).stream()
                .max(naturalOrder()).get().toString();
        String minNumberString = Arrays.stream(splitArray)
                .map(stringNumber -> Integer.valueOf(stringNumber))
                .collect(toList()).stream()
                .min(naturalOrder()).get().toString();
        System.out.println(minNumberString+" "+maxNumberString);

        IntSummaryStatistics statistics =
                Arrays.stream(splitArray)
                        .mapToInt(Integer::parseInt)
                        .summaryStatistics();
        return minNumberString+" "+maxNumberString;
    }
    public static String anotherSolution(String s) {
        String[] splitArray = s.split(" ");
        IntSummaryStatistics statistics =
                Arrays.stream(splitArray)
                        .mapToInt(Integer::parseInt)
                        .summaryStatistics();
        return statistics.getMin()+" "+statistics.getMax();
    }
}
