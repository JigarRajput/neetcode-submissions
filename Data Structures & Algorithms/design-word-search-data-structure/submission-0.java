// Jai Ganesh

class WordDictionary {

    static class Node {
        Node[] links = new Node[26];

        boolean isEnd = false;

        boolean containsKey(char ch) {
            if(links[ch - 'a'] != null) {
                return true;
            }

            return false;
        }

        void putKey(char ch, Node node) {
            links[ch - 'a'] = node;
        }

        Node getKey(char ch) {
            return links[ch - 'a'];
        }
    }

    Node root;

    public WordDictionary() {
        root = new Node();
    }
    
    public void addWord(String word) {
        Node current = root;

        for(int ind = 0; ind < word.length(); ind++) {
            if(current.containsKey(word.charAt(ind))) {
                current = current.getKey(word.charAt(ind));
            }
            else {
                current.putKey(word.charAt(ind), new Node());
                current = current.getKey(word.charAt(ind));
            }
        }

        current.isEnd = true;
    }
    
    public boolean search(String word) {
        Node current = root;

        return contains(current, word, 0);

    }

    private static boolean contains(Node current, String word, int wordInd) {
        if(wordInd == word.length()) return current.isEnd;

        char ch = word.charAt(wordInd);

        if(ch != '.' && !current.containsKey(ch)) {
            return false;
        }
        else if(ch != '.') {
            Node updatedCurr = current.getKey(ch);

            return contains(updatedCurr, word, wordInd+1);
        }

        else {
            boolean doesChExists = false;

            for(char charac = 'a'; charac <= 'z'; charac++) {
                if(current.containsKey(charac)) {
                    Node updatedCurr = current.getKey(charac);
                    doesChExists = doesChExists | contains(updatedCurr, word, wordInd+1);
                }
                if(doesChExists) {
                    return true;
                }
            }

            return doesChExists;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */