class Solution {
    public int minBitFlips(int start, int goal) {
          int xor = start^goal;
          int count =0;
          for(int i=0;i<31;i++){
            if((xor>>i)%2==1) count++;
          }
          return count;
    }
}