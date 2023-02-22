import sys
while(True):
    try:
        song=0
        index = input().strip()
        for i in range(1,len(index)+1):
            comp_index=(str((int(index))*i)).zfill(len(index))
            if comp_index not in (index*2):
                song=1
                break
        if song:
            print(index,"is not cyclic")
        else:
            print(index,"is cyclic")
    except:
        break
