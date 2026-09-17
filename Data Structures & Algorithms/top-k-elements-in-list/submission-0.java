class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] counters = new int[2001];
        List<Set<Integer>> index = new ArrayList<>(); 
        index.add(new HashSet<>());
        for (int n : nums) {
            int idx = n + 1000;
            Set<Integer> prevBucket = index.get(counters[idx]);
            prevBucket.remove(n);
            counters[idx]++;
            Set<Integer> nextBucket;
            if (index.size() == counters[idx]) {
                nextBucket = new HashSet<>();
                index.add(nextBucket);
            } else {
                nextBucket = index.get(counters[idx]);
            }
            nextBucket.add(n);
        }

        int[] res = new int[k];
        int j = 0;
        for (int i = index.size() - 1; i >= 0; i--) {
            Set<Integer> elements = index.get(i);
            for (int n : elements) {
                res[j++] = n;
            }
            if (j == k) break;
        }

        return res;
    }
}
