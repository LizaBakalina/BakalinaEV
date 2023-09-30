import math#1
x = 14.26
y=-1.22
z=3.5*10**(-2)
s = (2*math.cos(x-2/3))/(1/2 + math.sin(y)**2)*(1 +(z**2/(3-z**2/5)))
print(s)

x = -4.5
y = 0.75*10**(-4)
z = -0.845*10**2
s = (((9+(x-y)**2)**(1/3))/(x**2+y**2 +2))-math.exp(abs(x -y))*(math.tan(z))**3
print(s)

x = 0.1722
y = 6.33
z = 3.25*10**(-4)
s = 5 * math.atan(x) - 1/4*math.acos(x)*(x+3*abs(x - y)+x**2)/(abs(x-y)*z+x**2)
print(s)