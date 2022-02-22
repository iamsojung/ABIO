// node ./JH/1.문자열압축/PRM_60057.js

const s = "aabbaccc";

function solution(s) {
    var answer = 0;
    for(var i=1; i<s.length+1; i++){
        var result = "";
        var str ="";
        var cntMap = new Map();
        for(var j=0; j<=Math.ceil(s.length/i); j++){
            if(str === s.substr(j*i,i)){
                cntMap.set(str,cntMap.get(str)+1);
            }else{
                cntMap.set(s.substr(j*i,i),1);
                if(j>0){
                    result += cntMap.get(str) + str;
                }
            }
            str = s.substr(j*i,i);
        }
        result = result.replace(/1/gi, "");
        if(answer == 0 || answer > result.length){
            answer = result.length;
        }
    }
    return answer;
}

console.log("@@: "+solution(s));
//문자열 자르기 > 문자열 압축 > 압축 사이즈 비교 