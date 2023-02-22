import sys

input = sys.stdin.readline
meal = list(map(int, input().split()))
people =  list(map(int, input().split()))

song=0
for i in range(len(meal)):
    if people[i]>meal[i]:
        song+=people[i]-meal[i]

print(song)