#ifndef ZAD1_LIBRARY_H
#define ZAD1_LIBRARY_H

typedef struct Node
{
    int value;
    struct Node* next;
} Node;

void insert(Node** head, int value);
void delete(Node** head, int value);
int isEmpty(Node* head);
int findTrans(Node** head, int value);
int findMTF(Node** head, int value);

void printList(Node* node);

#endif