class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        int[] s1Freq = new int[26];
        for (char c: s1.toCharArray()) {
            s1Freq[c-'a']++;
        }
        int[] s2Freq = new int[26];
        int n = s2.length();
        int diff = 0;
        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] != s2Freq[i]) diff++;
        }
        for (int end = 0; end < n; end++) {
            int c = s2.charAt(end) - 'a';
            if (s2Freq[c] == s1Freq[c]) diff++;
            s2Freq[c]++;
            if (s2Freq[c] == s1Freq[c]) diff--;

            if (end >= k) {
                int l = s2.charAt(end - k) - 'a';
                if (s2Freq[l] == s1Freq[l]) diff++;
                s2Freq[l]--;
                if (s2Freq[l] == s1Freq[l]) diff--;
            }

            if (diff == 0) return true;
        }

        return false;
    }
}
