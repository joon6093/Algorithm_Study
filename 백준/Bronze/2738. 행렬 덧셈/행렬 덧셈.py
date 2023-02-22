import sys
row_index,col_index  = map(int,sys.stdin.readline().strip().split())

arr1 = [list(map(int,sys.stdin.readline().strip().split())) for _ in range(row_index)]
arr2 = [list(map(int,sys.stdin.readline().strip().split())) for _ in range(row_index)]

song=[[arr1[i][j] + arr2[i][j] for j in range(col_index)] for i in range(row_index)]
for i in song:
    print(" ".join(map(str, i)))