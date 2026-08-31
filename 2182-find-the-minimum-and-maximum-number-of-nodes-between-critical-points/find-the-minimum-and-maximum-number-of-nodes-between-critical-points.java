class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        int first = -1;
        int prevCritical = -1;

        int minDistance = Integer.MAX_VALUE;
        int lastCritical = -1;

        ListNode prev = head;
        ListNode curr = head.next;

        int position = 1;

        while (curr != null && curr.next != null) {

            // Check whether curr is a critical point
            if ((curr.val > prev.val && curr.val > curr.next.val) ||
                (curr.val < prev.val && curr.val < curr.next.val)) {

                if (first == -1) {
                    // First critical point
                    first = position;
                } else {
                    // Distance from previous critical point
                    minDistance = Math.min(
                        minDistance,
                        position - prevCritical
                    );
                }

                prevCritical = position;
                lastCritical = position;
            }

            prev = curr;
            curr = curr.next;
            position++;
        }

        // Fewer than 2 critical points
        if (first == -1 || first == lastCritical) {
            return new int[]{-1, -1};
        }

        int maxDistance = lastCritical - first;

        return new int[]{minDistance, maxDistance};
    }
}