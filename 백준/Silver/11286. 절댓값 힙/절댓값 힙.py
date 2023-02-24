import sys
from heapq import heappush, heappop 
input = sys.stdin.readline

index = int(input())
heap = []

for _ in range(index):
    num = int(input())
    if num != 0:
        heappush(heap, (abs(num),num))
    else:
        try:
            print(heappop(heap)[1])
        except:
            print(0)