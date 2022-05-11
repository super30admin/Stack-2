/*
    approach: stack
    - loop over s
    - if char is a open paranthesis
        - push its corresponding closing paranthesis to stack
    - if char is a close paranthesis
        - pop the top and compare for equality
        - if same , great
        - if not, return false
    - however there could be cases where a paranthesis never closes, i.e our stack still have closing paranthesis 
        - then in this case if our stack still have paranthesis that did not cancel out, then return false
        - this means we have inbalanced paranthesis
    
    time: o(n)
    space: o(n)
*/

func isValid(s string) bool {
    stack := []byte{}
    for i := 0; i < len(s); i++ {
        char := s[i]
        if char == '(' {
            stack = append(stack, ')')
        } else if char == '[' {
            stack = append(stack, ']')
        } else if char == '{' {
            stack = append(stack, '}')
        } else {
            if len(stack) == 0 {
                return false
            }
            top := stack[len(stack)-1]
            stack = stack[:len(stack)-1]
            if top != char {
                return false
            }
        }
    }
    if len(stack) != 0 {
        return false
    } 
    return true
}
