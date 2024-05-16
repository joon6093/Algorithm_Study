from collections import deque

dy = [-1, 1, 0, 0]
dx = [0, 0, -1, 1]
    
def solution(land):
    row, col = len(land), len(land[0])
    visited = [[0] * col for _ in range(row)]
    song = [0] * col
    
    for i in range(row):
        for j in range(col):
            if not visited[i][j] and land[i][j] == 1:
                bfs(i, j, visited, row, col, land, song)
                
    return max(song)
    

def bfs(y, x, visited, row, col, land, song):
    queue = deque([(y, x)])
    visited[y][x] = 1
    amount = 0
    x_visited = set([x])

    while queue:
        new_y, new_x = queue.popleft()
        amount += 1

        for i in range(4):
            move_y = new_y + dy[i]
            move_x = new_x + dx[i]

            if 0 <= move_y < row and 0 <= move_x < col and not visited[move_y][move_x] and land[move_y][move_x] == 1:
                queue.append((move_y, move_x))
                x_visited.add(move_x)
                visited[move_y][move_x] = 1
                
    for i in x_visited:
        song[i] += amount
    