#include <stdio.h>
#include <unistd.h>
/*
*  From directory of zad1.c:
1. gcc -o zad1 zad1.c
2. sudo chown root zad1
3. sudo chmod u+s zad1
4. ./zad1
5. rm zad1
*/

int main() {
    char *name[2] = {"bash", NULL};
    setuid(0);
    execvp("bash", name);
}
