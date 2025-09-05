import java.util.Arrays;

public class LC875_KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        int high = Integer.MIN_VALUE;

        for (int num : piles){
            high = Math.max(high, num);
        }

        int low  = 1;
        int minK = Integer.MAX_VALUE;

        while (low <= high){
            int avg = (low + high) / 2;
            int hoursPassed = 0;
            for (int i = 0; i < piles.length; i++){
                hoursPassed += Math.ceil(piles[i] / (double) avg);
                if (hoursPassed > h){
                    low = avg + 1;
                    break;
                }
            }

            if (hoursPassed <= h){
                high = avg - 1;
                minK = avg;
            }
        }

        return minK;


    }
}
