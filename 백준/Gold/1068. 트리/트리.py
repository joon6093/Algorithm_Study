import sys
input = sys.stdin.readline

def remove_node_and_descendants(node):
    for child in graph[node]:
        remove_node_and_descendants(child)
    del graph[node]

N = int(input().strip())
parent = list(map(int, input().rstrip().split()))
remove_node = int(input().strip())
graph = {}
for i in range(N):
    graph[i] = []
for i in range(N):
    if parent[i] != -1:
        graph[parent[i]].append(i)

parent_node = parent[remove_node]  
if parent_node != -1:
    graph[parent_node].remove(remove_node)  

remove_node_and_descendants(remove_node)

leaf_node_count = 0
for node, children in graph.items():
    if  len(children) == 0:
        leaf_node_count += 1

print(leaf_node_count)
