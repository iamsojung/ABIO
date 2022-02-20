// 승환이는 팰린드롬을 좋아한다. 지금 승환이의 자동차의 주행 거리계에 100000이 적혀있다.
// 승환이는 1km만 더 주행을 하면 100001이 된다! 승환이는 엄청나게 흥분했다.
// 주행 거리계에 적혀져 있는 수가 주어졌을 때, 몇 km를 더 주행하면 팰린드롬이 되는지 구하는 프로그램을 작성하시오. 
// 승환이는 모든 자리가 팰린드롬이 되어야 한다. 따라서, 주행 거리계에 00121인 경우에는 팰린드롬이 아니다.

// 입력은 여러 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 한 줄로 이루어져 있고, 
// 현재 승환이의 주행 거리계에 적혀있는 수가 주어진다.이 숫자는 2자리와 9자리 사이(포함)이다. 
// 예를 들어, 주행 거리계에 적히는 숫자의 갯수는, 입력으로 주어진 수의 숫자의 갯수와 같다. 
// 그래서, 입력이 00456이라면, 5자리 숫자이다. 마지막 줄에는 0이 적혀있다.

// node ./JH/BAJ_4096_팰린드로미터.js

    var s = prompt();
    const result = (s) =>{
        return addValue(s)
    }

    function solution(s){
        return result;
    }

    //////////////////////////////////////////////////////////////////
    const value = "004561";

    function addValue(value){
        const valueSize = value.toString().length;
        while(isCheck(value)){
            value ++;
            value = addZero(value, valueSize - value.toString().length);
        }
        return value;
    }

    function addZero(value,size){
        for(var i=0; i<size; i++){
            value = "0"+ value;
        }
        return value;
    }

    function isCheck(value){
        if(value == value.toString().split('').reverse().join('')){
            return false;
        }
        return true;
    }

    // 규칙성 case...
    // function setValue(value){
    //     const valueSize = value.toString().length;
    //     const halfSize = valueSize/2;

    //     if((valueSize%2) == 0 ){
    //         //자리수 짝수
    //         const reSetValue = value.toString().substr(0,halfSize);
    //         return reSetValue + reSetValue.split('').reverse().join('');
    //     }else{
    //         //자리수 홀수 
    //         const middleIndex = Math.ceil(halfSize);
    //         const reSetValue = value.toString().substr(0,middleIndex);
    //         return reSetValue + reSetValue.split('').reverse().join('').substr(1,middleIndex);
    //     }
    // }

    console.log(isCheck(value));
    //console.log(setValue(value));
    console.log(addValue(value));
    console.log(addValue(value) - value);


    //case : 짝수인 길이의 숫자는 중심 숫자 비교해서 팰린드롬 처리
    //case : typeof(value) = number > 자리수만큼 0 처리 