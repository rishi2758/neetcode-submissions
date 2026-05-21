class Solution {
    public String minWindow(String s, String t) {
        int[] tFreq = new int[128];
        for (char c : t.toCharArray()) {
            tFreq[c]++;
        }
        int[] sFreq = new int[128];
        int n = s.length();
        int diff = 0;
        for (int i = 0; i < 128; i++) {
            if (tFreq[i] > 0) diff++;
        }
        String result = "";
        int start = 0;
        for (int end = 0; end < n; end++) {
            int c = s.charAt(end);
            sFreq[c]++;
            if (sFreq[c] == tFreq[c]) diff--;

            while (diff == 0) {
                if (result.isEmpty() || end - start + 1 < result.length())
                    result = s.substring(start, end + 1);

                int l = s.charAt(start);
                if (sFreq[l] == tFreq[l]) diff++;
                sFreq[l]--;
                start++;
            }
        }
        return result;
    }
}
