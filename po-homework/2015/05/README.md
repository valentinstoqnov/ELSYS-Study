# Пето домашно
Масиви и функции I

## Задача 1
### Имет на файла histogram.c
Да се напише програма на С, която изкарва хистограма за даден масив. Хистограма на масив представлява колко пъти се среща дадена стойност в масива. Предполага се, че масива ще е за стойностите от 0 до N.

Пример, където range e N:

```bash
Enter range: 20
Enter length: 12
Enter array: 9 8 7 7 8 2 3 4 1 0 1 2
Histogram:
0: *
1: **
2: *
3: *
4:
5:
6:
7: **
…
N: ...
```

## Задача 2
### Име на файла rot13.c
Да се доразвие програмата от час за шифроване и дешифроване на текст чрез rot13, като може да се използват малки и големи букви. Да се напишат функции за шифроване и дешифроавне на тескт. Програмата трябва пита какво искаме да направим докато не въведем q за изход.

Ако искаме да въведем текст за ширфоране, въвеждаме “c” и след него текста за шифроване, a ако искаме да въведем текст за дешифроване, въвеждаме “d” и шифрования текст.
Пример:

```bash
Enter option: c Secret message...
…
Enter option: d BlaBla Ne60 Kriptiran0
…
Enter option: q
```

## Бонус задача
### Име на файла translator.c
Докато Сашо се прибираше след часа към тях, късметлийска гръмотевица падна до него и той започна да говори и пише странно, след като с Валери се опитахме да разберем (тайно) какво се е случило установихме, че всичко, което Сашо казва и пише е в rot13.
След като му казахме, в паниката и обърканото чувство което имаше, той изръси:  **xrrJfvuGrgveJhbLqvQfznetbeClanZjbU** което освен, че беше в rot13, беше и наобратно, а още по-фрапантното беше, че го каза и на английски.

Какво се опита да ни каже Сашо?