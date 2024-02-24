import sys
import itertools

input = sys.stdin.readline
N, M = map(int, input().split())
num_list = [i for i in range(1, N+1)]

array = itertools.permutations(num_list, M)

for i in array:
    print(*i)