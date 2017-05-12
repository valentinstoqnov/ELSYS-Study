#include<stdio.h>
#include<string.h>

#define MAX_LENGTH 100

int are_the_brackets_balanced(char string[MAX_LENGTH]) {
	int i=0,num=0,num1=0,num2=0,size=0;
	size = strlen(string);
	while(i != size) {
		if(string[i] == '}') num--;
		if(num<0) return 0;
		if(string[i] == '{') num++;
		if(string[i] == ']') num1--;
		if(num1<0) return 0;
		if(string[i] == '[') num1++;
		if(string[i] == ')') num2--;
		if(num<0) return 0;	
		if(string[i] == '(') num2++;
		i++;
	}
	if((num == 0) && (num1 == 0) && (num2 == 0)) return 1 ;
	else return 0;
}

int main () {
	char brackets[MAX_LENGTH];
	scanf("%s",brackets);
	if (are_the_brackets_balanced(brackets)) printf("Everything is OK\n");
	else printf("The brackets are not balanced\n");
return 0 ; 
}	

		
