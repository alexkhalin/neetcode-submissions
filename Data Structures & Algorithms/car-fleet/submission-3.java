class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int len = position.length;
        double[] etas = new double[target + 1];
        for (int i = 0; i < len; i++) {
            int toDst = target - position[i];
            etas[toDst] = (double)toDst / speed[i];
        }

        int counter = 0;
        double groupETA = etas[0];
        for (int i = 1; i <= target; i++) {
            if (groupETA < etas[i]) {
                groupETA = etas[i];
                counter++;
            } 
        }
        return counter;
    }
}
