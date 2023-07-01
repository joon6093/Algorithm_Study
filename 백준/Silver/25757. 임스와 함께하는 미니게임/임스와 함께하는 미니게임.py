import sys

input = sys.stdin.readline

N, G = input().split()
people = [input() for _ in range(int(N))]

people = set(people)
if G == 'Y':
    print(len(people))
elif G == 'F':
    print(len(people)//2)
elif G == 'O': 
    print(len(people)//3)