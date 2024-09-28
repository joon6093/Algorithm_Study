def solution(participant, completion):
    dict = {}
    sum_hash_value = 0
    
    for people in participant:
        hash_value = hash(people)
        dict[hash_value] = people
        sum_hash_value += hash_value
    
    for people in completion:
        sum_hash_value -= hash(people)
        
    return dict[sum_hash_value]