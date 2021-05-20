// TC - O(n)
// SC - O(1)

// LC - 20

class Solution {
    public boolean isValid(String s) {
		
		// We put the closing brace and opening brace in the map
		
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Stack<Character> stack = new Stack<>();
		// We iterate over the string s and if s is a key in map, we need to pop character from stack if stack is not empty and check if poppedVal is equal to map current character value
        for(char ch : s.toCharArray()){
            if(map.containsKey(ch)){
                if(stack.isEmpty()){
                    return false;
                }
                Character poppedVal = stack.pop();
                if(map.get(ch) != poppedVal){
                    return false;
                }
            }else{
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}