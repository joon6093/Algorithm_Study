import sys
input = sys.stdin.readline

for _ in range(int(input())):
    N=int(input())
    info=list(map(int,input().split()))
    in_list={}
    except_list = []
    grade = 0
    for i in info:
        grade += 1
        if i not in in_list and i not in except_list:
            count = info.count(i)
            if count < 6:
                grade-=1
                except_list.append(i)
                continue
            else:
                in_list[i] = []
        if i in except_list:
            grade-=1
            continue
        if i in in_list:
            in_list[i].append(grade)
    max_score = float("inf")  
    max_team = 0
    for key, value in in_list.items():
        score = in_list[key][0]+in_list[key][1]+in_list[key][2]+in_list[key][3]
        if max_score > score:
            max_team = key
            max_score = score
        elif max_score == score:
            if in_list[max_team][4] > in_list[key][4]:
                max_team = key
                max_score = score
    print(max_team)
