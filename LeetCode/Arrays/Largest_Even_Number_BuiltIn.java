class Solution {
    public String largestEven(String s) {
        if (s == null) return "";

        int idx = s.lastIndexOf('2');

        if (idx == -1) return "";
        return s.substring(0, idx + 1);
    }
}
