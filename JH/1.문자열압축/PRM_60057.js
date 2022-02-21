const s = "ababcdcdababcdcd";

function solution(s) {
    var answer = 0;
    for(var i=1; i<s.length+1; i++){
        var result = "";
        var str ="";
        for(var j=0; j<Math.ceil(s.length/i); j++){
            if(str === s.substr(j*i,i)){
                
            }
            console.log(s.substr(j*i,i));
            str = s.substr(j*i,i);
        }
    }
    return answer;
}

//문자열 자르기 > 문자열 압축 > 압축 사이즈 비교 