a = int(input())
b = int(input())
def F(x,y):
    i = 1
    while x < y:
        x = x * 1.1
        i += 1
        print(i)
F(a,b)
