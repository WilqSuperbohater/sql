#include <stdio.h>
#include <signal.h>
#include <unistd.h>

int handled = 0;

void handler(int n) {
   if( n == 2) {
      for(int i = 1; i <= 500000; i++)
         printf("I have handled %d signals for now. Trying to handla another one!\n", handled);
      handled++;
   }
}

int main() {
   signal(2, handler);
   for(int i = 1; i <= 1000000; i++)
      printf("%d\n", i);
   printf("handled: %d\n", handled);
   return 0;
}
