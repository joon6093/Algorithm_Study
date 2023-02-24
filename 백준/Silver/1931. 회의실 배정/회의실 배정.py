import sys
input = sys.stdin.readline

N=int(input())
time = [list(map(int, input().split())) for _ in range(N)]

time.sort(key = lambda x: (x[1], x[0]))

end=time[0][1]
song=1
for i in range(1,N):
    if time[i][0]>=end:
        song+=1
        end=time[i][1]

print(song)