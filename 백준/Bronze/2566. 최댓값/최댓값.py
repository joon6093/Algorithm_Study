import sys
arr = [list(map(int,sys.stdin.readline().strip().split())) for _ in range(9)]
song=-1
answer=[]
for i in range(0,9):
    for j in range(0,9):
        if((song<arr[i][j])):
            song=arr[i][j]
            answer=[i+1,j+1]
print(song)
print(*answer)
