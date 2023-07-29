package Chapter1.数组.给我常数时间_我可以删除和查找数组总的任意元素.T380;

// 设计

import java.util.*;

public class RandomizedSet {
    Random random;
    // 存储元素的值
    List<Integer> nums;
    // 每个元素对应的索引
    Map<Integer, Integer> hashMap;

    public RandomizedSet() {
        random = new Random();
        nums = new ArrayList<>();
        hashMap = new HashMap<>();
    }

    public boolean insert(int val) {
        if (hashMap.containsKey(val)) {
            return false;
        }
        int index = nums.size();
        nums.add(val);
        hashMap.put(val, index);
        return true;
    }

    public boolean remove(int val) {
        if (!hashMap.containsKey(val)) {
            return false;
        }
        // 待删除元素的索引
        int index = hashMap.get(val);
        // list最后一个元素的值
        int lastVal = nums.get(nums.size() - 1);

        // 哈希表将最后一个元素值对应的索引设置为待删除元素的位置
        hashMap.put(lastVal, index);
        // list中将待删除索引的位置设置为最后一个元素的值
        nums.set(index, lastVal);
        // nums.set(nums.size() - 1, val);

        // 哈希表删除这个key
        hashMap.remove(val);
        // 删除最后一个位置上的元素
        nums.remove(nums.size() - 1);
        return true;
    }

    public int getRandom() {
        return nums.get(random.nextInt(nums.size()));
    }
}
