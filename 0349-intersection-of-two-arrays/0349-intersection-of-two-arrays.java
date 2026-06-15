class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
         Set<Integer> s1 = new HashSet<>();
        Set<Integer> res = new HashSet<>();

        for (int n : nums1) s1.add(n);
        for (int n : nums2)
            if (s1.contains(n)) res.add(n);

        return res.stream().mapToInt(i -> i).toArray();

    }
}