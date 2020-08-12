/**
 * @param {number} n
 * @param {string[]} logs
 * @return {number[]}
 */
var exclusiveTime = function(n, logs) {
    //base
    if(logs == null || logs.length == 0) return [];
    let prev = 0;
    let result = new Array(n).fill(0);
    let st = [];
    for(let i = 0; i< logs.length; i++){
        let splitStr = logs[i].split(':');
        let curr = parseInt(splitStr[2]);
        
        //start
        if(splitStr[1] == 'start'){
            //calculate the time lapsed so far for the current task(splitStr[0]), if in stack
            if(st.length != 0){
              let j = st[st.length -1];
               result[j] +=  curr - prev;
            }
            //push the current task into stack
            st.push(splitStr[0]);
            prev = curr; (prev = 2)
            
        } else {
            let j = st.pop();
            result[j] +=  curr - prev + 1;
            prev = curr + 1; (prev = 5 - 2 +1 )
        }
    }
    
    return result;
};
//time coplexity : O(n)