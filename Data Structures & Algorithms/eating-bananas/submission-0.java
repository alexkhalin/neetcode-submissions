class Solution {

    private int calcTime(int[] piles, int speed) {
        int time = 0;
        for (int pile : piles) {
            time += (int)Math.ceil((double)pile / speed);
        }

        return time;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int max = 1_000_000_000;
        int min = 1; 
        while (min != max) {
            int middle = (min + max) / 2;
            int time = calcTime(piles, middle);
            if (time <= h) {
                max = middle;
            } else {
                min = middle + 1;
            }
        }

        return min;
    }
}
