class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int len = temperatures.length;
        int[] result = new int[len];
        int[] monoStack = new int[len];
        int pointer = -1; // 0
        
        for (int i = 0; i < len; i++) {
            int t = temperatures[i];

            while (pointer >= 0 && temperatures[monoStack[pointer]] < t) {
                result[monoStack[pointer]] = i - monoStack[pointer];
                pointer--;
            }

            pointer++;
            monoStack[pointer] = i;
        }

        return result;
    }
}
