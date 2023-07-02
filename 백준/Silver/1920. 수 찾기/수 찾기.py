import sys
input = sys.stdin.readline

N = int(input())
arr=set(map(int, input().split()))
M = int(input())
numbers=list(map(int, input().split()))

for i in numbers:
    if i in arr:
        print(1)
    else:
        print(0)