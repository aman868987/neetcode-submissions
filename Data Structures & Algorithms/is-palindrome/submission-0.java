class Solution {
    public boolean isPalindrome(String s) {
        int low = 0;
        int high = s.length() - 1;

        while (low < high) {

            char lowChar = s.charAt(low);
            char highChar = s.charAt(high);

            // INTUITION:
            // Ignore non-alphanumeric characters because the problem
            // requires us to consider only letters and digits.
            // Move the left pointer until it reaches a valid character.
            if (!Character.isLetterOrDigit(lowChar)) {
                low++;
                continue;
            }

            // Similarly, move the right pointer past non-alphanumeric
            // characters until it reaches a valid character.
            if (!Character.isLetterOrDigit(highChar)) {
                high--;
                continue;
            }

            // INTUITION:
            // Palindromes read the same forward and backward.
            // Compare the characters from both ends, ignoring case.
            // If they differ, the string cannot be a palindrome.
            if (Character.toLowerCase(lowChar) !=
                Character.toLowerCase(highChar)) {
                return false;
            }

            // Both characters match, so move inward and compare
            // the next pair.
            low++;
            high--;
        }

        // All character pairs matched, so the string is a palindrome.
        return true;
    }
}
