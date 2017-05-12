#include <stdio.h>
int main () {
int fact=1,c;
for (c=1;c<=10;c+=1) {
fact=fact*c;
}
printf("%d\n",fact);
return 0; 
}
