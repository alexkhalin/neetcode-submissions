class Solution {
    public int[] twoSum(int[] nums, int target) {
        final int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>(2000);
        for (int i = 0; i < len; i++) {
            int num = nums[i];
            Integer second = map.get(target - num);
            if (second != null) return new int[]{second, i};
            map.put(num, i);
        }

        return new int[] {0, 0};
    }
}
