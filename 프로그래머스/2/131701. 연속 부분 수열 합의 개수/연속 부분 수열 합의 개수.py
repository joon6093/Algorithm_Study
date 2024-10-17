def solution(elements):
    seq_elements = elements * 2
    answer = set()
    for i in range(1, len(elements)+1):
        for j in range(len(elements)):
            answer.add(sum(seq_elements[j:j+i])) 
    return len(answer)