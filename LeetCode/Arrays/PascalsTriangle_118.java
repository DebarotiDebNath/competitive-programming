class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1)); // base case
        for (int i = 1; i < numRows; i++) {
            List<Integer> prev = result.get(i - 1); // prev row
            List<Integer> row = new ArrayList<>();  // new row

            row.add(1); // first element is always 1

            // middle elements
            for (int j = 1; j < prev.size(); j++) {
                row.add(prev.get(j - 1) + prev.get(j));
            }
            row.add(1); // last element is always 1
            result.add(row);
        }
        return result;
    }
}