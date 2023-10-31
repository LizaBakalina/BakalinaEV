import math
def s(x,y,z):
    p = (x+y+z)/2
    s = math.sqrt(p*(p-x)*(p-y)*(p-z))
    return s
A = []
a = int(input())
b = int(input())
c = int(input())
for i in range(1):
    print(6*s(a,b,c))
