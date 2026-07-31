// class Solution {
//     public int minBitFlips(int start, int goal) {
//           int xor = start^goal;
//           int count =0;
//           for(int i=0;i<31;i++){
//             if((xor>>i)%2==1) count++;
//           }
//           return count;
//     }
// }

class Solution{
    public int minBitFlips(int start, int goal){
    int xor = start^goal;
    int count =0;
    while(xor!=0){
        if((xor&1)==1) count++;
        xor = xor>>1;
    }
    return count;
    }
}
