class Solution {
    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if  (c == '{' || c == '(' || c == '[')
                stack.push(c);
            else if (stack.isEmpty() || Math.abs(c - stack.pop()) > 2)
                return false;

        }
        return stack.isEmpty();
    }
}
