import sys
from collections import deque
import copy
input = sys.stdin.readline


def bfs(puzzle):
    queue=deque([puzzle])
    visited[puzzle]=0
    while queue:
        puzzle=queue.popleft()
        if puzzle == "123456780":
            return visited["123456780"]
        pos = puzzle.index('0') # 0(빈칸)의 위치
        row=pos//3
        col=pos%3
        for x,y in move:
            move_row=row + x
            move_col=col + y
            if 0 <= move_row < 3 and 0 <= move_col < 3:
                move_pos=move_row*3+move_col
                temp_puzzle=list(puzzle)
                temp_puzzle[pos],temp_puzzle[move_pos] = temp_puzzle[move_pos],temp_puzzle[pos]
                temp_puzzle = "".join(temp_puzzle)
                if temp_puzzle not in visited:
                    queue.append((temp_puzzle))
                    visited[temp_puzzle]=visited[puzzle]+1

    return -1


visited={}
row=0
col=0
move=[[-1,0],[1,0],[0,-1],[0,1]]
count=0
puzzle = ""
for _ in range(3):
    temp = input().strip()
    temp = temp.replace(" ", "")
    puzzle += temp

print(bfs(puzzle))

            