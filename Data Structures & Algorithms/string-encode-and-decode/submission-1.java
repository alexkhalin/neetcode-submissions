class Solution {

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (String str: strs) {
            builder
                .append((char) str.length())
                .append(str);
        }
        return builder.toString();
    }

    public List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < str.length(); ) {
            int len = str.charAt(i);
            String substr = str.substring(i + 1, i + len + 1);
            res.add(substr);
            i += len + 1;
        }
        return res;
    }
}
