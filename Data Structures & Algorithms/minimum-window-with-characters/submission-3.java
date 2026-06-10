class Solution {
    public String minWindow(String s, String t) {
        

        int n = s.length();
        int m = t.length();

        int[] tmap = new int[52];

        for (int i = 0; i < m; i++) {
            tmap[index(t.charAt(i))]++;
        }

        int len = n+1;
        String res = "";
        for (int i = 0; i < n; i++) {
            int[] smap = new int[52];
            for (int j = i; j < n; j++) {
                smap[index(s.charAt(j))]++;
                
                if (match(smap, tmap)) {
                    if (j-i+1 < len) {
                        len = j-i+1;
                        res = s.substring(i, j+1);
                    }
                }
            }
        }

        return res;
    }

    private void print(int[] map) {
        StringJoiner sj = new StringJoiner(",");
        for (int i : map) {
            sj.add(""+i);
        }
        System.out.println(sj.toString());
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
