import sys
input = sys.stdin.readline

T = int(input().strip())
for _ in range(T):
    n, k, t, m = map(int, input().strip().split())
    team_explanation_list = [[0]*(k+1) for _ in range(n+1)]
    count_explanation_list = [0]*(n+1)
    last_explanation_list = [0]*(n+1)
    for index in range(1,m+1):
        i, j, s = map(int, input().strip().split())
        team_explanation_list[i][j] = max(team_explanation_list[i][j],s)
        last_explanation_list[i] = index
        count_explanation_list[i] += 1
    my_team_score= sum(team_explanation_list[t])
    song = 1
    for i in range(1, n+1):
        if i == t:
            continue
        if my_team_score < sum(team_explanation_list[i]):
            song +=1 
        elif my_team_score == sum(team_explanation_list[i]):
            if count_explanation_list[t] > count_explanation_list[i]:
                song+=1
            elif count_explanation_list[t] == count_explanation_list[i]:
                if last_explanation_list[t] > last_explanation_list[i]:
                    song+=1
    print(song)

