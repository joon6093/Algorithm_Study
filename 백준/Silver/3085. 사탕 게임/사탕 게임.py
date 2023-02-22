import sys
input=sys.stdin.readline
index = int(input())
candy_list = [list(input()) for _ in range(index)]
def row_check(new_candy_list, row, col):
    max_count=0
    row_count=1
    col_count=1
    colPlus_count=1
    for i in range(index):
        if(i==0):
            row_before=new_candy_list[row][i]
            col_before=new_candy_list[i][col]
            colPlus_before=new_candy_list[i][col+1]
            continue

        if(row_before == new_candy_list[row][i]):
            row_count+=1
        else:
            row_count=1
        row_before=new_candy_list[row][i]
        if(max_count<row_count):
            max_count=row_count

        if(col_before == new_candy_list[i][col]):
            col_count+=1
        else:
            col_count=1
        col_before=new_candy_list[i][col]
        if(max_count<col_count):
            max_count=col_count

        if(colPlus_before == new_candy_list[i][col+1]):
            colPlus_count+=1
        else:
            colPlus_count=1
        colPlus_before=new_candy_list[i][col+1]
        if(max_count<colPlus_count):
            max_count=colPlus_count
    return max_count


def col_check(new_candy_list, row, col):
    max_count=0
    col_count=1
    row_count=1
    rowPlus_count=1
    for i in range(index):
        if(i==0):
            col_before=new_candy_list[i][col]
            row_before=new_candy_list[row][i]
            rowPlus_before=new_candy_list[row+1][i]
            continue

        if(col_before == new_candy_list[i][col]):
            col_count+=1
        else:
            col_count=1

        col_before=new_candy_list[i][col]
        if(max_count<col_count):
            max_count=col_count

        if(row_before == new_candy_list[row][i]):
            row_count+=1
        else:
            row_count=1
        row_before=new_candy_list[row][i]
        if(max_count<row_count):
            max_count=row_count

        if(rowPlus_before == new_candy_list[row+1][i]):
            rowPlus_count+=1
        else:
            rowPlus_count=1
        rowPlus_before=new_candy_list[row+1][i]
        if(max_count<rowPlus_count):
            max_count=rowPlus_count
    return max_count

song=0
for row in range(index):
    for col in range(index):
        if(col+1 < index):  #가로기준 스왑
            candy_list[row][col], candy_list[row][col+1] = candy_list[row][col+1], candy_list[row][col]
            row_count=row_check(candy_list,row,col)
            if(song < row_count):
                song=row_count
            candy_list[row][col], candy_list[row][col+1] = candy_list[row][col+1], candy_list[row][col]

        if(row+1 < index):  #세로기준 스왑
            candy_list[row][col], candy_list[row+1][col] = candy_list[row+1][col], candy_list[row][col]
            col_count=col_check(candy_list,row,col)
            if(song < col_count):
                song=col_count
            candy_list[row][col], candy_list[row+1][col] = candy_list[row+1][col], candy_list[row][col]

print(song)



