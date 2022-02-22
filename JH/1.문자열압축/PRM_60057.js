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

//다른사람 풀이보기 
//https://programmers.co.kr/learn/courses/30/lessons/60057/solution_groups?language=javascript

const solution = s => {
  const range = [...Array(s.length)].map((_, i) => i + 1);
  return Math.min(...range.map(i => compress(s, i).length));
};

const compress = (s, n) => {
  const make = ([a, l, c]) => `${a}${c > 1 ? c : ''}${l}`;
  return make(
    chunk(s, n).reduce(
      ([a, l, c], e) => e === l ? [a, l, c + 1] : [make([a, l, c]), e, 1],
      ['', '', 0]
    )
  );
};

const chunk = (s, n) =>
  s.length <= n ? [s] : [s.slice(0, n), ...chunk(s.slice(n), n)];