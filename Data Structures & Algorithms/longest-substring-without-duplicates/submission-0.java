class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();

        Set<Character> seen = new HashSet<>();
        int start = 0;
        int end = start;
        int len = 0;

        while (end < n) {
            char c = s.charAt(end);

            while(start < end && seen.contains(c)) {
                seen.remove(s.charAt(start++));
            }

            seen.add(s.charAt(end));
            len = Math.max(len, end-start+1);
            ++end;
        }
        return len;
    }
}
