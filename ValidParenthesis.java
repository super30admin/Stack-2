//Time complexity is O(N)
//Space complexity is O(N)
class Solution {

  // Hash table that takes care of the mappings.
  private HashMap<Character, Character> mappings;

  public Solution() {
    this.mappings = new HashMap<Character, Character>();
    this.mappings.put(')', '(');
    this.mappings.put('}', '{');
    this.mappings.put(']', '[');
  }

  public boolean isValid(String s) {

    Stack<Character> stack = new Stack<Character>();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
        
      if (this.mappings.containsKey(c)) {

        char topElement = stack.empty() ? '#' : stack.pop();

        if (topElement != this.mappings.get(c)) {
          return false;
        }
      } else {
        stack.push(c);
      }
    }

    // If the stack still contains elements, then it is an invalid expression.
    return stack.isEmpty();
  }
}