class Solution {
    public int numSimilarGroups(String[] A) {
        Map<String, String> child2root = new HashMap<>();
        for (int i=0; i<A.length; i++) {
            List<String> rootList = new ArrayList<>();
            rootList.add(A[i]);
            for (int j=0; j<i; j++) {
                if (similar(A[i], A[j])) {
                    rootList.add(getRoot(child2root, A[j]));
                }
            }
            for (int j=0; j<rootList.size(); j++) {
                child2root.put(rootList.get(j), rootList.get(0));
            }
        }
        Set<String> result = new HashSet<String>();
        for (String key : child2root.keySet()) {
            result.add(getRoot(child2root, key));
        }
        return result.size();
    }
    
    private boolean similar(String a, String b) {
        int diffCount = 0;
        for (int i=0; i<a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount <= 2;
    }
    private String getRoot(Map<String, String> child2root, String child) {
        String root = child;
        if (child2root.containsKey(child) && child2root.get(child) != child) {
            root = getRoot(child2root, child2root.get(child));
        }
        child2root.put(child, root);
        return root;
    }
}