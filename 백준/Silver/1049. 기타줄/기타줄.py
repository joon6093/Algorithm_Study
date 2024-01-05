import sys
input = sys.stdin.readline

N, M = map(int, input().strip().split())
package = 1000
each = 1000
for _ in range(M):
    package_temp, each_temp = map(int, input().strip().split())
    package = min(package_temp, package)
    each = min(each_temp, each)

print(min((N//6) * package + each * (N%6) , each * N, ((N//6)+1) * package))

