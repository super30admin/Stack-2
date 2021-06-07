//Time Complexity:O(n)
//Space Complexity:O(n)
class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('}','{');
        map.put(')','(');
        map.put(']','[');
        Stack<Character> stack = new Stack<>();
        for(int i =0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                if( stack.isEmpty()) return false;
                else if(map.get(c)!=stack.pop()) return false;
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}