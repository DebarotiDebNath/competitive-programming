class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        int countSmaller = 0;
        int countEqual = 0;

        for (int num : nums) {
            if (num < target) countSmaller++;
            else if (num == target) countEqual++;
        }

        for (int i = 0; i < countEqual; i++) list.add(countSmaller + i);
        return list;
    }
}