// Time Complexity : O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    //method 1
//     public boolean isValid(String s) {
//         Stack<Character> stack = new Stack<>();
// 		for(int i=0;i<s.length();i++){
// 			char c = s.charAt(i);

// 			if((c=='(') || (c=='[') || (c=='{')  ){
// 				stack.push(c);
// 			}
//             if(stack.isEmpty()){
//                     return false;
//             }
			
// 			else{
// 				switch(c){
// 					case ')':
// 					if(stack.pop()!='(' ){
// 						return false;
// 					}
// 					break;

// 					case ']':
// 					if(stack.pop()!='['){
// 						return false;
// 					}
// 					break;
                        
// 					case '}':
// 					if(stack.pop()!='{'){
// 						return false;
// 					}
// 					break;
// 				}
				
// 			}

// 		}
// 		return stack.isEmpty();
//  }
    //method 2
    //TC:O(n) SC:O(n)
       public boolean isValid(String s) {
           
           if(s == null || s.length() == 0)return true;
           Stack<Character> st = new Stack<>();
           for( int i = 0; i<s.length();i++){
               Character c = s.charAt(i);
               if(c == '(') st.push(')');
               else if(c == '[') st.push(']');
               else if(c == '{') st.push('}');
               else if(st.isEmpty() || st.pop()!=c) return false;
              
           }
           if(!st.isEmpty()) return false;
           return true;
       }
}