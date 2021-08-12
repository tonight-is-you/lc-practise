import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 电话号码的字母组合
public class Hot17 {
    // public List<String> letterCombinations(String digits) {
    //     List<String> combinations = new ArrayList<>();
    //     if (digits.length() == 0 || digits == null)
    //         return combinations;

    //     Map<Character, String> map = new HashMap<>(){{
    //         put('2', "abc");
    //         put('3', "def");
    //         put('4', "ghi");
    //         put('5', "jkl");
    //         put('6', "mno");
    //         put('7', "pqrs");
    //         put('8', "tuv");
    //         put('9', "wxyz");
    //     }};

    //     backtrack(combinations, map, digits, 0, new StringBuffer());
    //     return  combinations;
    // }

    // private void backtrack(List<String> combinations, Map<Character, String> map, String digits,
    //     int index, StringBuffer combination){
    //         if (index == digits.length())
    //             combinations.add(combination.toString());
    //         else {
    //             char digit = digits.charAt(index);
    //             String s = map.get(digit);
    //             for (int i = 0; i < s.length(); i ++){
    //                 combination.append(s.charAt(i));
    //                 backtrack(combinations, map, digits, index + 1, combination);
    //                 combination.deleteCharAt(index);
    //             }
    //         }
    //     }

    // 队列解法
    public List<String> letterCombinations(String digits) {
        List<String> lc = new ArrayList<String>();
        if (digits == null || digits.length() == 0)
            return lc;

        Map<Character, String[]> map = new HashMap<Character, String[]>(){{
            put('2', new String[] {"a", "b", "c"});
            put('3', new String[] {"d", "e", "f"});
            put('4', new String[] {"g", "h", "i"});
            put('5', new String[] {"j", "k", "l"});
            put('6', new String[] {"m", "n", "o"});
            put('7', new String[] {"p", "q", "r", "s"});
            put('8', new String[] {"t", "u", "v"});
            put('9', new String[] {"w", "x", "y", "z"});
        }};

        lc.add("");
        for (int i = 0; i < digits.length(); i ++){
            int queryLength = lc.size();
            String[] letters = map.get(digits.charAt(i));
            for (int j = 0; j < queryLength; j ++){
                String s = lc.remove(0);
                for (String letter: letters)
                    lc.add(s + letter);
            }
        }
        return lc;
    }
}
