function solution(places) {
    var answer = [];

    for (let i = 0; i < places.length; i++) {
        var bool = true;

        for (let j = 0; j < places[i].length; j++) {
            for (let k = 0; k < places[i][j].length; k++) {
                let seat = places[i][j][k];
                let up = j == 0 ? "X" : places[i][j - 1][k];
                let down = j == 4 ? "X" : places[i][j + 1][k];
                let left = k == 0 ? "X" : places[i][j][k - 1];
                let right = k == 4 ? "X" : places[i][j][k + 1];

                if (seat == "P" && (up == "P" || down == "P" || left == "P" || right == "P")) {
                    bool = false;
                    break;
                }
                if (seat == "O" && (up + down + left + right).split("P").length - 1 > 1) {
                    bool = false;
                    break;
                }
            }

            if (bool == false) {
                break;
            }
        }

        answer.push(bool == true ? 1 : 0);
    }

    return answer;
}

solution([
    ["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"],
    ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"],
    ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"],
    ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"],
    ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]
]);