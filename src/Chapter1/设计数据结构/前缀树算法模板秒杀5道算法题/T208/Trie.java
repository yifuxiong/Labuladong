package Chapter1.设计数据结构.前缀树算法模板秒杀5道算法题.T208;

public class Trie {
    private Trie[] chidren;
    private boolean isEnd;  // true表示有单词，false表示没有单词

    public Trie() {
        this.chidren = new Trie[26];
        this.isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;

        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (node.chidren[index] == null) {
                node.chidren[index] = new Trie();
            }
            node = node.chidren[index];
        }
        node.isEnd = true;
    }

    // search()和startsWith()都是需要找前缀字符的
    // 所以我们这里先实现查找前缀字符的方法
    public Trie searchPrefix(String prefix) {
        Trie node = this;

        for (int i = 0; i < prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.chidren[index] == null) {
                return null;
            }
            node = node.chidren[index];
        }
        return node;
    }

    public boolean search(String word) {
        Trie node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        Trie node = searchPrefix(prefix);
        return node != null;
    }
}
