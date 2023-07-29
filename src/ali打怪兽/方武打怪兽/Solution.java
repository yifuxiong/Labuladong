package ali打怪兽.方武打怪兽;

public class Solution {
    public int function(int a, int b, int c, int attack, int skill) {
        // 技能是群攻
        int count = Integer.MAX_VALUE;
        int left = 0;
        int maxVal = Math.max(a, Math.max(b, c));
        int right = (maxVal + skill - 1) / skill;

        for (int i = left; i <= right; i++) {
            int k1 = (a - i * skill + attack - 1) / attack;
            int k2 = (b - i * skill + attack - 1) / attack;
            int k3 = (c - i * skill + attack - 1) / attack;
            int whole = k1 + k2 + k3 + i;
            if (whole < count) {
                count = whole;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int a = 12;
        int b = 6;
        int c = 5;
        int attack = 5;
        int skill = 2;

        Solution solut = new Solution();
        System.out.println(solut.function(a, b, c, attack, skill));
    }
}
