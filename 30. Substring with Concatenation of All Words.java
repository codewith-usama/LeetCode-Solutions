class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        if (s.length() < totalLen) {
            return result;
        }
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i <= s.length() - totalLen; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = i;
            while (j < i + totalLen) {
                String word = s.substring(j, j + wordLen);
                if (!counts.containsKey(word)) {
                    break;
                }
                seen.put(word, seen.getOrDefault(word, 0) + 1);
                if (seen.get(word) > counts.get(word)) {
                    break;
                }
                j += wordLen;
            }
            if (j == i + totalLen) {
                result.add(i);
            }
        }
        return result;
    }
}
