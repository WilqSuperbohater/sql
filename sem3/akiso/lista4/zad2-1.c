#include <stdio.h>
#include <signal.h>
#include <errno.h>

void skill_handler(int signum) { printf("Bla bla bla..."); }

int main() {
   signal(9, skill_handler);
   if(errno != 0)
      printf("Ad 1: Nie mozna. Blad przy probie obslugi sygnalu 9.\n");
}
