class Solution {

    public static class Counters {
        byte[] data = new byte[26];
        void incCounter(int idx) { data[idx]++; }
        @Override
        public int hashCode() { return Arrays.hashCode(data); }
        @Override
        public boolean equals(Object other) { return Arrays.equals(data, ((Counters)other).data); }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        final List<List<String>> res = new ArrayList<>();
        HashMap<Counters, List<String>> map = new HashMap<>();

        for (String str : strs) {
            map.compute(countLetters(str), (lt, list) -> {
                if (list == null) {
                    list = new ArrayList<>();
                    res.add(list);
                } 
                list.add(str);
                return list;
            } ); 
        }
        return res;
    }

    private Counters countLetters(String str) {
        Counters counters = new Counters();
        for (int i = 0; i < str.length(); i++) {
            counters.incCounter(str.charAt(i) - 'a');
        }
        return counters;
    }
}
