/**
 * @param {string} s
 * @return {boolean}
 */
var isValid = function(s) {
    let st = [];
    for(let i = 0; i< s.length; i++){
        if(s[i] == '('){
            st.push(')');
        } else if(s[i] == '{'){
            st.push('}');
        } else if(s[i] == '['){
            st.push(']');
        } else {
            if(st.length == 0 || s[i] != st.pop()) return false;
        }
    }
    return (st.length == 0);
    
};

//time complexity : O(n)
//space : O(n)