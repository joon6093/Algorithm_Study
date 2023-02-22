import sys
index = int(sys.stdin.readline())
def star(index):
    if index == 3:
        return ['***','* *','***']

    arr = star(index//3)
    song = []

    for i in arr:
        song.append(i*3)

    for i in arr:
        song.append(i+' '*(index//3)+i)

    for i in arr:
        song.append(i*3)

    return song
song=star(index)
print('\n'.join(song))