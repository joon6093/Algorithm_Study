import sys
input = sys.stdin.readline

king_pos, stone_pos, N = map(str, input().strip().split())
pos_list = []
for pos in [king_pos, stone_pos]:
    pos_list.append([ord(pos[0]), int(pos[1])])
move_list = [input().strip() for _ in range(int(N))]
move_infor = {'R': [1, 0], 'L': [-1, 0], 'B': [0, -1], 'T': [0, 1], 'RT': [1, 1], 'LT': [-1, 1], 'RB': [1, -1], 'LB': [-1, -1]}

for move in move_list:
    move_row = pos_list[0][0] + move_infor[move][0]
    move_col = pos_list[0][1] + move_infor[move][1]
    if(move_row<65 or move_row>72 or move_col<1 or move_col>8):
        continue
    if(move_row == pos_list[1][0] and move_col == pos_list[1][1]):
        stone_move_row = pos_list[1][0] + move_infor[move][0]
        stone_move_col = pos_list[1][1] + move_infor[move][1]
        if(stone_move_row<65 or stone_move_row>72 or stone_move_col<1 or stone_move_col>8):
            continue
        pos_list[1][0] = stone_move_row
        pos_list[1][1] = stone_move_col
    pos_list[0][0] = move_row
    pos_list[0][1] = move_col

for pos in pos_list:
    print(chr(pos[0]) + str(pos[1]))