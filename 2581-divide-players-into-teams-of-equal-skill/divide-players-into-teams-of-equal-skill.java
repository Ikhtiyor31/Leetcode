class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        int n = skill.length;
        //Map<Integer, Integer> map = new HashMap<>();
        //for (int num: skill) {
        //    map.put(num, map.getOrDefault(num, 0) + 1);
        //}

        long totalSkill = 0;
        int s = 0;
        int e = n - 1;
        int equalSize = skill[s] + skill[e];
        while (s < e) {
            if (equalSize != skill[s] + skill[e]) {
                totalSkill = -1;
                break;
            }
            totalSkill += (skill[s] * skill[e]);
            s++;
            e--;
        }
        return totalSkill;
    }
}