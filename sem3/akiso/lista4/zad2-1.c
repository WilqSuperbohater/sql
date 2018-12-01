#include <stdio.h>
#include <stdlib.h>
#include <signal.h>
#include <errno.h>
#include <unistd.h>

void skill_handler(int signum) {
    printf("I am the God.");
}

int main() {
    signal(9, skill_handler);
    if(errno != 0)
        printf("Ad 1: Nie mozna. Blad przy probie obslugi sygnalu 9.\n");
}
