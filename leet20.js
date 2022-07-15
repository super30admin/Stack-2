TC -O(N)
SC - O(1)

/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
  var st=[];
    
    for(let i in s)
    {
       if(s[i]==='(')
        {
            st.push(')');
        }
        else if(s[i]==='[')
        {
            st.push(']');
        }
        else if(s[i]==='{')
        {
            st.push('}');
        }
        else if(st.pop()!==s[i])
        {
            return false;
        }
    }
   
    return st.length===0;
};