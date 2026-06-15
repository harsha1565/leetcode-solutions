class Solution {
    public boolean hasMatch(String s, String p) {
        int star = p.indexOf('*');

        String prefix = p.substring(0, star);
        String suffix = p.substring(star + 1);

        int pos = s.indexOf(prefix);

        return pos != -1 &&
               s.indexOf(suffix, pos + prefix.length()) != -1;
    }
} 


