//https://leetcode.com/problems/add-two-numbers/

/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} l1
 * @param {ListNode} l2
 * @return {ListNode}
 */
 var addTwoNumbers = function(l1, l2) {
    var list;
    var answer = new ListNode();
    addNumber(l1,l2,0);
    return answer;
    
    function addNumber(a,b,upper){
    
        var merge = a.val+ b.val + upper;
        if(merge >= 10){
            merge = merge - 10;
            upper = 1;
        }
        answer.next = new ListNode(merge);
        console.log(answer.next);
        if(a.next === null && b.next === null){
        }else{
            addNumber(a.next,b.next, upper);
        }
    }
};