#include "singly_linked_list.c"

#include <stdio.h>
#include <stdlib.h>

void printMenu();

int main(int argc, char** argv)
{
    Node *head = NULL;
    int option;
    int element;
    printf("Jestes wewnatrz listy jednokierunkowej. Co chcesz zrobic? \n");
    for(;;)
    {
        printMenu();
        scanf("%d", &option);
        switch(option)
        {
            case 1:
                printf("Insert: ");
                scanf("%d", &element);
                insert(&head, element);
                printf("OK. \n");
                break;
            case 2:
                printf("Delete: ");
                scanf("%d", &element);
                delete(&head, element);
                printf("OK. \n");
                break;
            case 3:
                if(isEmpty(head) == 1)
                    printf("Lista jest pusta.\n");
                else
                    printf("Lista nie jest pusta.\n");
                break;
            case 4:
                printf("FindTRANS: ");
                scanf("%d", &element);
                findTrans(&head, element);
                printf("OK. \n");
                break;
            case 5:
                printf("FindMTF: ");
                scanf("%d", &element);
                findMTF(&head, element);
                printf("OK. \n");
                break;
            case 6:
                printList(head);
                break;
            case 7:
                printf("return 0. \n");
                return 0;
            default:
                printf("Bledny wybor. Sprobuj jeszcze raz\n");
        }
    }

    return -1;
}

void printMenu()
{
    printf("1 = insert, 2 = delete, 3 = isEmpty?, 4 = findTrans, \n"
           "5 = findMTF, 6 = print, 7 = exit \n");
    printf("choose: ");
}