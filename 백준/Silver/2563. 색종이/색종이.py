import sys
paper = [[0 for _ in range(101)] for _ in range(101)]
index = int(sys.stdin.readline())
dark = [list(map(int,sys.stdin.readline().strip().split())) for _ in range(index)]
for x,y in dark:
    for i in range(x,x+10):
        for j in range(y,y+10):
            paper[i][j]=1
song=0
for i in paper:
    song+=i.count(1)

print(song)