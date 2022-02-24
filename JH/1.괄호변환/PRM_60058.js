// https://programmers.co.kr/learn/courses/30/lessons/60058

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