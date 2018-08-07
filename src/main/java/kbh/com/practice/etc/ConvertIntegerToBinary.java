package kbh.com.practice.etc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConvertIntegerToBinary {

    public static void main(String[] args) {
        int number = 10;
        makeBinaryByIntegerFunction(number);
        makeBinaryByLogic(number);

    }

    private static void makeBinaryByLogic(int number) {
        List<String> binaryCharList = new ArrayList<>();
        for (int i = number; i >= 1; i/=2 ) {
            binaryCharList.add(String.valueOf(i%2));
        }
        Collections.reverse(binaryCharList);
        System.out.println(binaryCharList.toString());
    }

    private static void makeBinaryByIntegerFunction(int number) {
        String binaryString = Integer.toBinaryString(number);
        System.out.println(binaryString);
    }
}
