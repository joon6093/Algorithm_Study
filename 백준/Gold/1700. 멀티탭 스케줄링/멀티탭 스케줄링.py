import sys

plug_index,use_index  = map(int,sys.stdin.readline().strip().split())
infor = list(map(int, sys.stdin.readline().strip().split()))

plug=[]
song=0
for index,name in enumerate(infor):
    if(name in plug):
        continue
    elif(len(plug)<plug_index):
        plug.append(name)
    else:
        max_check=0
        plug_check=0
        append_check=0
        for plug_index,plug_name in enumerate(plug):
            try:
                plug_find=infor.index(plug_name,index+1)
            except:
                del plug[plug_index]
                song+=1
                plug.append(name)
                append_check=1
                break
            if(max_check<plug_find):
                max_check=plug_find
                plug_check=plug_index
        if(append_check==0):
            del plug[plug_check]
            song+=1
            plug.append(name)
    
            
     
print(song)