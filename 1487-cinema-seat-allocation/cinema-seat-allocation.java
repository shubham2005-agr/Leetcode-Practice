import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        // Map: row -> bitmask of reserved seats
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            // Store seat using bit position
            map.put(row, map.getOrDefault(row, 0) | (1 << col));
        }

        // Rows without any reservation
        int answer = (n - map.size()) * 2;

        // Masks for the three possible blocks
        int left = (1 << 2) | (1 << 3) | (1 << 4) | (1 << 5);
        int middle = (1 << 4) | (1 << 5) | (1 << 6) | (1 << 7);
        int right = (1 << 6) | (1 << 7) | (1 << 8) | (1 << 9);

        for (int mask : map.values()) {

            boolean leftFree = (mask & left) == 0;
            boolean rightFree = (mask & right) == 0;

            if (leftFree && rightFree) {
                // Both groups can sit together
                answer += 2;
            }
            else if (leftFree || rightFree) {
                // One of the two outer blocks is available
                answer += 1;
            }
            else if ((mask & middle) == 0) {
                // Only middle block is available
                answer += 1;
            }
        }
        return answer;
    }
}