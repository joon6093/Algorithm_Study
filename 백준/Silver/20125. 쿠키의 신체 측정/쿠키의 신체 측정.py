import sys
input = sys.stdin.readline

index = int(input())
cookie = [list(input().rstrip()) for _ in range(index)]

heart = []
body = []
for row in range(index):
    for col in range(index):
        if(cookie[row][col] == '*'):
            heart = [row+1,col]
            break
    if heart:
        break

for col in range(heart[1],-1,-1):
    if(cookie[heart[0]][col] == '_'):
        body.append(heart[1]-col-1)
        break
    elif (col == 0):
        body.append(heart[1]-col)
        break

for col in range(heart[1],index):
    if(cookie[heart[0]][col] == '_'):
        body.append(col-heart[1]-1)
        break
    elif (col == index -1):
        body.append(col-heart[1])
        break

for row in range(heart[0],index):
    if(cookie[row][heart[1]] == '_'):
        body.append(row-heart[0]-1)
        break
    elif (row == index -1):
        body.append(row-heart[0])
        break

for row in range(heart[0]+body[2]+1,index):
    if(cookie[row][heart[1]-1] == '_'):
        body.append(row-(heart[0]+body[2])-1)
        break
    elif (row == index -1):
        body.append(row-(heart[0]+body[2]))
        break

for row in range(heart[0]+body[2]+1,index):
    if(cookie[row][heart[1]+1] == '_'):
        body.append(row-(heart[0]+body[2])-1)
        break
    elif (row == index -1):
        body.append(row-(heart[0]+body[2]))
        break

heart[0] += 1
heart[1] += 1
print(*heart)
print(*body)