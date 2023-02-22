import sys
index = int(sys.stdin.readline())
arr = [list(map(int,sys.stdin.readline().strip().split())) for _ in range(index)]

for i in arr:
    i.sort(reverse=True)
    print(i[2])