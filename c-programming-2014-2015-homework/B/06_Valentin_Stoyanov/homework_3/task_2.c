#include <stdio.h>
int main () {
long unsigned lukas,first=2,second=1,i;
for (i=0;i<=100;i++) {
	if (i<=1) {
		if (i==0) lukas=2;
		else lukas=1;
	}else {
	lukas=first+second;
	first=second;
	second=lukas;
	}	
printf("%lu, ",lukas);
}
return 0;
}
