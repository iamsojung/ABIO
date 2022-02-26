//https://programmers.co.kr/learn/courses/30/lessons/43165

function solution(numbers, target) {
    var len = numbers.length;
    var answer = 0;
    
    for(var k=0; k<Math.pow(2,len); k++){
        var result = 0;
        for(var j=0; j<len; j++){
            if(trsTwo(k)[j] === "+"){
              result += numbers[j];
            }else if(trsTwo(k)[j] === "-"){
              result -= numbers[j];
            }
        }
        if(result === target){
            answer++;
        }
    }
        
    return answer;
    
    // 경우의 수  > 이진법 구하고 +/- 로 변환 
    function trsTwo(i){
        var arr = [];
        while(true){
            arr.push(i%2);
            i = parseInt(i/2);
            if(i === 0){
                break;
            }
        }
        //자릿수 맞추기
        while(arr.length !== len){
            arr.push(0);
        }
        return arr.reverse().join('').replace(/0/gi,"+").replace(/1/gi,"-").split('');
    }
}