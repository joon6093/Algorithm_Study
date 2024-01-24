import sys
input = sys.stdin.readline

N, M = map(int,input().strip().split())
r, c, d = map(int,input().strip().split())
location_list = [list(map(int,input().strip().split())) for _ in range(N)]
move_list = [[-1, 0], [0, 1], [1, 0], [0, -1]]

song = 0
move_flage = 0
while True:
    move_flage = 0
    if location_list[r][c] == 0:
        location_list[r][c] = 2
        song+=1
    for i in range(4):
        d = (d+3) % 4
        move_r = r + move_list[d][0]
        move_c = c + move_list[d][1]
        if move_r<0 or move_r>N-1 or move_c <0 or move_c>M-1 or location_list[move_r][move_c] != 0:
            continue
        r = move_r 
        c = move_c
        move_flage = 1
        break
    if move_flage == 0:
        move_r = r-move_list[d][0]
        move_c = c-move_list[d][1]
        if move_r<0 or move_r>N-1 or move_c <0 or move_c>M-1 or location_list[move_r][move_c] == 1:
            break
        else:
            r = move_r 
            c = move_c
print(song)
