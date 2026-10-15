class TimeMap {
    private static record Item(int timestamp, String value){};
    private Map<String, List<Item>> map;

    public TimeMap() {
        map = new HashMap<>();
        
    }
    
    public void set(String key, String value, int timestamp) {
        map.compute(key, (k, v) -> {
            if (v == null) {
                v = new ArrayList();
            }
            v.add(new Item(timestamp, value));

            return v;
        });
    }
    
    public String get(String key, int timestamp) {
        var list = map.get(key);
        if (list == null || list.get(0).timestamp > timestamp) return "";
        
        int left = 0;
        int right = list.size() - 1;
        while(left <= right) {
            int middle = (left + right) / 2;
            if (list.get(middle).timestamp <= timestamp) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        
        return list.get(right).value;
    }
}
