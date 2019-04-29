#include "singly_linked_list.h"

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int gc = 0;

void insert(Node** head, int value)
{
    Node* new = (Node*) malloc(sizeof(Node));
    new->value  = value;
    new->next = *head;
    *head = new;
}

void delete(Node **head, int value)
{
    Node* temp = *head, *prev;

    if (temp != NULL && temp->value == value)
    {
        *head = temp->next;
        free(temp);
        return;
    }

    while (temp != NULL && temp->value != value)
    {
        prev = temp;
        temp = temp->next;
    }

    if (temp == NULL) return;

    prev->next = temp->next;

    free(temp);
}

int isEmpty(Node* head)
{
    if(head == NULL)    return 1;
    else                return 0;
}

int findTrans(Node **head, int value)
{

    Node* thirdNode = NULL;
    Node* secondNode = *head;
    Node* currNode = *head;

    while(currNode != NULL && currNode->value != value) {
        thirdNode = secondNode;
        secondNode = currNode;
        currNode = currNode->next;
        gc += 2;
    }
    if(currNode != NULL) {
        if(secondNode == *head){
            if(thirdNode != NULL) {
                secondNode->next = currNode->next;
                *head = currNode;
                currNode->next = secondNode;
                gc += 3;
                return 1;
            }
            else {
                gc += 3;
                return 1;
            }
        }
        else {
            thirdNode->next = currNode;
            secondNode->next = currNode->next;
            currNode->next = secondNode;
            gc += 2;
            return 1;
        }
    }
    gc++;
    return 0;
}

int findMTF(Node **head, int value) {

    Node* temp = *head;
    Node* onHead = *head;
    Node* prev = NULL;

    gc += 2;
    if(temp != NULL && temp->value == value) {
        return 1;
    }
    while(temp != NULL && temp->value != value) {
        prev = temp;
        temp = temp->next;
        gc += 2;
    }
    gc++;
    if(temp == NULL) {
        return 0;
    }

    prev->next = temp->next;
    *head = temp;
    temp->next = onHead;
    return 1;
}

void printList(Node *node)
{
    if(isEmpty(node) == 1)
        printf("(Pod)lista jest pusta. \n");
    else
    {
        while (node != NULL)
        {
            printf("%d ", node->value);
            node = node->next;
        }
        printf("\n");
    }
}

int main() {

    int arr[100];
    Node* list1 = NULL;
    Node* list2 = NULL;
    srand(time(NULL));

    for(int i=0; i<100; i++)
        arr[i] = i;
    for(int i=0; i<100; i++) {
        int j = rand() % (i+1);
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    for(int i = 0; i < 100; i++) {
        insert(&list1, arr[i]);
        insert(&list2, arr[i]);
    }

    int max = 0;
    while(isEmpty(list1) == 0) {
        for(int i = 0; i < 100; i++)
            if(findMTF(&list1, i) == 1)
                max = i;
        delete(&list1, max);
        max = 0;
    }
    printf("Comparisons in findMTF: %d\n", gc);
    gc = 0;
    max = 0;
    while(isEmpty(list2) == 0) {
        for(int i = 0; i < 100; i++)
            if(findTrans(&list2, i) == 1)
                max = i;
        delete(&list2, max);
        max = 0;
    }
    printf("Comparisons in findTrans: %d\n", gc);


    return 0;
}
