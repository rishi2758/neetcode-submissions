class Solution {

    // a [a, b c]
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[n] = true;
        for(int i = n-1; i >=0; i--) {
            for (int k=i; k < n; k++) {
                if (valid(s, i, k, dict)) {
                    dp[i] |= dp[k+1];
                }
            }
        }
        return dp[0];
        //return canBreak(s, 0, dict);
    }

    private boolean canBreak(String s, int i, Set<String> dict) {
        if (i == s.length()) return true;
        
        boolean res = false;
        for (int k = i; k < s.length(); k++) {
            if (valid(s, i, k, dict)) {
                res |= canBreak(s, k+1, dict);
            }
        }
        return res;
    }

    private boolean valid(String s, int i, int k, Set<String> dict) {
        return dict.contains(s.substring(i, k+1));
    }
}
