import heapq
import sys

index = int(sys.stdin.readline())
infor = [list(map(int,sys.stdin.readline().strip().split())) for _ in range(index)]
infor = sorted(infor, key=lambda x : x[0])
song = []
count=0

for i, v in enumerate(infor):
    if(i == 0):
        heapq.heappush(song,v[1])
        count +=1
    elif(v[0]>=song[0]):
        heapq.heappop(song)
        heapq.heappush(song,v[1])
    else:
        heapq.heappush(song,v[1])
        count +=1
print(count)
