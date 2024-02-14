import sys
input = sys.stdin.readline

N1, N2 = map(int, input().strip().split())
N1_list = list(input().strip())
N1_list.reverse()
N2_list = list(input().strip())
ant_list = N1_list + N2_list
T = int(input().strip())
if T > N1 + N2:
    T = N1 + N2
    
for _ in range(T):
    temp_list = ant_list.copy()
    for i in range(N1+N2-1):
        if ant_list[i] in N1_list and ant_list[i+1] in N2_list:
                temp_list[i], temp_list[i+1] = temp_list[i+1], temp_list[i]
    ant_list = temp_list
    
print("".join(ant_list))