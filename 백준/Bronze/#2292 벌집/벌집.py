import sys
input = sys.stdin.readline

N = int(input().strip()) - 1
if (N == 0):
    print(1)
else:
    count = 0
    while(N > 0):
        N -= count * 6
        count += 1

    print(count)