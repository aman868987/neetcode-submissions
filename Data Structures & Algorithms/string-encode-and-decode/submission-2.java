class Solution {
    /*
    We'll encode each string using this format:
    length#string

    For example:
    Input:   ["Hello", "World", ""]

    Encoded: 5#Hello5#World0#

    Here:
    - 5# means the next 5 characters belong to the first string.
    - 5# means the next 5 characters belong to the second string.
    - 0# means the next string is empty.
    Why does this work? The decoder reads the length first, then consumes exactly that many characters. It doesn't matter whether the original string   contains #, digits, or other characters.
*/

    public String encode(List<String> strs) {

        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();


    }

    /*
    Find the next #.
    Read the number before #. This tells us the length of the next string.
    Extract exactly that many characters after #.
    Move forward and repeat until we reach the end.
    */

    public List<String> decode(String str) {

        List<String> res = new ArrayList<>();

        //tracks our current position in the encoded string.
        int i = 0;

        while(i < str.length()){
            // Step 1: Find the delimiter
            int deli = str.indexOf('#',i);

            // Step 2: Extract and parse the length
            int len = Integer.parseInt(str.substring(i,deli));

            // Step 3: Find where the actual string starts
            int start = deli+1;

            // Step 4: Extract exactly 'length' characters
            String word = str.substring(start,start + len);

            // Step 5: Store the decoded string
            res.add(word);

            // Step 6: Move to the next encoded string
            i = start + len;
        }
        return res;

    }
}
