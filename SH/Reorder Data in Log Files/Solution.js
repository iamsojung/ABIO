/**
 * @param {string[]} logs
 * @return {string[]}
 */
 var reorderLogFiles = function(logs) {
    let digitLogs = [], wordLogs = [];
    for (let log of logs) {
        // 문자열을 잘라서 key, value로 나누고 value가 없는 경우 데이터를 바로 담는다.
        let arr = log.split(" ");
        if (isNaN(arr[1])) wordLogs.push({id: arr.slice(0,1), body: arr.slice(1).join(" ")});
        else digitLogs.push(log);
    }
    wordLogs.sort((log1,log2) => {
        // value 값으로 정렬을 하고 같다면 key값으로 정렬을 한다.
        // a b 0보다 작은 경우 a를 b보다 낮은 색인으로 정렬
        // a b 0보다 큰 경우 b를 a보다 낮은 인덱스로 소트
        // 0인 경우 변경하지않고 그대로 진행
        if (log1.body < log2.body) return -1;
        if (log1.body > log2.body) return 1;
        if (log1.id < log2.id) return -1;
        if (log1.id > log2.id) return 1;
    })
    let sortedWordLogs = wordLogs.map(log => `${log.id} ${log.body}`);
    return sortedWordLogs.concat(digitLogs);
};

let arr = reorderLogFiles(["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]);