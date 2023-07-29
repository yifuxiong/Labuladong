package 文件系统树型分支.T388;

public class Solution {
    // 官方【遍历】
    public int lengthLongestPath(String input) {
        int n = input.length();
        int pos = 0;
        int ans = 0;
        int[] level = new int[n + 1];

        while (pos < n) {
            // 检查文件当前深度
            int depth = 1;
            while (pos < n && input.charAt(pos) == '\t') {
                pos++;
                depth++;
            }

            // 统计当前文件名长度
            int len = 0;
            boolean isFile = false;
            while (pos < n && input.charAt(pos) != '\n') {
                if (input.charAt(pos) == '.') {
                    isFile = true;
                }
                len++;
                pos++;
            }

            // 跳过换行符
            pos++;

            if (depth > 1) {
                len += level[depth - 1] + 1;
            }
            if (isFile) {
                ans = Math.max(ans, len);
            } else {
                level[depth] = len;
            }
        }
        return ans;
    }

    // 递归
    int res = 0, i = 0;

    public int lengthLongestPath2(String input) {
        dfs(input.split("\n"), 0, 0);
        return res;
    }

    public void dfs(String[] str, int level, int len) {
        String s = "";
        for (int j = 1; j <= level; j++) {
            // 每深入一层，多一个"\t"
            s += "\t";
        }
        while (i < str.length) {
            // i是遍历str中的每块部分
            if (s.length() > 0 && str[i].startsWith(s) && !str[i].startsWith(s + "\t") ||
                    s.length() == 0 && !str[i].startsWith("\t")
            ) {
                if (str[i].contains(".")) {
                    // 如果是文件
                    res = Math.max(res, len + str[i++].length() - level);
                } else {
                    // 如果是目录
                    dfs(str, level + 1, (len + str[i++].length() - level) + 1);
                }
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        String input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext";

        Solution solut = new Solution();
        System.out.println(solut.lengthLongestPath(input));
        System.out.println(solut.lengthLongestPath2(input));
    }
}
