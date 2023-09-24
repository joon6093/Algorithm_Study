import sys
input = sys.stdin.readline

num_infor_list = [0] * 11
num_infor_list[0] = 1

for i in range(0, 11):
    if i-1>=0:
        num_infor_list[i] += num_infor_list[i-1]
    else:
        continue
    if i-2>=0:
        num_infor_list[i] += num_infor_list[i-2]
    else:
        continue
    if i-3>=0:
        num_infor_list[i] += num_infor_list[i-3]
    else:
        continue

T = int(input().strip())

for _ in range(T):
    n = int(input().strip())
    print(num_infor_list[n])