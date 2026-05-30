#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int key;
    int value;
} HashItem;

int hash(int key) {
    return (abs(key) % 10000);
}

int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
    HashItem* hashTable = (HashItem*)malloc(sizeof(HashItem) * 10000);
    
    for(int i = 0; i < 10000; i++)
        hashTable[i].key = 1000000000; // marking empty
    
    for(int i = 0; i < numsSize; i++) {
        int complement = target - nums[i];
        int h = hash(complement);
        
        while(hashTable[h].key != 1000000000) {
            if(hashTable[h].key == complement) {
                int* result = (int*)malloc(sizeof(int) * 2);
                result[0] = hashTable[h].value;
                result[1] = i;
                *returnSize = 2;
                free(hashTable);
                return result;
            }
            h = (h + 1) % 10000;
        }
        
        h = hash(nums[i]);
        
        while(hashTable[h].key != 1000000000)
            h = (h + 1) % 10000;

        hashTable[h].key = nums[i];
        hashTable[h].value = i;
    }
    
    *returnSize = 0;
    free(hashTable);
    return NULL;
}