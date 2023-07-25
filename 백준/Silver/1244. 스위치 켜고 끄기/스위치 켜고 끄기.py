import sys
input = sys.stdin.readline

switch_index = int(input())
switch = list(map(int, input().split()))
student_info_index = int(input())
student_info = [list(map(int, input().split())) for _ in range(student_info_index)]

def flip(num):
    num-=1
    if switch[num] == 0:
        switch[num] = 1
    else:
        switch[num] = 0

for sex, num in student_info:
    if sex == 1:
        for i in range(num, switch_index+1, num):
            flip(i)
    else:
        flip(num)
        for i in range(1,switch_index):
            if num-i-1<0 or num+i>switch_index:
                break
            if switch[num-i-1] == switch[num+i-1]:
                flip(num-i)
                flip(num+i)
            else:
                break

for i in range(switch_index):
    print(switch[i], end=" ")
    if i % 20 == 19:
        print()


