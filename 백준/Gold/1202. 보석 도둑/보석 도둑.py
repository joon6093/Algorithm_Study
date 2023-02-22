import sys
import bisect
import heapq

jewel_index,bag_index  = map(int,sys.stdin.readline().strip().split())
jewel_infor = [list(map(int,sys.stdin.readline().strip().split())) for _ in range(jewel_index)]
bag_infor = [int(sys.stdin.readline()) for _ in range(bag_index)] 

jewel_infor = sorted(jewel_infor, key=lambda x : x[0])
bag_infor.sort()

song =0
index =0
bag_list=[]
for i in range(bag_index):
    while(index<jewel_index and bag_infor[i]>=jewel_infor[index][0]):
        heapq.heappush(bag_list,-jewel_infor[index][1])
        index += 1
    if(bag_list):
        song+=heapq.heappop(bag_list)
    
print((-song))