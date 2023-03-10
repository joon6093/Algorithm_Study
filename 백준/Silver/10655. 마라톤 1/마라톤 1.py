import sys
input = sys.stdin.readline

index = int(input())
check_point = [list(map(int, input().split())) for _ in range(index)]

total_length=0
long_length=0
frist_length=0
last_length=abs(check_point[0][0]-check_point[1][0]) + abs(check_point[0][1]-check_point[1][1])
for i in range(0,len(check_point)-1):
    length=abs(check_point[i][0]-check_point[i+1][0]) + abs(check_point[i][1]-check_point[i+1][1])
    total_length+= length
    if i != 0:
        frist_length=last_length
        last_length=length
        skip_length=abs(check_point[i-1][0]-check_point[i+1][0]) + abs(check_point[i-1][1]-check_point[i+1][1])
        long_length=max(long_length,frist_length+last_length-skip_length)

print(total_length-long_length)


