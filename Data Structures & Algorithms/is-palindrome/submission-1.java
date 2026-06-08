class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int i = 0;
        int j = n-1;
        
        while (i < j) {
            /**
            Uppercase: Decimal 65 to 90 (e.g., \(A = 65\), \(Z = 90\))
            Lowercase: Decimal 97 to 122 (e.g., \(a = 97\), \(z = 122\))
            Integers (Digits): Decimal 48 to 57 (e.g., \(0 = 48\), \(9 = 57\))
            */
            while (j > i && !isValidChar(s.charAt(j)) || s.charAt(j)==' ') --j;
            while (i < j && !isValidChar(s.charAt(i)) || s.charAt(i)==' ') ++i;

            if (Character.toLowerCase(s.charAt(j)) == Character.toLowerCase(s.charAt(i))) {
                --j;
                ++i;
            } else {
                return false;
            }
        }

        return true;
    }

    private boolean isValidChar(char c) {
        return (Character.toLowerCase(c)-'a' >=0 && Character.toLowerCase(c)-'a' <= 25) || Character.isDigit(c);
    }
}
