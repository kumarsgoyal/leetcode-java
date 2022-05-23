class Solution {
    public int[] intersectionUtil(HashSet<Integer> st1, HashSet<Integer> st2) {
        st1.retainAll(st2);
        
        int[] result = new int[st1.size()];
        int ind = 0;
        for(Integer i : st1) 
            result[ind++] = i;
        return result;
    }
    
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> st1 = new HashSet<Integer>();
        for(int n : nums1) st1.add(n);
        HashSet<Integer> st2 = new HashSet<Integer>();
        for(int n : nums2) st2.add(n);
        
        if(st1.size() < st2.size())
            return intersectionUtil(st1, st2);
        else 
            return intersectionUtil(st2, st1);
    }
}
