import sys
input = sys.stdin.readline

N = int(input().strip())
ball_list = list(map(str, input().strip()))

max_red_count = 0
max_blue_count = 0
red_count = 1
blue_count = 1

for i in range(1, N):
    if ball_list[i] == 'R':
        if ball_list[i-1] == 'R':
            red_count += 1
        else:
            max_blue_count = max(max_blue_count, blue_count)
            break

    elif ball_list[i] == 'B':
        if ball_list[i-1] == 'B':
            blue_count += 1
        else:
            max_red_count = max(max_red_count, red_count)
            break

red_count = 1
blue_count = 1

for i in range(N-2, -1, -1):
    if ball_list[i] == 'R':
        if ball_list[i+1] == 'R':
            red_count += 1
        else:
            max_blue_count = max(max_blue_count, blue_count)
            break

    elif ball_list[i] == 'B':
        if ball_list[i+1] == 'B':
            blue_count += 1
        else:
            max_red_count = max(max_red_count, red_count)
            break


print (min(ball_list.count('R') - max_red_count, ball_list.count('B') - max_blue_count))