package c72_0219_2022.T5997;

// 第3题
// 拆分成最多数目的偶整数之和
// 贪心算法

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Long> maximumEvenSplit(long finalSum) {
        List<Long> ans = new ArrayList<>();
        if (finalSum % 2 != 0) {
            return ans;
        }

        int sum = 0;
        for (long i = 2; i <= finalSum; i += 2) {
            if (sum + i > finalSum) {
                long last = ans.remove(ans.size() - 1);
                ans.add(last + finalSum - sum);
                break;
            } else {
                sum += i;
                ans.add(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        long finalSum = 6;

        Solution solut = new Solution();
        System.out.println(solut.maximumEvenSplit(finalSum));
    }
}
