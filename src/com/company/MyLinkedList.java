package com.company;

public class MyLinkedList implements NodeList{
    private ListItem root = null;

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if(this.root == null){
            //empty list -> new head
            this.root = newItem;
            return true;
        }

        ListItem currentItem = this.root;
        while(currentItem != null){
            int comparison = currentItem.compareTo(newItem);
            if(comparison <0){
                //new item is greater, move right
                if(currentItem.next() != null){
                    currentItem = currentItem.next();
                } else {
                    //there is no next, insert at end of list
                    currentItem.setNext(newItem).setPrevious(currentItem);
                    return true;
                }
            } else if(comparison >0){
                //new item is less, insert b4
                if(currentItem.previous() != null){
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                    newItem.setNext(currentItem).setPrevious(newItem);
                } else {
                    //node with a previous is the root
                    newItem.setNext(this.root).setPrevious(newItem);
                    this.root = newItem;
                }
                return true;
            } else {
                //equal
                System.out.println(newItem.getValue()+ " is already present");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if(item != null){
            System.out.println("Deleting item " + item.getValue());
        }
        ListItem currentItem = this.root;
        while(currentItem != null){
            int comparison = currentItem.compareTo(item);
            if(comparison == 0){
                //found the item to delete
                if(currentItem == this.root){
                    this.root = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next());
                    if(currentItem.next() != null){
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            } else if (comparison <0){
                currentItem = currentItem.next();
            } else {// comparison > 0
                //we are at an item greater than the one to be deleted
                //item is not in the list
                return false;
            }
        }
        //We have reached the end did not find
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if(root == null){
            System.out.println("The List is empty");
        } else {
            while(root != null){
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
