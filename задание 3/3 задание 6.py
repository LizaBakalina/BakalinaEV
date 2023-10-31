x = int(input())#номер столбца 1 кл
y = int(input())#номер строки 1 кл
z = int(input())#номер столбца 2 кл
g = int(input())#номер строки 2 кл
def F(a,b,c,d):
    if ((a % 2 == 1 and b % 2 == 1) or (a % 2 == 0 and b % 2 == 0)) and (
            (c % 2 == 1 and d % 2 == 1) or (c % 2 == 0 and d % 2 == 0)) or (
            (a % 2 == 1 and b % 2 == 0) or (a % 2 == 0 and b % 2 == 1)) and (
            (c % 2 == 1 and d % 2 == 0) or (c % 2 == 0 and d % 2 == 1)):
        print('Да')
    else:
        print('Нет')
F(x,y,z,g)
