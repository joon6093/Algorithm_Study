import heapq
import sys

index = int(sys.stdin.readline())
heap = [int(sys.stdin.readline()) for _ in range(index)]
heapq.heapify(heap)
song = 0
if (index == 1):
    print(0)
else:
    for _ in range(index-1):
        sum=heapq.heappop(heap)
        sum+=heapq.heappop(heap)
        heapq.heappush(heap,sum)
        song += sum
    print(song)
