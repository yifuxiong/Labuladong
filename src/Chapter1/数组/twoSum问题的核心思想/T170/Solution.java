package Chapter1.数组.twoSum问题的核心思想.T170;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
* 设计并实现一个 TwoSum 的类，使该类需要支持 add 和 find 的操作。
*
    add 操作 - 对内部数据结构增加一个数。
    find 操作 - 寻找内部数据结构中是否存在一对整数，使得两数之和与给定的数相等。

    示例 1:
    add(1); add(3); add(5);
    find(4) -> true
    find(7) -> false

    示例 2:
    add(3); add(1); add(2);
    find(3) -> true
    find(6) -> false
* */
public class Solution {
    List<Integer> nums = new ArrayList<>();
    Set<Integer> set = new HashSet<>();

    public void add(int number) {
        for (int n: nums){
            set.add(n + number);
        }
        nums.add(number);
    }

    public boolean find(int value) {
        return set.contains(value);
    }
}
