package Chapter2.贪心类型问题.当老司机学会了贪心算法.T134;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;

        // 找中间某个站
        int lowest = 0;
        int index = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (gas[i] - cost[i]);

            if (sum < lowest) {
                lowest = sum;
                index = i + 1;
            }
        }
        if (sum < 0){
            return -1;
        }else{
            return index;
        }
    }

    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};

        int[] gas2 = {2, 3, 4};
        int[] cost2 = {3, 4, 3};

        Solution solut = new Solution();
        System.out.println(solut.canCompleteCircuit(gas, cost));
    }
}
