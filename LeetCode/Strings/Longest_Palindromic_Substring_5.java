class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return ""; //base case

        int start = 0; // for centres
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Odd case: centre at (i,i)
            int left = i;
            int right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            int len1 = right - left - 1; // overshoot correction

            // Even case: centre at (i, i+1)
            left = i;
            right = i+1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            }
            int len2 = right - left - 1;

            // longer of the two
            int len = Math.max(len1, len2);
            if (len > end - start) {
                // Update start and end indices
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
}