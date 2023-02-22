import sys

input = sys.stdin.readline
index = int(input())
arr = [int(input()) for _ in range(index)]

song=999999
for i in range(0,100-17+1):
    diff=0
    for j in range(index):
        if(arr[j] < i):
            diff+=(i-arr[j])* (i-arr[j])
        if(arr[j] > i+17):
            diff+=(arr[j]-i-17)* (arr[j]-i-17)
    song=min(song,diff)

print(song)
