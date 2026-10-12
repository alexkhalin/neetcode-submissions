class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        Integer[] indexes = new Integer[len];
        for (int i = 0; i < len; i++) {
            indexes[i] = i;
        }

        Arrays.sort(indexes, (i1, i2) -> position[i2] - position[i1]);
        int counter = 1;
        double groupETA = (target - position[indexes[0]]) / (double)speed[indexes[0]];
        for (int i = 1; i < len; i++) {
            int idx = indexes[i];
            double currETA = (target - position[indexes[i]]) / (double)speed[indexes[i]];
            if (groupETA < currETA) {
                groupETA = currETA;
                counter++;
            } 
        }
        return counter;
    }
}
