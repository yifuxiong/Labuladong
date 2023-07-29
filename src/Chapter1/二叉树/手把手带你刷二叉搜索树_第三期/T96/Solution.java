package Chapter1.二叉树.手把手带你刷二叉搜索树_第三期.T96;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    // 方法一：动态规划
    // G(0)=1,G(1)=1
    // G(2)=G(0)*G(1)+G(1)*G(0)
    // ...
    // G(n)=G(0)*G(n-1)+G(1)*G(n-2)+...+G(n-1)*G(0)
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {  // j-1是左子树节点个数
                dp[i] += dp[j - 1] * dp[i - j];  // i-j是右子树节点个数
            }
        }
        return dp[n];
    }

    // 方法二：卡塔兰数
    // 递推公式如下：
    // G{n+1}=2(2n+1)/(n+2)*G{n}
    public int numTrees2(int n) {
        long G = 1;
        for (int i = 0; i < n; i++) {
            G = G * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) G;
    }

    // 卡塔兰数用数学公式表达：
    // 一般解：G{n+1}=C(2n,n)/(n+1)    (n=0,1,2,...)
    // 另类解：G{n+1}=C(2n,n)-C(2n,n+1)    (n=0,1,2,...)

    public static void main(String[] args) {
        Solution solut = new Solution();
        System.out.println(solut.numTrees2(3));
    }
}
