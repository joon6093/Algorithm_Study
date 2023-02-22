import sys

input=sys.stdin.readline

team = int(input().rstrip())
people = list(map(int, sys.stdin.readline().split()))

people.sort()

song=0
answer=99999999999999999999
half=len(people)-1

for i in range(team):
    song=people[i] + people[half]
    half-=1
    answer=min(answer,song)

print(answer)