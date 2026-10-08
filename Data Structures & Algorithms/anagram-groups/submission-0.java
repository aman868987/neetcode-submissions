class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        //brute force
        // List<List<String>> res = new ArrayList<>();
        // int[] track = new int[strs.length];

        // for(int i = 0; i < strs.length; i++){

        //     if(track[i]==1) continue;
        //     List<String> anagram = new ArrayList<>();
        //     anagram.add(strs[i]);

        //     for(int j = i+1; j < strs.length; j++){

        //         if(isAnagram(strs[i],strs[j])){
        //             anagram.add(strs[j]);
        //             track[j] = 1;
        //         }
                
        //     }
        //     res.add(anagram);
        // }
        // return res;

        Map<String,List<String>> map = new HashMap<>();

        for(String str : strs){
            //frequency of each char
            int[] count = new int[26];
            for(char c : str.toCharArray()){
                count[c-'a']++;
            }

            //create unique key
            StringBuilder key = new StringBuilder();
            for(int i = 0; i < 26; i++){
                key.append("#");
                key.append(count[i]);
            }
            //if key does not exist in map then add the key with new list as value
            // then add the current string in that list
            //map.computeIfAbsent(key.toString(),k -> new ArrayList<>()).add(str);
            //other way
            if(!map.containsKey(key.toString())){
                map.put(key.toString(),new ArrayList<>());
            }
            map.get(key.toString()).add(str);
        }
        return new ArrayList(map.values());
    }

    public boolean isAnagram(String s1,String s2){
        if(s1.length() != s2.length()) return false;
        int[] count = new int[26];

        for(int i = 0; i < s1.length(); i++){
            count[s1.charAt(i)-'a']++;
            count[s2.charAt(i)-'a']--;
        }
        for(int i = 0; i < 26; i++){
            if(count[i]!=0) return false;
        }
        return true;
    }
}
