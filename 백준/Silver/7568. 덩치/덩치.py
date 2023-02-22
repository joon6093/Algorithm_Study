import sys
index  = int(sys.stdin.readline())
person_infor = [list(map(int,sys.stdin.readline().strip().split())) for _ in range(index)]
rank_list=[]
for i in range(index):
    rank=1
    for j in range(index):
        if(i == j):
            continue
        if((person_infor[i][0]<person_infor[j][0] and person_infor[i][1]<person_infor[j][1])):
            rank+=1
    rank_list.append(rank)
print(*rank_list)