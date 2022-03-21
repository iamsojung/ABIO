function solution(name) {
    // 조이스틱 조작횟수 계산
    let joyCount = [];
    for (let i=0; i<name.length; i++) {
        let charCode = name.charCodeAt(i);
        if (charCode < 79) joyCount.push(charCode-65);
        else joyCount.push(91-charCode);
    }
    
    // 상하 조작횟수 구하기
    let vertical = 0;
    for (let i=0; i<joyCount.length; i++) vertical += joyCount[i];
    
    if (vertical === 0) return 0;
    
    // 가로 조작횟수 구하기
    let horizon = joyCount.length-1;
    
    // 오른쪽으로 쭉 갔을 때
    if (joyCount[joyCount.length-1] === 0) {
        let right = joyCount.length-1;
        for (let i=joyCount.length-1; i>0; i--) {
            if (joyCount[i] === 0) right--;
            else break;
        }
        if (horizon > right) horizon = right;
    }
    
    // 왼쪽으로 쭉 갔을 때
    if (joyCount[1] === 0) {
        let left = joyCount.length-1;
        for (let i=1; i<joyCount.length; i++) {
            if (joyCount[i] === 0) left--;
            else break;
        }
        if (horizon > left) horizon = left;
    }
    
    // 중간에 다시 돌아올 때
    //   가장 긴 A가 시작하는 부분과 가장 긴 A의 길이 구하기
    let aStart = -1;
    let aMax = 0, aSize = 0;
    for (let i=0; i<joyCount.length; i++) {
        if (joyCount[i] === 0) aSize++;
        else aSize = 0;
        
        if (aSize > aMax) {
            aMax = aSize;
            aStart = (i-aSize)+1;
        }
    }
    
    if (aStart > 1) {
        let short = Math.min(aStart-1, joyCount.length-(aStart+aMax));
        let long = Math.max(aStart-1, joyCount.length-(aStart+aMax));
        horizon = Math.min(horizon, short*2+long);
    }
    
    return vertical + horizon;
}

console.log(solution("BBAAABAAAAAAAAAAAABA"));


// function solution(name) {
//     let length = name.length;
//     let alphabetName = "A".repeat(length);

//     let moves = [];
//     let changes = [];
//     let answer = 0;

//     for (let i = 0; i < length; i++) {
//         if (name[i] == "A") {
//             moves.push(0);
//             changes.push(true);
//         } else {
//             let over = name[i].charCodeAt() - alphabetName[i].charCodeAt();
//             let under = alphabetName[i].charCodeAt() - name[i].charCodeAt() + 26;

//             moves.push(over < under ? over : under);
//             changes.push(false);
//         }
//     }

//     let index = 0;

//     while (true) {
//         changes[index] = true;

//         if (changes.indexOf(false) == -1) { break; }

//         let indexOf = Math.abs(changes.indexOf(false) - index);
//         let lastIndexOf = length - Math.abs(changes.lastIndexOf(false) - index);

//         if (indexOf <= lastIndexOf) {
//             index = changes.indexOf(false);
//             answer += indexOf;
//         } else {
//             index = changes.lastIndexOf(false)
//             answer += lastIndexOf;
//         }
//     }

//     answer += moves.reduce(function (a, b) { return a + b; }, 0)

//     return answer;
// }