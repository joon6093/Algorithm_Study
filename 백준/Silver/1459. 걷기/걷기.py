import sys
input = sys.stdin.readline


X, Y, W, S = map(int, input().split())

only_w= (X+Y) * W

if (X+Y)%2 == 0:
    swap_W_one_S= max(X,Y)*S
else:
    swap_W_one_S=(max(X,Y)-1)*S+W

swap_W_S=(min(X, Y) * S) + (abs(X-Y) * W)

print(min(only_w,swap_W_one_S,swap_W_S))

