class Solution {
    public char findTheDifference(String s, String t) {
        char[] charArray = t.toCharArray();
        Arrays.sort(charArray);
        char[] charArray1 = s.toCharArray();
        Arrays.sort(charArray1);
        int i = 0;

        for(i = 0; i < charArray1.length; i++) {
            if(charArray[i] != charArray1[i])
                break;
        }
        if(i == charArray.length)
            return charArray[i-1];
        return charArray[i];
    }
}