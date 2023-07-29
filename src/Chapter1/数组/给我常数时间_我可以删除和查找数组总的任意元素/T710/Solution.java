package Chapter1.数组.给我常数时间_我可以删除和查找数组总的任意元素.T710;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Solution {
    // 边界线，[0, sz)是正常元素，[sz, n)是黑名单
    int sz;
    // 用来存放黑名单映射
    Map<Integer, Integer> hashMap;
    Random random;

    public Solution(int n, int[] blacklist) {
        sz = n - blacklist.length;
        hashMap = new HashMap<>();
        random = new Random();

        // 初始化哈希表
        for (int b : blacklist) {
            hashMap.put(b, n);
        }

        // 从后往前
        int last = n - 1;
        for (int b : blacklist) {
            // 如果黑名单数本来就在[sz, n)中，那就不管它
            if (b >= sz) {
                continue;
            }
            // 从后往前遍历元素，如果这个元素是黑名单的数
            while (hashMap.containsKey(last)) {
                last--;
            }
            hashMap.put(b, last);
            last--;
        }
    }

    public int pick() {
        int val = random.nextInt(sz);
        if (hashMap.containsKey(val)) {
            return hashMap.get(val);
        }
        return val;
    }
}
