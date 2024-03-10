def solution(friends, gifts):
    gift_log = {}
    total_gift = {}
    next_month = [0] * len(friends)
                           
    for i in friends:
        temp = {}
        total_gift[i] = 0
        for j in friends:
            temp[j] = 0
        gift_log[i] = temp
    
    for gift in gifts:
        give_freiend, take_friend = gift.split()
        gift_log[give_freiend][take_friend] += 1
        total_gift[give_freiend] += 1
        total_gift[take_friend] -= 1
    
    for i in range(len(friends)):
        for j in range(i, len(friends)):
            if i == j:
                continue
            if gift_log[friends[i]][friends[j]] > gift_log[friends[j]][friends[i]]:
                next_month[i] +=1
            elif gift_log[friends[i]][friends[j]] < gift_log[friends[j]][friends[i]]:
                next_month[j] +=1
            else:
                if total_gift[friends[i]] > total_gift[friends[j]]:
                    next_month[i] +=1
                elif total_gift[friends[i]] < total_gift[friends[j]]:
                    next_month[j] +=1
        
    answer = max(next_month)
    return answer