class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();

        int[] tmap = new int[52];
        int distinct = 0;
        for (int i = 0; i < m; i++) {
            tmap[index(t.charAt(i))]++;
            if (tmap[index(t.charAt(i))] == 1) ++distinct;
        }

        int len = n+1;
        String res = "";
        int[] smap = new int[52];
        int i = 0;
        int matched = 0;
        for (int j = 0; j < n; j++) {
            smap[index(s.charAt(j))]++;
            if (tmap[index(s.charAt(j))] == smap[index(s.charAt(j))]) matched++;

            while (matched == distinct) {
                if (j-i+1 < len) {
                    len = j-i+1;
                    res = s.substring(i, j+1);
                }
                smap[index(s.charAt(i))]--;
                if (tmap[index(s.charAt(i))] > smap[index(s.charAt(i))])
                    matched--;
                i++;
            }
        }

        return res;
    }

    private boolean match(int[] smap, int[] tmap) {
        for(int i=0; i< 52; i++) {
            if(tmap[i] != 0) {
                if (tmap[i] > smap[i]) return false;
            }
        }
        return true;
    }

    private int index(char ch) {
        return (ch >= 'a' && ch <= 'z') ? (ch - 'a' + 26) : (ch - 'A');
    }
}
