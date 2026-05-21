class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        Map<Character, Integer> lastSeenAt = new HashMap<>();
        int start = 0;
        int end = start;
        int len = 0;

        while (end < n) {
            char c = s.charAt(end);

            if(lastSeenAt.containsKey(c) && lastSeenAt.get(c) >= start) {
                start = lastSeenAt.get(c)+1;
            }

            lastSeenAt.put(s.charAt(end), end);
            len = Math.max(len, end-start+1);
            ++end;
        }
        return len;
    }
}
