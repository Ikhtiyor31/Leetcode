class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        int bullCount = 0;
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bullCount++;
            } else {
                map.put(secret.charAt(i), map.getOrDefault(secret.charAt(i), 0) + 1);
            }
        }

        int cowCount = 0;

        for (int i = 0; i < guess.length(); i++) {
            if (secret.charAt(i) != guess.charAt(i)) {
                if (map.containsKey(guess.charAt(i)) && map.get(guess.charAt(i)) > 0) {
                    cowCount++;
                    map.put(guess.charAt(i), map.get(guess.charAt(i)) - 1);
                }
            }
        }

        return bullCount + "A" + cowCount + "B";
    }
}