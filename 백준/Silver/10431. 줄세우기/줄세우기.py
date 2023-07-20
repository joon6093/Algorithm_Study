import sys

index = int(input())
people_infor = [list(map(int, input().strip().split())) for _ in range(index)]

for i in range(index):
    count = 0
    for j in range(1,20):
        for k in range(j+1,21): 
            if people_infor[i][j] > people_infor[i][k]: 
                people_infor[i][j], people_infor[i][k] = people_infor[i][k], people_infor[i][j]
                count += 1
    print(i+1, count)


