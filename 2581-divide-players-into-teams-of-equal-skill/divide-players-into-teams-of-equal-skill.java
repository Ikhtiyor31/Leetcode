class Solution {
    public long dividePlayers(int[] skill) {
        //Arrays.sort(skill);
        int n = skill.length;
        int totalSkill = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: skill) {
            totalSkill += num;
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        
        /*int s = 0;
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
        }*/


        if (totalSkill % (n / 2) != 0) {
            return -1;
        }


        int targetSkill = totalSkill / (n / 2);
        long totalChemistry = 0;
        for (int currSkill: map.keySet()) {
            int currFreq = map.get(currSkill);
            int partnerSkill = targetSkill - currSkill;

            if (!map.containsKey(partnerSkill) || currFreq != map.get(partnerSkill)) {
                return -1;
            }

            totalChemistry += (long)currSkill * (long)partnerSkill * (long)currFreq;
        }

        return totalChemistry / 2;
    }
}