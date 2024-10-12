def solution(n):
    one_count = bin(n).count('1')
    
    while True:
        n += 1
        if one_count == bin(n).count('1'):
            break
            
    return n