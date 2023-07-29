package 经典排序算法.桶排序;

// T347前K个高频元素

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();

        // 使用字典，统计每个元素出现的次数，元素为键，元素出现次数为值
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 桶排序
        // 将频率作为数组下标，对于出现频率不同的数字集合，存入对应的数组下标
        List<Integer>[] list = new List[nums.length + 1];
        for (int key : map.keySet()) {
            // 获取出现次数作为下标
            int index = map.get(key);
            if (list[index] == null) {
                list[index] = new ArrayList<>();
            }
            list[index].add(key);
        }

        // 倒序遍历数组获取出现顺序从大到小的排序
        for (int i = list.length - 1; i >= 0 && res.size() < k; i--) {
            if (list[i] == null) {
                continue;
            }
            res.addAll(list[i]);
        }

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
}
