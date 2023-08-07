import sys
input = sys.stdin.readline

N, K = map(int, input().split())
pos_infor = list(input())
count = 0 
for i in range(N):
    if pos_infor[i] == 'P':
        for j in range(max(i-K, 0), min(i+K+1, N)):
            if pos_infor[j] == 'H':
                pos_infor[j] = 'E'
                count +=1
                break


print(count)
