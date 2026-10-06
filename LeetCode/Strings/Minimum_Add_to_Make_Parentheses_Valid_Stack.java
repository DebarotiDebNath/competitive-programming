class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int add = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else { // ')'
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // matched
                } else {
                    add++; // need an extra '('
                }
            }
        }

        return add + stack.size(); // unmatched '(' need ')'
    }
}