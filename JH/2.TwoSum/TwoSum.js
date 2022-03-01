//https://leetcode.com/problems/two-sum/

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
 var twoSum = function(nums, target) {
    var arr = [];
     for(var i=0; i<nums.length; i++){
         for(var j=i+1; j<nums.length; j++){
             if(target === (nums[i]+nums[j])){
                 arr.push(i);
                 arr.push(j);
             }
         }
     }
    return arr;
};