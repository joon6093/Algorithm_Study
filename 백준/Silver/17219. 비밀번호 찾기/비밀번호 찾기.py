import sys
input_index,output_index  = map(int,sys.stdin.readline().strip().split())
song = {}
for _ in range(input_index):
    address,ID  = map(str,sys.stdin.readline().strip().split())
    song[address]=ID

output_address =  [(sys.stdin.readline().strip()) for _ in range(output_index)]
for i in output_address:
    print(song[i])