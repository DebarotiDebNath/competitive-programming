class Solution {
    public boolean divisibleBy11(String s) {
        // code here
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0'; // convert chars into digits
            if (i % 2 == 0) sum += digit;
            else sum -= digit;
        }
        return sum % 11 == 0;
    }
}