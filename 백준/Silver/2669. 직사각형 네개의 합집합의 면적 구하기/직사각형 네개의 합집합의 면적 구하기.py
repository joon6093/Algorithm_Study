import sys
input = sys.stdin.readline

rectangle = [list(map(int, input().split())) for _ in range(4)]
plane = [[0]*100 for _ in range(100)]

song=0
for x1,y1,x2,y2 in rectangle:
    for i in range(x1,x2):
        for j in range(y1,y2):
            if plane[i][j]==0:
                plane[i][j]=1
                song+=1


print(song)
