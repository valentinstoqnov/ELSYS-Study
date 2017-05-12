#include <stdio.h>
#include <stdlib.h>

// index, size, data
// [0, 0, 0, 0, 0]
// [0, -1, -2, -3, -4 ...]

struct vector_t {
int index, size;
int *data;
};

void vector_init(struct vector_t* v);
void vector_destroy(struct vector_t* v);
int vector_get_size(struct vector_t v);
int vector_resize(struct vector_t* v);
int vector_at(struct vector_t v, int index);
void vector_push_back(struct vector_t* v, int value);
int vector_pop_back(struct vector_t* v);

int main() {
	struct vector_t vector;
	vector_init(&vector);
	vector_push_back(&vector, 5);
	int i, value;
	for (i = 0; i < vector_get_size(vector); i++){
		value = vector_at(vector, i);
        	printf("%d \n", value);
    	}
	value = vector_pop_back(&vector);
    	printf("%d\n", value);
    	value = vector_at(vector, 456);
    	printf("%d\n", value);
    	vector_destroy(&vector);
    	return 0;
}

void vector_init(struct vector_t* v) {
    	v->size = 5;
    	v->index = 0;
	v->data = (int*) malloc(v->size * sizeof(int));
}

void vector_destroy(struct vector_t* v){
    	free(v->data);
    	v->size = 0;
    	v->index = 0;
}

int vector_get_size(struct vector_t v) {
    	return v.index;
}

void vector_push_back(struct vector_t* v, int value) {
	if(v->index > v->size) vector_resize(v);
     	v->data[v->index++] = value;
}

int vector_at(struct vector_t v, int index) {
	if(v.index < v.size) return v.data[index];
	return -1;
}

int vector_pop_back(struct vector_t* v) {
    	if(v->index > -1){
        	vector_resize(v);
        	return v->data[--v->index];
    	}
    	return -1;
}

int vector_resize(struct vector_t* v){
    	if(v->index == v->size) v->size *= 2;
	else 
		if(v->index < v->size / 2) v->size /= 2;
		else return -1;
    return 0;
}
