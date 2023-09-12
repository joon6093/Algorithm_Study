import sys
import heapq
input = sys.stdin.readline

N = int(input().strip())
heap = []

for i in range(N):
    for num in list(map(int,input().rstrip().split())):
        if len(heap) < N:
            heapq.heappush(heap, num)
        else:
            if heap[0] < num:
                heapq.heappop(heap)
                heapq.heappush(heap,num)

print(heap[0])