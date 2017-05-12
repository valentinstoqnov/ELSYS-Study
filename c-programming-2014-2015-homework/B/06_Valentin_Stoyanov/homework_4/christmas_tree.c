#include <stdio.h>
int main () {
int num,c,c1,c2;
num=4;
for (c=1;c<=2*num;c+=2) {
	for (c1=1;c1<=(num-c+2);c1+=2) {printf(" ");}
	for (c2=1;c2<=c;c2++) {
	printf("*");
	}
	printf("\n");
}
num=7;
for (c=1;c<=2*num;c+=2) {
	for (c1=1;c1<=(num-c+5);c1+=2) {printf(" ");}
	for (c2=1;c2<=c;c2++) {
	printf("*");
	}
	printf("\n");
}
num=11;
for (c=1;c<=2*num;c+=2) {
	for (c1=1;c1<=(num-c+10);c1+=2) {printf(" ");}
	for (c2=1;c2<=c;c2++) {
	printf("*");
	}
	printf("\n");
}
return 0;
}



