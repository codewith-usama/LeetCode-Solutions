class Solution {
    private static final String[] LETTERS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }
        generateCombinations(digits, 0, new StringBuilder(), combinations);
        return combinations;
    }

    private void generateCombinations(String digits, int index, StringBuilder sb, List<String> combinations) {
        if (index == digits.length()) {
            combinations.add(sb.toString());
            return;
        }
        String letters = LETTERS[digits.charAt(index) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            sb.append(letters.charAt(i));
            generateCombinations(digits, index + 1, sb, combinations);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
