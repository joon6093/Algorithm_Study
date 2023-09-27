import sys
import math
input = sys.stdin.readline

N = int(input().strip())
examroom_list = list(map(int,input().rstrip().split()))
B, C = map(int,input().rstrip().split())

song = N
for i in examroom_list:
    i -= B
    if i > 0:
        song += math.ceil(i/C) 

print(song)
