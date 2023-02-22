import sys
Not_Hear_index,Not_See_index  = map(int,sys.stdin.readline().strip().split())

Not_Hear_list = [(sys.stdin.readline().strip()) for _ in range(Not_Hear_index)]
Not_See_list = [(sys.stdin.readline().strip()) for _ in range(Not_See_index)]


Song=list(set(Not_Hear_list) & set(Not_See_list))
Song.sort()
print(len(Song))
print(*Song,sep='\n')