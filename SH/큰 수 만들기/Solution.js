function solution(number, k) {
    let answer = [];

    if(k == 0) { return number; }

    for(let i = 0; i < number.length; i++) {
        while(k > 0 && answer[answer.length - 1] < number[i]) {
             answer.pop();
             k--;
         }

         answer.push(number[i]);
    }

    return answer.splice(0, answer.length - k).join("");
}

console.log(solution("987654321", 5));



