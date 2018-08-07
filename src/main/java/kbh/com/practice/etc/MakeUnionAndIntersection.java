package kbh.com.practice.etc;

import java.util.*;

public class MakeUnionAndIntersection {
    private static String[] aGroup = {"1","2","3","4","5","6","7"};
    private static String[] bGroup = {"6","7","8","9"};

    public static void main(String[] args) {
        makeUnion(aGroup,bGroup);
        makeIntersection(aGroup,bGroup);
    }

    private static void makeIntersection(String[] aGroup, String[] bGroup) {
        List<String> intersectionList = new ArrayList<>();
        if(aGroup.length > bGroup.length){
            for (String aElement : aGroup) {
                for (String bElement : bGroup) {
                    if(bElement.contains(aElement)){intersectionList.add(bElement);}
                }
            }
        }else{
            for (String bElement : bGroup) {
                for (String aElement : aGroup) {
                    if(aElement.contains(bElement)){intersectionList.add(aElement);}
                }
            }
        }
        System.out.println(intersectionList.toString());
    }

    private static void makeUnion(String[] aGroup, String[] bGroup) {
        Set<String> unionSet = new HashSet<>();
        unionSet.addAll(Arrays.asList(aGroup));
        unionSet.addAll(Arrays.asList(bGroup));
        System.out.println(unionSet.toString());
    }
}
