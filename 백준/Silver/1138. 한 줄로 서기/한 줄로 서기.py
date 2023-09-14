import sys
input = sys.stdin.readline

N = int(input().strip())
person_list = list(map(int,input().rstrip().split()))
song = [0]*N

for index, person in enumerate(person_list):
    temp_index = person
    while(song[:temp_index].count(0) != person or song[temp_index]):
        temp_index += 1
    song[temp_index] = index+1

print(*song)