import java.util.HashMap;
import java.util.Stack;

//TC: O(n) traverse throught the entire string
//SC: O(n) auxillary space
// code works on leetcode

public class ValidParantheses {

  public boolean isValid(String s) {
    // Check if the string length is odd
    if (s.length() % 2 != 0) return false;

    // Mapping of opening to closing brackets
    HashMap<Character, Character> bracketMap = new HashMap<>();
    bracketMap.put('(', ')');
    bracketMap.put('[', ']');
    bracketMap.put('{', '}');

    //Declare stack
    Stack<Character> st = new Stack<>();

    for (char c : s.toCharArray()) {
      if (bracketMap.containsKey(c)) {
        st.push(c);
      } else {
        //be careful of this condition check here
        if (st.isEmpty() || bracketMap.get(st.pop()) != c) {
          return false; // Mismatch found
        }
      }
    }

    // The stack should be empty if all brackets are matched
    return st.isEmpty();
  }
}
