import java.util.*;

/**
 * Created by apple on 17/2/6.
 * Given an array of strings, group anagrams together.

 For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 Return:

 [
 ["ate", "eat","tea"],
 ["nat","tan"],
 ["bat"]
 ]
 Note: All inputs will be in lower-case.
 */
public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String newString = String.valueOf(c);
            if (!map.containsKey(newString)) map.put(newString, new ArrayList<>());
            map.get(newString).add(s);
        }

        return new ArrayList<List<String>>(map.values());
    }

    public List<String> groupAnagrams_B(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String newString = String.valueOf(c);
            if (!map.containsKey(newString)) map.put(newString, new ArrayList<>());
            map.get(newString).add(s);
        }

        List<String> list = new ArrayList<>();
        for (Map.Entry<String, List<String>> m :map.entrySet()) {
            if (m.getValue().size() > 1)
                list.addAll(m.getValue());
        }
        return list;

    }
    public static void main(String[] args) {
        GroupAnagrams mySolution = new GroupAnagrams();
        String[] str = {"lint", "intl", "inlt", "code", "cdoe"};

        List<List<String>> answer = mySolution.groupAnagrams(str);
        System.out.println(answer);

        List<String> result = mySolution.groupAnagrams_B(str);
        System.out.println(result);
    }

}
