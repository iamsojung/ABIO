//https://leetcode.com/problems/reorder-data-in-log-files/submissions/

/**
 * @param {string[]} logs
 * @return {string[]}
 */
 var reorderLogFiles = function(logs) {
    var str =[];
    var num = [];
    for(var i=0; i<logs.length; i++){
        //java isDigit()
        //js isNaN()
        if(!isNaN(logs[i].split(" ")[1][0]) && !isNaN(logs[i].split(" ")[1])[1] ){
            num.push(logs[i]);
        }else{
            str.push(logs[i]);
        }
    }

    console.log(str);
    console.log(num);
    
    function sortFn(a){
        var size = a.split(" ").length;
        var add ="";
        for(var i=1; i<size; i++){
            add += a.split(" ")[i];
        }
        return add;
    }
    return str.sort((a,b) => sortFn(a) < sortFn(b) ? -1 : sortFn(a) > sortFn(b) ? 1 : 0).concat(num.sort());
};