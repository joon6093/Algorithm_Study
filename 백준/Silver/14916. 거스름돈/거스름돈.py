import sys
input = sys.stdin.readline

def coin_change(coins, amount):
    dp = [float("inf")] * (amount + 1)
    dp[0] = 0
    for j in range(1,amount+1):
    	for i in range(len(coins)): 
            if(coins[i]<=j and dp[j-coins[i]]+1 < dp[j]):
                dp[j]=dp[j-coins[i]]+1
    return dp[amount]

coins = [5,2]
amount = int(input()) 
song= coin_change(coins, amount)
if song == float("inf"):
    song = -1
print(song)