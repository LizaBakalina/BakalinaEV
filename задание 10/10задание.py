def F(A):
    a = len(A)
    b = len(A[0])
    for i in (range(a)):
        A[i][0], A[i][b - 1] = A[i][b - 1], A[i][0]
    with open('BakalinaEV_U233_vivod.txt', 'w') as f2:
        for row in A:
            s = ' '.join(map(str,row))
            f2.write(s+'\n')
with open('BakalinaEV_U233_vvod.txt') as f1:
    m = [[int(i) for i in line.split(' ')] for line in f1]
F(m)