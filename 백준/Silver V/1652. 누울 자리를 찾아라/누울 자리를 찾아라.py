import sys
input = sys.stdin.readline

N = int(input().strip())
room_list = [list(input().strip()) for _ in range(N)]

row_ans = col_ans  = 0

for i in range(N):
    row_count = col_count = 0
    for j in range(N):
        if room_list[i][j] == '.':
            row_count+= 1
        else:
            if row_count >= 2:
                row_ans += 1
            row_count = 0

        if room_list[j][i] =='.':
            col_count+= 1
        else:
            if col_count >= 2:
                col_ans += 1
            col_count = 0
    if row_count >= 2:
        row_ans += 1
    if col_count >= 2:
        col_ans += 1
print(row_ans, col_ans)