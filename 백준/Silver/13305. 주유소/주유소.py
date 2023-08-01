import sys
input = sys.stdin.readline

city_index = int(input())
distance_infor = list(map(int, input().split()))
price_infor=list(map(int, input().split()))

min_price = float('inf')
song = 0
for i in range(city_index-1):
    price = price_infor[i]
    min_price=min(min_price,price)
    song += min_price*distance_infor[i]

print(song)