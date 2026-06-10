class Solution {
    public int characterReplacement(String s, int k) {
        // find longest substring such that total_len - maxFreq == k
        
        int n = s.length();
        int i = 0;
        int j = i;

        int len = 0;

        int[] smap = new int[26];
        int ch = ' ';
        int freq = 0;

        while (j < n) {
            smap[s.charAt(j)-'A']++;
            freq = Math.max(freq, smap[s.charAt(j)-'A']);
            
            while (i < j && (j-i+1) - freq > k) {
                smap[s.charAt(i)-'A']--;
                i++;
            }
            
            len = Math.max(len, j-i+1);
            j++;
        }

        return len;
        
    }

    private int maxFreq(int[] smap) {
        int max = 0;
        for (int freq: smap) {
            max = Math.max(max, freq);
        }
        return max;
    }
}
