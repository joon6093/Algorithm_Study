import sys
from itertools import combinations

input = sys.stdin.readline

rowcol_index, M  = map(int,input().strip().split())
village = [list(map(int, input().split())) for _ in range(rowcol_index)]

home_list=[]
chicken_list=[]
for row in range(rowcol_index):
    for col in range(rowcol_index):
        if village[row][col] == 1:
            home_list.append((row,col))
        elif village[row][col] == 2:
            chicken_list.append((row,col))

result = float('inf')  
for choice in combinations(chicken_list, M): 
    song = 0            
    for i in home_list: 
        chicken_len = float('inf')   
        for j in range(M):
            chicken_len = min(chicken_len, abs(i[0] - choice[j][0]) + abs(i[1] - choice[j][1]))
        song += chicken_len
    result = min(result, song)
print(result)