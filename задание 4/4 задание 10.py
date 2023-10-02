N = int(input())
K = int(input())
fib1 = 1
fib2 = 1
f = 0
kol = 0
c = 0
A = []
B = []
while c < N:
    kol += 1
    if len(A) <= 1:
        A.append(1)
    else:
        f = fib1 + fib2
        fib1 = fib2
        fib2 = f
        A.append(f)
    if kol >= K:
        B.append(A[-1])
        c += 1
print(sum(B))