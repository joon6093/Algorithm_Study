import sys
def find_parent(parent, x):
    if parent[x] != x:
        parent[x] = find_parent(parent, parent[x])
    return parent[x]

def union_parent(parent, a, b):
    a = find_parent(parent, a)
    b = find_parent(parent, b)
    if a != b:
        parent[b] = a
        count[a]+=count[b]
    print(count[a])
    
test_index = int(sys.stdin.readline())
for _ in range(test_index):
    index = int(sys.stdin.readline())
    parent = {}
    count={}
    for i in range(index):
        friend1,friend2  = map(str,sys.stdin.readline().strip().split())
        if(friend1 not in parent):
            parent[friend1] = friend1
            count[friend1] = 1
        if(friend2 not in parent):
            parent[friend2] = friend2
            count[friend2] = 1
        union_parent(parent, friend1, friend2)
        


