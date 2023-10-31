def F():
    a = int(input())
    b = 0
    while a != 0:
        n = int(input())
        if n != 0 and a < n:
            b += 1
        a = n
    print(b)
F()
