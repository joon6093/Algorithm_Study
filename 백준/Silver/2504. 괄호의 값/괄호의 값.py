import sys
bracket=sys.stdin.readline()
stack=[]
num=1
song=0
for i,v in enumerate(bracket):
    if(v == '('):
        stack.append('(')
        num*=2
    elif(v== '['):
        stack.append('[')
        num*=3

    elif(v== ')'):
        if(len(stack)!=0):
            if(stack[-1]=='['):
                song=0
                break
        else:
            song=0
            break
        if(bracket[i-1]=='('):
            song+=num
        stack.pop()
        num = num // 2

    elif(v== ']'):
        if(len(stack)!=0):
            if(stack[-1]=='('):
                song=0
                break
        else:
            song=0
            break
        if(bracket[i-1]=='['):
            song+=num
        stack.pop()
        num = num // 3
if(len(stack)!=0):
    song=0
print(song)