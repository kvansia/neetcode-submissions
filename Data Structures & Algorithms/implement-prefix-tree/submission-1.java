class PrefixTree {

    private class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            int i = ch - 'a';
            if(node.children[i] == null){
                node.children[i] = new TrieNode();
            }
            node = node.children[i];
        }
        node.isEnd = true;
    }

    private TrieNode searchPrefix(String word){
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            int i = ch - 'a';
            if(node.children[i] == null) return null;
            node = node.children[i];
        }
        return node;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}
