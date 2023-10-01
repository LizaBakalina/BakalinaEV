a = int(input())
b = int(input())
c = int(input())
def F(a,b,c):
    if a<b and a<c:
        return a
    if b<a and b<c:
        return b
    if c<a and c<b:
        return c
print(F(a,b,c))
