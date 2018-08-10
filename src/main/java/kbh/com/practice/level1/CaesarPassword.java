package kbh.com.practice.level1;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class CaesarPassword {
    public static void main(String[] args) {
        solution("AB",1);
        solution("z",1);
        solution("a B z",4);
    }

    private static String solution(String s, int n) {
        String[] splitCharArray = s.split("");
        List<Character> characterList = Arrays.stream(splitCharArray)
                                              .map(element -> element.charAt(0))
                                              .collect(toList());
        List<String> convertStringList = characterList.stream()
                                     .map(element -> {
                                         if(Character.isLowerCase(element)){
                                             return (char)((element-'a'+n)%26+'a');
                                         }else{
                                             return (char)((element-'A'+n)%26+'A');
                                         }
                                     })
                                     .collect(toList())
                                     .stream().map(element -> String.valueOf(element)).collect(toList());
        return String.join("",convertStringList).replace(">"," ");
    }
}
