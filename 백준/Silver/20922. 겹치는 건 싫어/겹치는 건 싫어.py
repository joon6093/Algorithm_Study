import sys
input = sys.stdin.readline

N, K = map(int, input().strip().split())
data = list(map(int, input().strip().split()))

count_list = [0] * (max(data)+1)
start_index = 0
end_index = 0
song = 0

while(end_index < N):
    if count_list[data[end_index]] < K:
        count_list[data[end_index]] += 1
        end_index += 1
    else:
        count_list[data[start_index]] -= 1
        start_index += 1
    song = max(song, end_index - start_index)
print(song)