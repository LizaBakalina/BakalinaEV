N= int(input())
def F():
    i = 2
    c = 1
    while i <=N:
        i*=2
        c +=1
        print(c-1,i//2)
F()
