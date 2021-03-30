// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO


// Your code here along with comments explaining your approach
class Solution {
    
    Map<Character, Character> map;
    
    public Solution() {
        map = new HashMap();
        map.put('[',']');
        map.put('(',')');
        map.put('{','}');
    }
    
    public boolean isValid(String s) {
        
        Stack<Character> stack = new Stack();
        
        for(int i=0;i<s.length();i++) {
            
            if(map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));    
            } else {
                
                if(stack.isEmpty() || map.get(stack.pop()) != s.charAt(i)) return false;
                
            }
            
        }
        
        return stack.isEmpty()?true:false;
    }
}
