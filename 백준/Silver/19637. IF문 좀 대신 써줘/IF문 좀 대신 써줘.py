import sys
import  bisect 
input = sys.stdin.readline

N, M = map(int,input().split())
power_name = []
power_standard = []
for _ in range(N):
    name, standard = input().split()
    power_name.append(name)
    power_standard.append(int(standard))

power_infor = [int(input().strip()) for _ in range(M)]

for power in power_infor:
    print(power_name[bisect.bisect_left(power_standard, power)])
    