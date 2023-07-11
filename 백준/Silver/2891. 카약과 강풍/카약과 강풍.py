index, broken_team_index, redundancy_team_index = map(int, input().split())
broken_team = set(map(int, input().split()))
redundancy_team = set(map(int, input().split()))

song = 0
for i in range(1, index + 1):
    if i in broken_team:
        if i in redundancy_team:
            redundancy_team.remove(i)
            continue
        elif (i - 1) in redundancy_team and (i - 1) not in broken_team:
            redundancy_team.remove(i - 1)
            continue
        elif (i + 1) in redundancy_team and (i + 1) not in broken_team:
            redundancy_team.remove(i + 1)
            continue
        song += 1
print(song)
