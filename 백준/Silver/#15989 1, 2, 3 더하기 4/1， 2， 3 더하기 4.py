import sys
input = sys.stdin.readline

num_infor_list = [1] * 10001

for i in range(2, 10001):
    num_infor_list[i] += num_infor_list[i-2]


for i in range(3, 10001):
    num_infor_list[i] += num_infor_list[i-3]

T = int(input().strip())

for _ in range(T):
    n = int(input().strip())
    print(num_infor_list[n])