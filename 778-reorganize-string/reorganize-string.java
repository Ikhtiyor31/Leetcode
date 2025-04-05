class Solution {
    public static class Pair<K, V> {
        K first;
        V second;
        Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }

        public String toString() {
            return "first " + this.first + ", second " + this.second;
        }
    }
    public String reorganizeString(String s) {
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        PriorityQueue<Pair<Integer, Character>> pq = new PriorityQueue<>((a, b) -> b.first - a.first);
        for (Map.Entry<Character, Integer> entries: map.entrySet()) {
            pq.add(new Pair(entries.getValue(), entries.getKey()));
        }
        char previous = ' ';
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair<Integer, Character> pair = pq.poll();
            boolean isNextUsed = false;
            if (previous == ' ') {
                sb.append(pair.second);
                previous = pair.second;
            } else if (previous == pair.second) {
                if (pq.isEmpty()) return "";
                Pair<Integer, Character> next = pq.poll();
                sb.append(next.second);
                previous = next.second;
                if (next.first > 1) {
                    pq.add(new Pair<>(next.first - 1, next.second));
                }
                isNextUsed = true;
            } else {
                System.out.println(pair);
                sb.append(pair.second);
                previous = pair.second;
            }

            if (pair.first > 1) {
                pq.add(new Pair<>(isNextUsed ? pair.first  : pair.first - 1, pair.second));
            }
        }

        return sb.toString();
    }
}