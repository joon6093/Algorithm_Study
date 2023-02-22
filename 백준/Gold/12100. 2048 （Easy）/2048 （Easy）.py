import sys
from copy import deepcopy
input = sys.stdin.readline

index = int(input())
arr = [list(map(int, input().split())) for _ in range(index)]
song = 0

def up(arr):
    for j in range(index):
        location = 0
        for i in range(1, index):
            if arr[i][j]:
                temp = arr[i][j]
                arr[i][j] = 0
                if arr[location][j] == 0:
                    arr[location][j] = temp
                elif arr[location][j]  == temp:
                    arr[location][j] += temp
                    location += 1
                else:
                    location += 1
                    arr[location][j] = temp
    return arr

def down(arr):
    for j in range(index):
        location = index - 1
        for i in range(index - 2, -1, -1):
            if arr[i][j]:
                temp = arr[i][j]
                arr[i][j] = 0
                if arr[location][j] == 0:
                    arr[location][j] = temp
                elif arr[location][j]  == temp:
                    arr[location][j]  += temp
                    location -= 1
                else:
                    location -= 1
                    arr[location][j] = temp
    return arr

def left(arr):
    for i in range(index):
        location = 0
        for j in range(1, index):
            if arr[i][j]:
                temp = arr[i][j]
                arr[i][j] = 0
                if arr[i][location] == 0:
                    arr[i][location] = temp
                elif arr[i][location]  == temp:
                    arr[i][location] += temp
                    location += 1
                else:
                    location += 1
                    arr[i][location]= temp
    return arr

def right(arr):
    for i in range(index):
        location = index - 1
        for j in range(index - 2, -1, -1):
            if arr[i][j]:
                temp = arr[i][j]
                arr[i][j] = 0
                if arr[i][location] == 0:
                    arr[i][location] = temp
                elif arr[i][location]  == temp:
                    arr[i][location]  += temp
                    location -= 1
                else:
                    location -= 1
                    arr[i][location] = temp
    return arr


def dfs(arr, cnt):
    if cnt == 5:
        return max(map(max, arr))

    return max(dfs(up(deepcopy(arr)), cnt + 1), dfs(down(deepcopy(arr)), cnt + 1), dfs(left(deepcopy(arr)), cnt + 1), dfs(right(deepcopy(arr)), cnt + 1))

print(dfs(arr, 0))