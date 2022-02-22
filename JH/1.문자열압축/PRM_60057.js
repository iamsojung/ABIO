// node ./JH/1.문자열압축/PRM_60057.js

const s = "ababcdcdababcdcd";

function solution(s) {
    var answer = 0;
    var len = s.length;
    //문자열 가공
    for(var i=1; i<len+1; i++){
        var str="";
        var cnt=1;
        var result ="";
        for(var j=0; j<=Math.ceil(len/i); j++){
            if(j == 0){
            }else if(str === s.substr(i*j,i)){
                cnt++;
            }else{
                if(cnt==1) cnt = "";
                result += cnt + str;
                cnt = 1;
            }
            str = s.substr(i*j,i);
        }
        console.log("##: "+result);
        if(answer == 0 || answer > result.length){
            answer = result.length;
        }
    }
    return answer;
}
console.log("@@: "+solution1(s));