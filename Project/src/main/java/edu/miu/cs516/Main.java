package edu.miu.cs516;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<int[]> results = findIndices(new int[]{2, 7, 11, 15}, 9);
        results.forEach(pair -> System.out.println(pair[0] + "," + pair[1]));
    }

    public static List<int[]> findIndices(int[] nums, int target) {
        Map<Integer, Integer> prevIndices = new HashMap<>();
        List<int[]> results = new ArrayList<>();
        for(int i = 0; i < nums.length; i++) {
            int curNum = nums[i];
            int expectNum = target - curNum;
            if(prevIndices.containsKey(curNum)) {
                int[] pair = new int[]{prevIndices.get(curNum), i};
                results.add(pair);
            } else {
                prevIndices.put(expectNum, i);
            }
        }
        return results;
    }
}
