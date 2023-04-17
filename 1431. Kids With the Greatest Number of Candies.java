class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
                
        int greatest = candies[0];
        for(int i = 1; i < candies.length; i++) {
            if(candies[i] > greatest)
                greatest = candies[i];
        }
        
        List<Boolean> output = new ArrayList<>(candies.length);

        for(int i = 0; i < candies.length; i++) {
            if((candies[i] + extraCandies) >= greatest)
                output.add(true);
            else
                output.add(false);
        }
        return output;
    }
}
