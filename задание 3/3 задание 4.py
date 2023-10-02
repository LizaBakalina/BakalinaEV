a = int(input())
b = int(input())
l = int(input())
N = int(input())
def F(x,y,z,u):
    return (((u/2)-1)*x*2) + (((u/2)-1)* y * 2) + y + (2 * z)
def S(x,y,z):
    return min(x,y,z)
print(S(a,b,l))