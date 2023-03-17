import sys
input = sys.stdin.readline

max_player, max_garden  = map(int,input().split())
player = [list(input().strip().split()) for _ in range(max_player)]

room=[]
room_list=[]
for i in player:
    level=int(i[0])
    name=i[1]
    room_level=-1
    room_check=False
    for j in range(len(room)):
        if room[j]>=level-10 and room[j]<=level+10:
            room_level=j
            if len(room_list[room_level])<max_garden:
                room_check=True
                break
    
    if room_check:  
        room_list[room_level].append((level,name))
    else:
        room.append(level)
        room_list.append([(level,name)])


for i in room_list:
    if(len(i)==max_garden):
        print("Started!")
    else:
        print("Waiting!")
    i.sort(key=lambda x: x[1])
    for j in i:
        print(*j)