def solution(s):
    p_count = s.count('p') + s.count('P') 
    y_count = s.count('y') + s.count('Y')
    
    return p_count == y_count