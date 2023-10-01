a = int(input())
def F(b):
    if b%4 == 0 and b%100!=0:
        print('да')
    elif b%400 ==0:
        print('нет')
    else:
        print('нет')
F(a)