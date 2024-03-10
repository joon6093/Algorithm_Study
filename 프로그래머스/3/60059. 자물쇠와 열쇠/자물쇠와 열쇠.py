def move_90(M, key_temp, key):
    for i in range(M):
        for j in range(M):
            key_temp[j][M-1-i] = key[i][j]
    return key_temp

def move_180(M, key_temp, key):
    for i in range(M):
        for j in range(M):
            key_temp[M-1-i][M-1-j] = key[i][j]
    return key_temp

def move_270(M, key_temp, key):
    for i in range(M):
        for j in range(M):
            key_temp[M-1-j][i] = key[i][j]
    return key_temp

def solution(key, lock):
    answer = False
    M = len(key)
    N = len(lock)
    plus_lock_count = (M-1)*2 + N
    plus_lock = [[0] * plus_lock_count for _ in range(plus_lock_count)]

    key_list = [key,move_90(M, [arr[:] for arr in key], [arr[:] for arr in key]),
                move_180(M, [arr[:] for arr in key], [arr[:] for arr in key]),
                move_270(M, [arr[:] for arr in key], [arr[:] for arr in key])]
    
    for key in key_list:
        
        for i in range(M-1 ,M-1+N):
            plus_lock[i][M-1: M-1+N] = lock[i-(M-1)][:]

        for i in range(plus_lock_count-2):
            for j in range(plus_lock_count-2):

                temp_lock = [arr[:] for arr in plus_lock]

                for k in range(M):
                    for q in range(M):
                        if i+k > plus_lock_count-1 or i+k <0 or j+q<0 or j+q > plus_lock_count-1:
                            continue
                        temp_lock[i+k][j+q] = key[k][q] + temp_lock[i+k][j+q]
                    
                pass_row = 0
                for h in range(M-1, M-1+N):
                    if len(set(temp_lock[h][M-1: M-1+N])) != 1:
                        break
                    pass_row +=1
                    
                if pass_row == N:
                    answer = True
    return answer