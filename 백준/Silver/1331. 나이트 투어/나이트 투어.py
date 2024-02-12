import sys
input = sys.stdin.readline
visited_list = []
visited_infor = 0
visit_infor = 0
song = "Valid"
for i in range(36):
    visit_infor = input().strip()
    if visit_infor in visited_list:
        song = "Invalid"
    if visited_infor != 0:
        if abs(ord(visited_infor[0]) - ord(visit_infor[0])) == 2:
            if abs(int(visited_infor[1]) - int(visit_infor[1])) != 1:
                song = "Invalid"
        elif abs(ord(visited_infor[0]) - ord(visit_infor[0])) == 1:
            if abs(int(visited_infor[1]) - int(visit_infor[1])) != 2:
                song = "Invalid"
        else:
            song = "Invalid"
            
    visited_infor = visit_infor
    visited_list.append(visit_infor)

if song == "Valid":
    if abs(ord(visited_list[0][0]) - ord(visit_infor[0])) == 2:
        if abs(int(visited_list[0][1]) - int(visit_infor[1])) != 1:
            song = "Invalid"
    elif abs(ord(visited_list[0][0]) - ord(visit_infor[0])) == 1:
        if abs(int(visited_list[0][1]) - int(visit_infor[1])) != 2:
            song = "Invalid"
    else:
            song = "Invalid"
print(song)