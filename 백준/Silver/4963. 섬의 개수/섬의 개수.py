import sys
input = sys.stdin.readline
move_list = [[0,-1],[0,1],[-1,0],[1,0],[-1,-1],[-1,1],[1,-1],[1,1]]
sys.setrecursionlimit(10000)

def dfs(row, col):
    map_list[row][col] = 0
    for move_row, move_col in move_list:
        new_row = row + move_row
        new_col = col + move_col
        if new_row<0 or new_row>h-1 or new_col<0 or new_col>w-1:
            continue
        if map_list[new_row][new_col] == 1:
            dfs(new_row, new_col)

w = h = 0
map_list = []
while True:
    w, h = map(int, input().strip().split())
    if w == 0 and h == 0:
        break
    count = 0
    map_list = [list(map(int, input().strip().split())) for _ in range(h)]
    for row in range(h):
        for col in range(w):
            if map_list[row][col] == 1:
                dfs(row, col)
                count += 1
    print(count)
