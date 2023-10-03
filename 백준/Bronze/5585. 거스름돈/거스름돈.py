import sys
input = sys.stdin.readline

input_money = int(input().strip())
ouput_money = 1000 - input_money
coin_list = [500,100,50,10,5,1]
song = 0
for coin in coin_list:
    song += ouput_money//coin
    ouput_money%=coin
print(song)