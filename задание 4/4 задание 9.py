N = int(input())-2
def F():
    a = b = 1
    print(a,b,end = ' ')
    for i in range(2,N):
        a,b = b, a +b
        print(b,end = ' ')
F()
