#include <stdio.h>
#include <stdlib.h>
#include "stack.h"

int main() {
    stack *stk = NULL;
    push(7, &stk);
    push(2, &stk);
    push(9, &stk);
    push(12,&stk);
    printf("%d\n",pop(&stk));
    printf("%d\n",pop(&stk));
    printf("%d\n",pop(&stk));
    printf("%d\n",pop(&stk));
    printf("%d\n",pop(&stk));
    return 0;
}