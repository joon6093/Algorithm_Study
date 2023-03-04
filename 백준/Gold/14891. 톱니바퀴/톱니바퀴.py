import sys
from collections import deque

def rotate_right(index,direction):
    if index > 3 or gears[index -1][2] == gears[index][6]:
        return
    rotate_right(index+1,-direction)
    gears[index].rotate(direction)


def rotate_left(index,direction):
    if index < 0 or gears[index+1][6] == gears[index][2]:
        return
    rotate_left(index-1,-direction)
    gears[index].rotate(direction)

input = sys.stdin.readline
gears = [deque(list(map(int, input().strip()))) for _ in range(4)]
K=int(input())
for _ in range(K):
    index, direction = map(int, input().split())
    index-=1
    rotate_right(index+1, -direction)
    rotate_left(index-1, -direction)
    gears[index].rotate(direction)

song=0
song += gears[0][0] * 1
song += gears[1][0] * 2
song += gears[2][0] * 4
song += gears[3][0] * 8

print(song)