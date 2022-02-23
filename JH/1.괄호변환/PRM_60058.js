// https://programmers.co.kr/learn/courses/30/lessons/60058

// p	result
// "(()())()"   > 	"(()())()"
// ")("         > 	"()"
// "()))((()"   >   "()(())()"


function solution(p) {
    
    var answer = '';
    var flag = false;
    var trs = p.replace(/\(/gi,"0").replace(/\)/gi,"1");
    isCheck(trs);
    if(flag){
        return p;
    }else{
        trs = trs.split('').sort().join('');
        isCheck(trs);
    }
    console.log(answer);
    return answer;
    
    function isCheck(str){
            for(var i=0; i<p.length/2; i++){
        trs = trs.split("01").join('');
        if(trs == ''){
            flag = true;
        }
    }
    }
}