class Solution {
    public int characterReplacement(String s, int k) {
        // char, freq for a window start and end, 
        // start and end contains atmost k distinct characters
        // k == 0 and start - end contains more than k distinct characters not possible
        // k > 0 start-end distinct chars
        // aaababbbb k = 1
        // atmost k distnct character with min freq == k
        // countDistinctChars is equal to k or distinct Character + plus their frequency count == k
    
        // max freq element in a window dominates what res of the chracters are gping to convert to
        // 
        int n = s.length();
        Map<Character, Integer> freq = new HashMap<>();

        int start = 0;
        int end = start;
        int maxFreq = 0;
        int len = 0;
        while (end < n) {
            char c = s.charAt(end);
            
            freq.compute(c, (k1, v) -> (v == null) ? 1 : v + 1);
            maxFreq = Math.max(maxFreq, freq.get(c));

            while(start < end && ((end-start+1) - maxFreq) > k) {
                int f = freq.get(s.charAt(start));
                if (f == 0) freq.remove(s.charAt(start));
                else freq.put(s.charAt(start), f-1);
                ++start;
            }
            len = Math.max(len, end-start+1);

            end++;
        }

        return len;
    }
}
