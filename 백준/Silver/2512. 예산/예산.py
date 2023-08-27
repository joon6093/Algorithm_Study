import sys
input = sys.stdin.readline

N = int(input().strip())
amount_infor = list(map(int,input().split()))
max_amount = int(input().strip())
song = 0
amount_infor.sort()
while amount_infor:
    if max_amount > amount_infor[0]*len(amount_infor):
        max_amount -= amount_infor[0]*len(amount_infor)
        song += amount_infor[0]
        amount_infor = [i-amount_infor[0] for i in amount_infor]
        amount_infor.remove(0)
    else:
        song += max_amount//len(amount_infor)
        break

print(song)
        
