import sys
input = sys.stdin.readline

index = int(input())
game_board = [list(map(int, input().split())) for _ in range(index)]

dp = [[0] * index for _ in range(index)]  
dp[0][0] = 1

for i in range(0,index):
    for j in range(0,index):
        if i==index-1 and j==index-1:
            print(dp[i][j])
            exit()
        temp = game_board[i][j]
        if i + temp < index:
            dp[i+temp][j] += dp[i][j] 
        if j + temp < index:
            dp[i][j+temp] += dp[i][j]
        

