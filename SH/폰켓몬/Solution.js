function solution(nums) {
    let pokemons = [];

    for (let i = 0; i < nums.length; i++) {
        if (pokemons.length == nums.length / 2) { break; }
        if (pokemons.indexOf(nums[i]) == -1) { pokemons.push(nums[i]); }
    }

    return pokemons.length;
}

solution([3, 1, 2, 3]);