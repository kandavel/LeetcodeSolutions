/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

#include <bits/stdc++.h>

struct node
{
    int key;
    int val;
    node *prev;
    node *next;
};

node *newNode(int key, int val)
{
    node *temp = (node*)malloc(sizeof(node));
    
    temp->key = key;
    temp->val = val;
    temp->prev = NULL;
    temp->next = NULL;
    
    return temp;
}

node *head, *tail;
int size;
int curr;

unordered_map<int, node*> mp;

class LRUCache {
public:
    LRUCache(int capacity) ;
    
    int get(int key) ;
    
    void put(int key, int value);
};


LRUCache::LRUCache(int capacity) {
    
    head = NULL;
    tail = NULL;
    
    curr = 0;
    size = capacity;
    
    if(!mp.empty())
    mp.clear();
}

void changeVal(node *ptr, int value)
{
    if(value != -1)
    ptr->val = value;
}

void insertBeg(node *ptr)
{
    if(ptr == NULL)
    return;
    
    //insert node pointed to by ptr at the Beginning of DLL
    ptr->prev = NULL;
    ptr->next = head;
    
    if(head)
    head->prev = ptr;
    else
    tail = ptr;
    
    head = ptr;
}

void removeMid(node *ptr)
{
    if(ptr == NULL)
    return;
    
    if(ptr->prev)
        ptr->prev->next = ptr->next;
    else
        head = ptr->next;
        
    if(ptr->next)
        ptr->next->prev = ptr->prev;
    else
        tail = ptr->prev;
        
    ptr->prev = NULL;
    ptr->next = NULL;
}

void deleteEnd(void)
{
    node *toBeDeleted = tail;
    
    removeMid(tail);

    mp.erase(mp.find(toBeDeleted->key));
    delete(toBeDeleted);
}

void inCache(node *ptr, int value)
{
    changeVal(ptr, value);
    
    removeMid(ptr);
    insertBeg(ptr);
}

void replacePages(node *ptr)
{
    //Edge case 1: DLL is Empty
    if(head == NULL)
    return;
    
    deleteEnd();
    insertBeg(ptr);
}

void insertInCache(node *ptr)
{
    if(curr == size)    
    return replacePages(ptr);
    
    insertBeg(ptr);
    curr = curr+1;
}

void printDLL(node *head)
{
    while(head)
    {
        cout<<"("<<head->key<<","<<head->val<<")"<<" ";
        head = head->next;
    }
    cout<<endl;
}

void printMap(unordered_map<int, node*> mp)
{
    unordered_map<int, node*>::iterator it;
    
    for(it = mp.begin(); it!=mp.end(); it++)
    {
        cout<<"("<<it->first<<" "<<it->second->key<<" "<<it->second->val<<")";
    }
    cout<<endl;
}

int LRUCache::get(int key) {
    
    node *ptr = NULL;
    
    if(mp.find(key) != mp.end())
    ptr = mp[key];
    
    //node doesnt exist in DLL
    if(ptr == NULL)
    return -1;
    
    inCache(ptr, -1);
    
    
    // printDLL(head);
    // printMap(mp);
    
    return ptr->val;
}

void LRUCache::put(int key, int value) {
    
    node *ptr = NULL;
    
    if(mp.find(key) != mp.end())
    ptr = mp[key];
    
    //node doesnt exist in DLL
    if(ptr == NULL)
    {
        ptr = newNode(key, value);
        mp[key] = ptr;
        
        insertInCache(ptr);
    }
    else
    {
        inCache(ptr, value);
    }
    
    // printDLL(head);
    // printMap(mp);
}
