import sys
from heapq import heappush, heappop 
input = sys.stdin.readline

index = int(input())
heap = []

for _ in range(index):
    num = int(input())
    if num != 0:
        heappush(heap, (-num))
    else:
        try:
            print(-1 * heappop(heap))
        except:
            print(0)