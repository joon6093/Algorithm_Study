import sys
input = sys.stdin.readline

N,M  = map(int,input().split())
board = [list(map(str,input().strip())) for _ in range(N)]

def check(temp_col,temp_row):
    W_borad = [['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'], ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'], ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'], ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'], ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'], ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'], ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'], ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W']]
    B_borad = [['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'], ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'], ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'], ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'], ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'], ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'], ['B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'], ['W', 'B', 'W', 'B', 'W', 'B', 'W', 'B']]
    W_borad_cnt = 0
    B_borad_cnt = 0
    for i in range(8):
        for j in range(8):
            if board[temp_col+i][temp_row+j] != W_borad[i][j]:
                W_borad_cnt += 1
            if board[temp_col+i][temp_row+j] != B_borad[i][j]:
                B_borad_cnt += 1
    if W_borad_cnt > B_borad_cnt:
        return B_borad_cnt
    else:
        return W_borad_cnt
    
min_cnt = float('inf')
for col in range(N-7):
    for row in range(M-7):
        cnt= check(col,row)
        if cnt < min_cnt:
            min_cnt = cnt

print(min_cnt)
        
            
        

