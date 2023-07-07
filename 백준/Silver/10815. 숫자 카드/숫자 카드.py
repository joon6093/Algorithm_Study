import sys
input = sys.stdin.readline

N = int(input())
cards = list(map(int, input().split()))
M = int(input())
other_cards = list(map(int, input().split()))
song = {}

for i in other_cards:
    song[i] = 0

for i in cards:
    if i in song:
        song[i] = 1

for value in song.values():
    print(value, end=' ')