function solution(numbers) {
    var answer = '';
    numbers.sort((a,b)=> maxNum(a) - maxNum(b));
    for(var i=0; i<numbers.length; i++){
        answer += numbers[numbers.length-1-i];
    }
    function maxNum(val){
        var maxnum =0;
        for(var i=0; i<val.toString().length; i++){
            if(i=== 0 || maxnum > val.toString().substr(i,1)){
                maxnum = val.toString().substr(i,1);
            }
            return maxnum;
        }
    }
        return answer;
}

///순열 구하기 
const getPermutations = function (arr, selectNumber) {
    const results = [];
    if (selectNumber === 1) return arr.map((value) => [value]); // 1개씩 택할 때, 바로 모든 배열의 원소 return
  
    arr.forEach((fixed, index, origin) => {
      const rest = [...origin.slice(0, index), ...origin.slice(index + 1)]; // 해당하는 fixed를 제외한 나머지 배열
      const permutations = getPermutations(rest, selectNumber - 1); // 나머지에 대해 순열을 구한다.
      const attached = permutations.map((permutation) => [fixed, ...permutation]); // 돌아온 순열에 대해 떼 놓은(fixed) 값 붙이기
      results.push(...attached); // 배열 spread syntax 로 모두다 push
    });
  
    return results; // 결과 담긴 results return
  };
  
  const arr = [1, 2, 3, 4];
  const result = getPermutations(arr, 3);
  console.log(result);


  //// 실수형으로 만들고 정렬 순서: 크기 > 자릿수 기준으로 정렬 

  function solution(numbers) {
    var arr =[];
    var answer = '';
    for(var i=0; i<numbers.length; i++){
        if(numbers[i].toString().length > 1){
           numbers[i] = parseFloat(numbers[i]/(Math.pow(10,numbers[i].toString().length-1))).toFixed(numbers[i].toString().length-1);
        }
        arr.push(numbers[i]);
    }
    arr.sort();
    answer = arr.sort(function(a,b){
    if(a < b) return 1;
    if(a == b){
        if(a.toString().length > b.toString().length){
            return -1;
        }else{
            return 0;
        }
    }
    }).reverse().join().replace(/,/gi,"").replace(/\./gi,"");
    return answer;
}