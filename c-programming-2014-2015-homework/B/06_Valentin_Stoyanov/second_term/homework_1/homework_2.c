#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#define MAX_LENGTH 100

struct stack_t {
	int size,index;
	int *data;
};

void stack_init(struct stack_t *);
void stack_push(struct stack_t * ,int);
int stack_pop(struct stack_t *);
void stack_destroy(struct stack_t *);
int stack_get_size(struct stack_t);
void reverse_polish_calculator(struct stack_t * ,char);

int main () {
	struct stack_t stack;
	stack_init(&stack);
	char string[MAX_LENGTH];
	scanf("%s",string);
	int length=0,i=0;	
	char a,b;		
	int op1=0,op2=0;
	int result;
	length = strlen(string);
	while(i < length ) {
		if ((string[i] >= '0') && (string[i] <='9')) stack_push(&stack,string[i]);
		else {
			if((string[i] == '+') || (string[i] =='-') || (string[i] == '*') || (string[i] =='/')) {
				if((stack_get_size(stack) < 2)) printf ("Error.\n");
				else {
					b = (stack_pop(&stack));
					op2 = b - '0';
					a = (stack_pop(&stack));
					op1 = a - '0';
					if(string[i] == '+') result = op1 + op2;
            				else if(string[i] == '-') result= op1 - op2;
          					else if(string[i] == '*') result = op1 * op2;
           						else if(string[i] == '/') result = op1 / op2;
					stack_push(&stack,result);
				}	
			}else printf("Letters are not allowed\n");
		}
		i++;
	}
	if(stack_get_size(stack) == 1) printf("The result is : %d\n",stack_pop(&stack));
	else printf("Error\n");
	stack_destroy(&stack);	
return 0;
}

void stack_init(struct stack_t *s) {
	s->size = MAX_LENGTH;
	s->index = 0;
	s->data = ((int*) malloc (s->size * sizeof(int)));
}

void stack_push(struct stack_t *s,int value) {
	if (s->index < s->size) s->data[s->index++] = value;
	else printf("The stack is full\n");
}

int stack_pop(struct stack_t *s) {
	if (s->index > 0) return s->data[--s->index];
	else printf("The stack is empty\n");
}

void stack_destroy(struct stack_t *s){
	free(s->data);
	s->size = 0;
	s->index = 0;
}

int stack_get_size(struct stack_t s) {
	return s.index;
}

















