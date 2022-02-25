// https://programmers.co.kr/learn/courses/30/lessons/60058
//        1. 입력이 빈 문자열인 경우, 빈 문자열을 반환합니다.
//        2. 문자열 w를 두 "균형잡힌 괄호 문자열" u, v로 분리합니다. 단, u는 "균형잡힌 괄호 문자열"로 더 이상 분리할 수 없어야 하며, v는 빈 문자열이 될 수 있습니다.
//        3. 문자열 u가 "올바른 괄호 문자열" 이라면 문자열 v에 대해 1단계부터 다시 수행합니다.
//        3-1. 수행한 결과 문자열을 u에 이어 붙인 후 반환합니다.
//        4. 문자열 u가 "올바른 괄호 문자열"이 아니라면 아래 과정을 수행합니다.
//        4-1. 빈 문자열에 첫 번째 문자로 '('를 붙입니다.
//        4-2. 문자열 v에 대해 1단계부터 재귀적으로 수행한 결과 문자열을 이어 붙입니다.
//        4-3. ')'를 다시 붙입니다.
//        4-4. u의 첫 번째와 마지막 문자를 제거하고, 나머지 문자열의 괄호 방향을 뒤집어서 뒤에 붙입니다.
//        4-5. 생성된 문자열을 반환합니다.

// p	result
// "(()())()"   > 	"(()())()"
// ")("         > 	"()"
// "()))((()"   >   "()(())()"

// node ./JH/1.괄호변환/PRM_60058.js
console.log("@@@");
console.log(solution("((()()))(("));
function solution(p) {
    if(isCheck(p)){
        return p;
    }else{
        const arridx = getIdx(p);
        //console.log(arridx);
        const arrp = p.split('');
        const rep = getSort(p);
        const answer="";
        if(p.length > 2){
        var cnt = 0;
           for(var k=0; k<p.length; k++){
            if(arridx.indexOf(k) === -1){
                //console.log(k);
                //console.log(rep[cnt]);
                arrp[k] = rep[cnt];
                cnt++;
                }
            } 
        }else{
            return rep; 
        }
        return arrp.join('');
    }
    
    
    //console.log(getIdx(p));
    function getIdx(p){
        const arr = p.split('');
        const reArr = [];
        for(var i=0; i<p.length+1; i++){
            if(arr[i] === '(' && arr[i+1] === ')'){
                reArr.push(i);
                reArr.push(i+1);
            }
        }
        return reArr;
    }
    function getSort(p){
        //const trs = p.replace(/\(/gi,"0").replace(/\)/gi,"1");
        const str = p.split("()").join('').split('').sort().join('');
        console.log(str);
        return str;

    }
        function isCheck(str){
            var trs = str;
            for(var i=0; i<str.length/2; i++){
                trs = trs.split("()").join('');
            }
            if(trs === ''){
                return true;
            }else{ 
                return false;
            }
  
    }
}