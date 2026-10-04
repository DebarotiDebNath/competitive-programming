class Solution {
    public boolean checkValidString(String s) {
        int low = 0;
        int high = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                low++;
                high++;
            } else if (c == ')') {
                if (low > 0) low--;
                high--;
            } else { // '*''
                if (low > 0) low--; // as ')'
                high++;             // as '('
            }
            if (high < 0) return false; // for too many ')'
        }
        return low == 0;
    }
}