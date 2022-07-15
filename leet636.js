TC - O(N)
SC - O(N)

/**
 * @param {number} n
 * @param {string[]} logs
 * @return {number[]}
 */
var exclusiveTime = function(n, logs) {
    let result = new Array(n).fill(0)
    let stack = []
    
    
    for (const log of logs.values()) {
        let [funcId, type, time] = log.split(':')
        funcId = Number(funcId)
        time = Number(time)
        
        if (type === 'start') {
            const pushMe = { type, val: time }
            stack.push(pushMe)
        } else {
            let subtractMe = 0
            
            while (true) {
                const poppedMe = stack.pop()
                if (poppedMe.type === 'time') {
                    subtractMe += poppedMe.val
                } else {
                    let outcome = 1 + time - poppedMe.val
                    const pushMe = { type: 'time', val: outcome }
                    
                    outcome -= subtractMe
                    result[funcId] += outcome
                    stack.push(pushMe)
                    break
                }
            }
        }
    }
    
    
    return result
};