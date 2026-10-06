class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0; // unmatched '('
        int add = 0;  // extra ')' needed

        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++;
            } else { // ')'
                if (open > 0) {
                    open--; // match with '('
                } else {
                    add++; // need an extra '('
                }
            }
        }

        return open + add; // unmatched '(' need ')'
    }
}