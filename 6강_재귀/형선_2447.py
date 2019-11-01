N = int(input())
matrix = [['*'] * N for i in range(N)]
def func(n, matrix, xstart=0, ystart=0):
    temp = n//3
    if temp == 0:
        return
    for x in range(n):
        for y in range(n):
            if (temp <= x  and x < temp * 2 ) and (temp <= y and y < temp * 2):
                matrix[xstart + x][ystart + y] = ' '
                continue
            if (x % (temp) == 0) and (y % (temp) ==0):
                func(temp, matrix, xstart + x, ystart + y)

func(N, matrix)
for x in range(N):
    string = ''
    for y in range(N):
        string += matrix[x][y]
    print(string)