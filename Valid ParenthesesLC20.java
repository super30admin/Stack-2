class Solution {

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();                         //create a stack

        for(int i=0; i<s.length(); i++){                            //iterate through s

            char c = s.charAt(i);                                   //get each character

            if(c == '(') stack.push(')');                           //check if that character is (, push )
            else if(c == '{' ) stack.push('}');                     //check if that character is {, push }
            else if(c == '[') stack.push(']');                         //check if the character is [, then push ]
            else if(stack.isEmpty()) return false;                  //means we are getting closing bracket, check if stack is empty, then return false
            else if(stack.peek() != c) return false;                //check if the peek element is not equal to the incoming character, if not, then return false
            else stack.pop();                                   //otherwise, pop the element
        }
        return stack.isEmpty();                                 //check if stack is empty, then return true, otherwise return false
    }


   
   //Time Complexity: O(n)
    //Space Complexity: O(n)

    //  public boolean isValid(String s) {
        
    //     Stack<Character> stack = new Stack<>();
      
    //      for(char ch: s.toCharArray()){
             
    //          if(ch == '(' || ch == '{' || ch == '['){
    //              stack.push(ch);
    //          }
    //          else{
                 
    //              if(stack.isEmpty()){
    //                  return false;
    //              }
                 
    //              char c = stack.pop();
                 
    //              if(ch == ')' && c != '('){
    //                  return false;
    //              }
    //              else if(ch == '}' && c != '{'){
    //                  return false;
    //              }
    //              else if(ch == ']' && c != '['){
    //                  return false;
    //              }
    //          }  
    //      }
    //      return stack.isEmpty();
    // }
    
    
    
    
    //Time Complexity: O(n)
    //Space Complexity: O(n)

//     public boolean isValid(String s) {
        
//         Stack<Character> stack = new Stack<>();
//          char index='a';
         
//          for(int i=0; i<s.length();i++)
//          {
//              switch(s.charAt(i))
//              {
//                  case '(' :
//                          stack.push(s.charAt(i));
//                         break;
//                  case '{':
//                         stack.push(s.charAt(i));
//                      break;
//                  case '[':
//                      stack.push(s.charAt(i));
//                      break;
//                  case ')':
//                      if(stack.size()==0)
//                      {
//                          return false;
//                      }
//                      index=stack.peek();
//                      if(index=='(')
//                      {
//                          stack.pop();
//                      }
//                      else{
//                          return false;
//                      }
//                      break;
//                  case '}':
//                      if(stack.size()==0)
//                      {
//                          return false;
//                      }
//                      index=stack.peek();
//                      if(index=='{')
//                      {
//                          stack.pop();
//                      }
//                      else{
//                          return false;
//                      }
//                      break;
//                  case ']':
//                      if(stack.size()==0)
//                      {
//                          return false;
//                      }
//                      index=stack.peek();
//                      if(index=='[')
//                      {
//                          stack.pop();
//                      }
//                      else{
//                          return false;
//                      }
//                      break;    
//              }
//         }
//          if(stack.size()==0)
//          {
//              return true;
//          }
//          else{
//              return false;
//          }
//     }
}
