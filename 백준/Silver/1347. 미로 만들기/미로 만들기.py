import sys
input = sys.stdin.readline
n = int(input().strip())
move_list = input().strip()
miro_list = [['#']* 101 for _ in range(101)]

direction = 0
pos_row = 50
pos_col = 50
miro_list[pos_row][pos_col] = '.'

for move in move_list:
    if move =='R':
        direction += 1
        direction %= 4
    elif move == 'L':
        direction -= 1
        direction %= 4
    elif move =='F':
        if direction == 0:
            pos_row += 1
        elif direction == 1:
            pos_col -= 1
        elif direction == 2:
            pos_row -= 1
        elif direction == 3:
            pos_col += 1
        miro_list[pos_row][pos_col] = '.'

start_row = -1
end_row = -1
start_col = -1
end_col = -1

for i in range(101):
    for j in range(101):
        if miro_list[i][j] == '.':
            if start_row == -1:
                start_row = i
            end_row = i
        if miro_list[j][i] == '.':
            if start_col == -1:
                start_col = i
            end_col = i

for i in range(start_row, end_row+1):
    print(*miro_list[i][start_col:end_col+1], sep='')