N, r, c= map(int, input().split())
def f(n, R, C):
    if n==0:
        return ''
    k, v = map(str,(R>>n-1,C>>n-1))
    return k+v+f(n-1,R%pow(2,n-1),C%pow(2,n-1))
print(int(f(N,r,c),2))