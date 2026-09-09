class Solution {
    public long countCommas(long n) {
        long ans = 0;
        long start = 1000;
        long end = 999999;
        long commas = 1;

        while (start <= n) {
            long rangeEnd = Math.min(n, end);

            ans += (rangeEnd - start + 1) * commas;

            start *= 1000;
            end = end * 1000 + 999;
            commas++;
        }

        return ans;
    }
}
