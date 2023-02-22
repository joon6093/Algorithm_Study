import sys
row,col  = map(int,sys.stdin.readline().strip().split())
infor = list(map(int, sys.stdin.readline().split()))

block_list = [[0 for j in range(col)] for i in range(row)]

for i in range(row):
    for j in range(col):
        if(infor[j]):
            infor[j]-=1
            block_list[i][j]=True
        else:
            block_list[i][j]=False

song=0
for i in range(row):
    for j in range(col):
        if(block_list[i][j]==False):
            min_block=col
            max_block=-1
            for k in range(col):
                if(block_list[i][k]==True):
                    if k > max_block:
                        max_block = k
                    if k < min_block:
                        min_block = k
            if(j>min_block and j<max_block):
                song+=1

print(song)
