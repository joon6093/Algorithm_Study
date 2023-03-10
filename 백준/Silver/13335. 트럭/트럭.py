import sys
from collections import deque
input = sys.stdin.readline

n, w, L = map(int,input().split())
start_truck = list(map(int, input().split()))
going_truck=deque()

time=-1
truch_weight=0
append_index=0
pop_index=0
while True:
    time +=1
    if  append_index == len(start_truck) and len(going_truck) == 0:
        break

    if len(going_truck) != 0:
        if going_truck[0] == w:
            going_truck.popleft()
            truch_weight -= start_truck[pop_index]
            pop_index+=1
        going_truck =  deque(going_truck[i] + 1 for i in range(len(going_truck)))
    if append_index == len(start_truck):
        continue
    elif L>=truch_weight + start_truck[append_index]:
        going_truck.append(1)
        truch_weight += start_truck[append_index]
        append_index +=1

print(time)