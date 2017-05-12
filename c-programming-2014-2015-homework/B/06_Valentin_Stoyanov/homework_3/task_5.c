#include <stdio.h>
int main () {
int c;
for (c=0;c<=30000;c++) {
	if (c % 2 !=0) {
		if ((c % 3 ==0) && (c % 7 ==0)) {
	printf("%d\n",c);
		}
	} 
}
return 0;
}
