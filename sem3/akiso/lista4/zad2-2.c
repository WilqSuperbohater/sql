#include <stdio.h>
#include <errno.h>
#include <signal.h>

int main() {
   kill(1, 9);
   if(errno == 0)
      printf("Ad 2: Udalo sie wyslac sygnal 9 do procesu init.\n");
   else
      printf("Ad 2: Nie udalo sie wyslac sygnalu 9 do procesu init.\n");
}
