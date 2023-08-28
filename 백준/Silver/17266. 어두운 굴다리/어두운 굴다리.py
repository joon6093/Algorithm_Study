import sys
input = sys.stdin.readline

N = int(input().strip())
M = int(input().strip())
streetlamp_pos_list = list(map(int,input().split()))

max_height = 0


max_height = max(streetlamp_pos_list[0], N - streetlamp_pos_list[M-1])
if M != 1:
    max_height = max(streetlamp_pos_list[0], N - streetlamp_pos_list[M-1])
    for i in range(1, M-1):
        street_len = streetlamp_pos_list[i]-streetlamp_pos_list[i-1] 
        if street_len % 2:
            height = street_len // 2 + 1
        else:
            height = street_len // 2
        max_height = max(height,max_height)

print(max_height)
