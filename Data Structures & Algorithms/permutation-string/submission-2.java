class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // int k = s1.length();
        // int[] s1Freq = new int[26];
        // for (char c: s1.toCharArray()) {
        //     s1Freq[c-'a']++;
        // }
        // int[] s2Freq = new int[26];
        // int n = s2.length();
        // int diff = 0;
        // for (int i = 0; i < 26; i++) {
        //     if (s1Freq[i] != s2Freq[i]) diff++;
        // }
        // for (int end = 0; end < n; end++) {
        //     int c = s2.charAt(end) - 'a';
        //     if (s2Freq[c] == s1Freq[c]) diff++;
        //     s2Freq[c]++;
        //     if (s2Freq[c] == s1Freq[c]) diff--;

        //     if (end >= k) {
        //         int l = s2.charAt(end - k) - 'a';
        //         if (s2Freq[l] == s1Freq[l]) diff++;
        //         s2Freq[l]--;
        //         if (s2Freq[l] == s1Freq[l]) diff--;
        //     }

        //     if (diff == 0) return true;
        // }

        return _check(s1, s2);
    }

    private boolean _check(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[] s1map = new int[26];
        for(char c: s1.toCharArray()) {
            s1map[c-'a']++;
        }

        int i = 0;
        int j = i;

        int[] s2map = new int[26];
        while (j < n) {
            char c = s2.charAt(j);
            s2map[c-'a']++;
            
            if (j-i+1 == m) {
                if(check(s1map, s2map)) {
                    return true;
                } else {
                    s2map[s2.charAt(i)-'a']--;
                    i++;
                }
            }
            ++j;
        }
        return false;
    }

    private boolean check(int[] s1map, int[] s2map) {
        for (int i = 0; i < 26; i++) {
            if (s1map[i] != s2map[i]) return false;
        }
        return true;
    }
}
