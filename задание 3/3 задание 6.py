a = int(input())#номер столбца 1 кл
b = int(input())#номер строки 1 кл
c = int(input())#номер столбца 2 кл
d = int(input())#номер строки 2 кл
if ((a%2 ==1 and b%2 == 1) or (a%2 == 0 and b%2 == 0)) and ((c%2 ==1 and d%2 == 1) or (c%2 == 0 and d%2 == 0)) or ((a%2 == 1 and b%2 == 0) or (a%2 == 0 and b%2 == 1)) and ((c%2 == 1 and d%2 == 0) or (c%2 == 0 and d%2 == 1)):
    print('Да')
else:
    print('Нет')
