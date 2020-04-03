//爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。 
//
// 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作： 
//
// 
// 选出任一 x，满足 0 < x < N 且 N % x == 0 。 
// 用 N - x 替换黑板上的数字 N 。 
// 
//
// 如果玩家无法执行这些操作，就会输掉游戏。 
//
// 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：2
//输出：true
//解释：爱丽丝选择 1，鲍勃无法进行操作。
// 
//
// 示例 2： 
//
// 输入：3
//输出：false
//解释：爱丽丝选择 1，鲍勃也选择 1，然后爱丽丝无法进行操作。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 1000 
// 
// Related Topics 数学 动态规划

/*
最后的对弈绝对在2处
1.确定状态
》最后一步
最后一步若当前数字为2，那么爱丽丝赢
》子问题


 */


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean divisorGame(int N) {
        if (N == 1){
            return false;
        }
        boolean[] stage = new boolean[N+1];
        stage[1] = false;
        stage[2] = true;
        for(int i = 3; i <= N; i ++){
            int index = 1;
            while(index < i){
                //Alice选index之后,Bob剩余数为i-index，判断stage[i-index]能不能赢，能的话alice就输了
                if(i % index == 0 && !stage[i - index]){
                    stage[i] = true;
                    break;
                } else {
                    stage[i] = false;
                }
                index++;
            }
        }
        return stage[N];
    }
}
//leetcode submit region end(Prohibit modification and deletion)
