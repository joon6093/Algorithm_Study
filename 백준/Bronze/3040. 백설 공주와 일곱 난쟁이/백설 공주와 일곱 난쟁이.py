import sys
from itertools import combinations
input=sys.stdin.readline

dwarf= [int(input()) for _ in range(9)]

for case in combinations(dwarf,7):
    if sum(case)==100:
        for i in case:
            print(i)