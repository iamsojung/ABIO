function solution(name) {
    var alphabet = ["A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"];
    var answer = 0;
    var arr = name.split("");
    var arrNum = [];
    for (var i=0; i< arr.length; i++){
        arrNum.push(alphabet.indexOf(arr[i]));
        var gap =0;
        if(i===0){
            gapFn(0,arrNum[i]);
        }else{
            gapFn(arrNum[i-1],arrNum[i]);
        }
        console.log(answer);
    }
    
    function gapFn(a,b){
        if(b === 0 || b === 26){
            answer += 1;
        }else{
            if(a - b < 0){
                if( a - b < -13){
                    answer += 26 - b;
                }else{
                    answer += Math.abs(a-b);
                }
            }else{
                if( a - b > 13){
                    answer += 0 - a ;
                }else{
                    answer += Math.abs(a-b);
                }
            }
        }
        
    }
    console.log(arrNum);
    return answer;
}


//  0 > a  / a > 26  케이스 추가 필요 