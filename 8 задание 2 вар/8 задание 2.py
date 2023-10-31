def s(x,y):
    s = x*y
    return s
A = []
B = []
C = []
a = int(input())
b = int(input())
c =int(input())
d = int(input())
e = int(input())
f = int(input())
for i in range(3):
    A.append(s(a,b))
for i in range(3):
    B.append(s(c,d))
for i in range(3):
    C.append(s(e,f))
print(s(a,b),s(c,d),s(e,f))

