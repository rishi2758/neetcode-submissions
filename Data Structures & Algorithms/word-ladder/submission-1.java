class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> adjList = new HashMap<>();
        List<String> dict = new ArrayList<>(wordList);
        dict.add(beginWord);
        int n = dict.size();

        for (int i = 0; i < n; i++) {
            for (int j=i+1; j < n; j++) {
                String s1 = dict.get(i);
                String s2 = dict.get(j);
                if (valid(s1, s2)) {
                    adjList.computeIfAbsent(s1, k -> new ArrayList<>())
                        .add(s2);
                    adjList.computeIfAbsent(s2, k -> new ArrayList<>())
                        .add(s1);
                }
            }
        }

        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        visited.add(beginWord);
        int count = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int k =0; k < size; k++) {
                String word = q.poll();
                if (word.equals(endWord)) {
                    return count;
                }
                for (String adj: adjList.getOrDefault(word, new ArrayList<>())) {
                    if (visited.contains(adj)) continue;
                    visited.add(adj);
                    q.add(adj);
                }
            }
            ++count;
        }
        return 0;
    }

    private boolean valid(String s1, String s2) {
        if (s1.equals(s2)) return false;
        if (s1.length() != s2.length()) return false;
        int n = s1.length();
        int diff = 0;
        for (int i = 0; i < n; i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                ++diff;
            }
            if (diff > 1) return false;
        }
        return true;
    }
}
