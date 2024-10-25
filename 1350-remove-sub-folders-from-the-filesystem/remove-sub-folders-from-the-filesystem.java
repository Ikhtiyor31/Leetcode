class Solution {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> paths = new HashSet<>();
        Arrays.sort(folder);
        for (String path: folder) {
            
            String take = "";
            boolean found = true;
            for (int i = 0; i < path.length(); i++) {
                take += path.charAt(i);
                if (paths.contains(take)) {
                    if (i < path.length() - 1 && path.charAt(i + 1) != '/')
                        continue;
                    found = false;
                    break;
                }
            }

            if (found) {
                paths.add(take);
            }
        }

        return paths.stream().toList();
    }
}