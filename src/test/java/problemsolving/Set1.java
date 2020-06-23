package problemsolving;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class Set1 {

    /**
     * Emma is playing a new mobile game that starts with consecutively numbered clouds.
     * Some of the clouds are thunderheads and others are cumulus.
     * She can jump on any cumulus cloud having a number that is equal to the number of the current cloud plus 1 or 2.
     * She must avoid the thunderheads.
     * Determine the minimum number of jumps it will take Emma to jump from her starting position to the last cloud.
     * It is always possible to win the game
     */
    @Test
    public void jumpingOnTheClouds() {
        int[] arr = new int[]{0, 0, 0, 1, 0, 0};

        int count = 0;
        int right = 1;

        while (right < arr.length) {
            if (arr[right] == 0 && right + 1 >= arr.length) {
                count++;
                right++;
            } else if (arr[right + 1] == 0) {
                count++;
                right = right + 2;
            } else if (arr[right] == 0) {
                count++;
                right++;
            }
        }

        Assert.assertEquals(count, 3);
    }

}
