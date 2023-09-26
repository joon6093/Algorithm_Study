import sys
from collections import defaultdict
input = sys.stdin.readline

N = int(input().strip())
block_list = defaultdict(int)
max_height = 0
max_height_index = -1
for _ in range(N):
    index, height = map(int, input().rstrip().split())
    if (max_height < height ):
        max_height = height
        max_height_index = index
    block_list[index] = height

song = 0
curr_height = 0
for i in range(1, max_height_index):
    if i in block_list:
        if curr_height < block_list[i]:
            curr_height = block_list[i]
    song += curr_height
    
curr_height = 0
for i in range(1000, max_height_index, -1):
    if i in block_list:
        if curr_height < block_list[i]:
            curr_height = block_list[i]
    song += curr_height
    
print(song + max_height)
    