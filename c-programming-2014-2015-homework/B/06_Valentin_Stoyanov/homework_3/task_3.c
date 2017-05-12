#include <stdio.h>
int main () {
int c,f,s,i,i1,f1,s1;
c=0;
f=1;
s=3;
while (c<10) {
f=f+2;
s=s+2;
i=1;
i1=1;
	while ((i<=f) && (i!=f)) {
		if (f%i == 0) f1=f;
		i=i+1;
	}
	while ((i1<=s) && (i1!=s)) {
		if (s%i1 == 0) s1=s;
		i1=i1+1;
	}
	if ((f==f1) && (s==s1)) {
	printf("(%i,%i)\n",f,s);
	c=c+1;
	}
}
return 0;
}

