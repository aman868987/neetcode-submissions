
class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0;
        int res = 0;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            // Intuition: A duplicate means the current window
            // is invalid. Shrink it from the left until the
            // duplicate is removed, rather than resetting everything.
            while (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add the character once the window becomes valid.
            set.add(ch);

            // The window now contains only unique characters.
            res = Math.max(res, right - left + 1);
        }

        return res;
    }
}
/*
Dry run: "zxyzxyz"
Character	Current window	Length	Max
z	z	1	1
x	zx	2	2
y	zxy	3	3
z	xyz	3	3
x	yzx	3	3
y	zxy	3	3
z	xyz	3	3
*/
