def F():
    x = int(input())
    a = []
    b = []
    c = []
    for i in range(x):
        a.append(int(input()))
    for i in a:
        if i>0:
            b.append(i)
        else:
            c.append(i)
    print(a,b,c)
F()
