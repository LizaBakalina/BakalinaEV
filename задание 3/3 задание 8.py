a = int(input())
b = int(input())
c = int(input())
def F(x,y,z):
    if x == y ==z:
        print(3)
    if x == y or y == z or z == x:
        print(2)
    else:
        print(0)
F(a,b,c)
