class Solution {
    private Map<Character, String> buttons = new HashMap<>();

    public void backtrack(String digits, List<String> answer, String temp, int i) {
        
        if (!temp.isEmpty() && temp.length() == digits.length()) {
            answer.add(temp);
        }

        if (digits.length() <= i) {
            return;
        }

 
        char digit = digits.charAt(i);
        String letter = buttons.get(digit);
        for (char c: letter.toCharArray()) {
            temp += c;
            backtrack(digits, answer, temp, i+1);
            temp = temp.substring(0, temp.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        buttons.put('2', "abc");
        buttons.put('3', "def");
        buttons.put('4', "ghi");
        buttons.put('5', "jkl");
        buttons.put('6', "mno");
        buttons.put('7', "pqrs");
        buttons.put('8', "tuv");
        buttons.put('9', "wxyz");
        List<String> answer = new ArrayList<>();
        backtrack(digits, answer, "", 0);
        return answer;
    }
}