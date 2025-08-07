package com.dsa.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Input : n = 4, taskMemory={7,2,3,9} and taskType={1,2,1,3}
 */
public class TaskScheduling {
    
    public static void main(String[] args) {
        List<Integer> taskMemory = Arrays.asList(7,2,3,9);
        List<Integer> taskType = Arrays.asList(1,2,1,3);
        int maxMemory = 10;

        System.out.println("Minimum Total Time : " + minProcessingTime(taskMemory, taskType, maxMemory));
    }

    public static int minProcessingTime(List<Integer> taskMemory, List<Integer> taskType, int maxMemory) {
        Map<Integer, List<Integer>> taskGroupsMap = new HashMap<>();
        for (int i = 0; i < taskMemory.size(); i++) {
            taskGroupsMap.computeIfAbsent(taskType.get(i), k-> new ArrayList<>()).add(taskMemory.get(i));
        }
        int totalTime=0;
        for(Map.Entry<Integer, List<Integer>> entry : taskGroupsMap.entrySet()) {
            List<Integer> memories = entry.getValue();
            Collections.sort(memories);

            int left = 0;
            int right = memories.size() - 1;
            while(left < right) {
                if(memories.get(left) + memories.get(right) <= maxMemory) {
                    totalTime++;
                    left++;
                    right--;
                } else {
                    totalTime++;
                    right--;
                }
            }

            if(left == right) {
                totalTime++;
            }
        }
        return totalTime;
    }
}
