def solution(cap, n, deliveries, pickups):
    answer = 0
    corrent_deliveries_cap = 0
    corrent_pickups_cap = 0
    first = -1 
    for i in range(n-1, -1, -1):
        if first == -1:
            if deliveries[i] or pickups[i]:
                first = i
                answer += (i + 1) * 2
        corrent_deliveries_cap += deliveries[i]
        corrent_pickups_cap += pickups[i]
        
        while(corrent_deliveries_cap > cap or corrent_pickups_cap > cap):
            corrent_pickups_cap -= cap
            corrent_deliveries_cap -= cap
            answer += (i + 1) * 2

    return answer