N = int(input())
K = int(input())
def F():
    f1 = 1
    f2 = 1
    f = 0
    k = 0
    c = 0
    A = []
    B = []
    while c < N:
        k += 1
        if len(A) <= 1:
            A.append(1)
        else:
            f = f1 + f2
            f1 = f2
            f2 = f
            A.append(f)
        if k >= K:
            B.append(A[-1])
            c += 1
    print(sum(B))
F()
