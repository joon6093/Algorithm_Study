from collections import deque
import sys
input = sys.stdin.readline

def radix_sort(nums):
    buckets = [deque() for _ in range(10)]
    max_val = max(nums)
    Q = deque(nums)
    cur_ten = 1
    while max_val >= cur_ten:
        while Q:
            num = Q.popleft()
            buckets[(num // cur_ten) % 10].append(num)
        for bucket in buckets:
            while bucket:
                Q.append(bucket.popleft())
        cur_ten *= 10
    return list(Q)

N = int(input())
numbers = [int(input())+1000000 for _ in range(N)]

for i in radix_sort(numbers):
    print(i-1000000)
