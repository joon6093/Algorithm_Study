import sys
input = sys.stdin.readline

N, M, x, y, K = map(int,input().strip().split())
map_list = [list(map(int,input().strip().split())) for _ in range(N)]
command_list = list(map(int,input().strip().split()))
dice = [0] * 7
move_list = [[0,0], [0,1], [0,-1], [-1, 0], [1, 0]]

for i in command_list:
    move_x = x + move_list[i][0]
    move_y = y + move_list[i][1]
    if move_x < 0 or move_x > N-1 or move_y < 0 or move_y > M-1:
        continue
    if i == 1:
        temp = dice[1]
        dice[1] = dice[4]
        dice[4] = dice[6]
        dice[6] = dice[3]
        dice[3] = temp
    elif i == 2:
        temp = dice[1]
        dice[1] = dice[3]
        dice[3] = dice[6]
        dice[6] = dice[4]
        dice[4] = temp
    elif i == 3:
        temp = dice[1]
        dice[1] = dice[5]
        dice[5] = dice[6]
        dice[6] = dice[2]
        dice[2] = temp
    elif i == 4:
        temp = dice[1]
        dice[1] = dice[2]
        dice[2] = dice[6]
        dice[6] = dice[5]
        dice[5] = temp
    if map_list[move_x][move_y] == 0:
        map_list[move_x][move_y] = dice[6]
    else:
        dice[6] = map_list[move_x][move_y]
        map_list[move_x][move_y] = 0
    x = move_x
    y = move_y
    print(dice[1])