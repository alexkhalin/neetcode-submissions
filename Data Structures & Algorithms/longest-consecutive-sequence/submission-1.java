class Solution {
    private static class UnionFind {
        
        private int[] parents;
        private int[] sizes;

        public UnionFind(int size) {
            parents = new int[size];
            sizes = new int[size];

            for (int i = 0; i < size; i++) {
                parents[i] = i;
            }

            Arrays.fill(sizes, 1);
        }

        public int find(int child) {
            int parent = parents[child];
            if (parent == child)
                return parent;
            
            return  parents[child] = find(parent);
        }

        public int union(int left, int right) {
            int parentLeft = find(left);
            int parentRight = find(right);

            if (sizes[parentLeft] > sizes[parentRight]) {
                parents[parentRight] = parentLeft;
                sizes[parentLeft] += sizes[parentRight];
                return sizes[parentLeft];
            } else {
                parents[parentLeft] = parentRight;
                sizes[parentRight] += sizes[parentLeft];
                return sizes[parentRight];
            }
        }


    }
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int longest = 1;
        Map<Integer, Integer> numsMap = new HashMap<>();
        UnionFind uf = new UnionFind(nums.length);
        for (int num : nums) {
            if (numsMap.containsKey(num)) continue;
            int id = numsMap.size();
            numsMap.put(num, id);
            Integer prevId = numsMap.get(num - 1);
            Integer nextId = numsMap.get(num + 1);
            if (prevId != null) {
                int len = uf.union(prevId, id);
                longest = Math.max(longest, len);
            }
            if (nextId != null) {
                int len = uf.union(id, nextId);
                longest = Math.max(longest, len);
            }
        }

        return longest;
    }
}
