class Solution {
public:
    int minFlips(int a, int b, int c) {
        int flips = 0;
        
        for(int i = 0; (1 << i) <= max(max(a, b), c); i++){
            //check bit by bit
            int bit = 1 << i;
            int abit = a & bit ? 1 : 0;
            int bbit = b & bit ? 1 : 0;
            int cbit = c & bit ? 1 : 0;
            // cout << abit << " " << bbit << " " << cbit << endl;
            if(!(abit | bbit) && cbit){
                //both abit and bbit are 0
                //change a and b's current bit from 1 to 0
                flips++;
            }else if((abit & bbit) && !cbit){
                //both abit and bbit are 1
                //change a and b's current bit from 1 to 0
                flips+=2;
            }else if((abit ^ bbit) && !cbit){
                //one of abit and bbit is 0 and another is 1
                flips++;
            }
        }
        
        return flips;
    }
};