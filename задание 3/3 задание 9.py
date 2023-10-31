n = int(input())
m = int(input())
k = int(input())
def F(a,b,c):
    if c < b*a and (c%b==0 or c%a==0):
        print('Да')
    else:
        print('Нет')
F(n,m,k)
