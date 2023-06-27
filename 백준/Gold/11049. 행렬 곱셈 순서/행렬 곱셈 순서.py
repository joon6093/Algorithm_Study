import sys

input=sys.stdin.readline
index = int(input())
matrix = [list(map(int,input().strip().split())) for _ in range(index)]

arr = [[0 for j in range(index)] for i in range(index)]

for L in range(1,index):
    for i in range(0,index-L):
        j=i+L
        arr[i][j]=float("inf")
        for k in range(i,j):
            temp=arr[i][k] + arr[k+1][j] + matrix[i][0]*matrix[k+1][0]*matrix[j][1]
            arr[i][j]=min(arr[i][j],temp)

print(arr[0][index-1])
