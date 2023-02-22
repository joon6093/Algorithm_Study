import sys
train_infor = [list(map(int,sys.stdin.readline().strip().split())) for _ in range(10)]

people=0
song=0
for i in train_infor:
    people-=i[0]
    people+=i[1]
    if(song<people):
        song=people

print(song)


