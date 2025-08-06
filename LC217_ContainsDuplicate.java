/*
Problem: 217. Contains Duplicate
Difficulty: Easy
Topics: Array, Hash Table
Source: NeetCode150
*/

import java.util.Set;
import java.util.HashSet;

public class LC217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums.length < 2) return false;

        Set<Integer> map = new HashSet<>();
        for (int num: nums){
            if (!map.add(num)){
                return true;
            }
        }
        return false;
    }
}