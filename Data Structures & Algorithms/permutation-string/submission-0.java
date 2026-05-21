class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        Map<Character, Integer> s1Freq = new HashMap<>();
        for (char c: s1.toCharArray()) {
            s1Freq.compute(c, (k1,v)-> v == null ? 1: v+1);
        }
        int start = 0;
        int end = start;
        int n = s2.length();
        Map<Character, Integer> s2Freq = new HashMap<>();
        while (end < n) {
            char c = s2.charAt(end);
            
            if (!s1Freq.containsKey(c)) {
                s2Freq.clear();
                start = end + 1;
                ++end;
            } else {
                s2Freq.compute(c, (k1, v)-> v == null ? 1 : v+1);
                if (end-start+1 == k) {
                    if(check(s1Freq, s2Freq)) return true;
                    int f = s2Freq.get(s2.charAt(start));
                    if (f == 1)
                        s2Freq.remove(s2.charAt(start));
                    else 
                        s2Freq.put(s2.charAt(start), f-1);
                    ++start;
                }
                ++end;
            }
        }

        return false;
    }

    private boolean check(Map<Character, Integer> f1, Map<Character, Integer> f2) {
        for (Map.Entry<Character, Integer> entry: f1.entrySet()) {
            if (!f2.containsKey(entry.getKey()) || f2.get(entry.getKey()) != entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
