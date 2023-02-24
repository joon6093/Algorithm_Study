import sys
input = sys.stdin.readline

R, C, N = map(int, input().split())
bomber = [list(input().rstrip()) for i in range(R)]
move=[(0, 1), (0, -1), (1, 0), (-1, 0)]

if N==1:
    for i in bomber:
        print(''.join(i))
elif N%2==0:
    for i in range(R): print('O'*C)
else:
    TEMP_bomber1 = [['O']*C for i in range(R)]
    for y in range(R):
        for x in range(C):
            if bomber[y][x]=='O': 
                TEMP_bomber1[y][x] = '.'
                for i, j in move:
                    if y+i>=0 and y+i<R and x+j>=0 and x+j<C and TEMP_bomber1[y+i][x+j]=='O':
                        TEMP_bomber1[y+i][x+j] = '.'
    if N%4==3:
        for i in TEMP_bomber1:
            print(''.join(i))
        exit()

    TEMP_bomber2 = [['O']*C for i in range(R)]
    for y in range(R):
        for x in range(C):
            if TEMP_bomber1[y][x]=='O':
                TEMP_bomber2[y][x] = '.'
                for i, j in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                    if y+i>=0 and y+i<R and x+j>=0 and x+j<C and TEMP_bomber2[y+i][x+j]=='O':
                        TEMP_bomber2[y+i][x+j] = '.'

    if N%4==1:
        for i in TEMP_bomber2:
            print(''.join(i))
