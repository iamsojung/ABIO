//https://programmers.co.kr/learn/courses/30/lessons/1845

function solution(nums) {
    var answer = 0;
    var length = nums.length;
    
    var arr = [];
    for (var i=0; i<length; i++){
        if(arr.indexOf(nums[i]) < 0){
           arr.push(nums[i]);
        }
    }
    if(arr.length <= length/2 ){
        answer = arr.length;
    }else{
        answer = length/2;
    }
    return answer;
}