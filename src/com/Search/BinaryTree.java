package com.Search;
import java.util.Random;

/**
有序二叉树，已经排序好了的二叉树
root节点不是最小值，是"中间值"
左树小于右树

 */

public class BinaryTree {
    class Node{
        private int data;
        private Node leftChild;
        private Node rightChild;

        public Node(int data){
            this.data = data;
        }

        public void add(int data){
            if(this.data > data){
                if(this.leftChild == null){
                    this.leftChild = new Node(data);
                }else{
                    leftChild.add(data);
                }
            }else {
                if(this.rightChild == null){
                    this.rightChild = new Node(data);
                }else{
                    rightChild.add(data);
                }
            }
        }

        public boolean find(int data){
            System.out.println("Finding" + this.data);
            if(data == this.data){
                return true;
            }else if(data > this.data){
                if(this.rightChild == null){
                    return false;
                }
                return rightChild.find(data);
            }else if(data < this.data){
                if(this.leftChild == null){
                    return false;
                }
                return leftChild.find(data);
            }

            return false;
        }

        public void printNodeByPreFix(){
            System.out.println("Pre fix print: ");
            System.out.println(this.data+",");
            if(this.leftChild != null){
                this.leftChild.printNodeByPreFix();
            }
            if(this.rightChild != null){
                this.rightChild.printNodeByPreFix();
            }
        }

       public void printNodeByMidFix(){
            System.out.println("Mid fix print: ");
            if(this.leftChild != null){
                this.leftChild.printNodeByMidFix();
            }
            System.out.println(this.data+",");
            if(this.rightChild != null){
                this.rightChild.printNodeByMidFix();
            }
        }

        public void printNodeByPostFix(){
            System.out.println("Post fix print: ");
            if(this.leftChild != null){
                this.leftChild.printNodeByPostFix();
            }
            if(this.rightChild != null){
                this.rightChild.printNodeByPostFix();
            }
            System.out.println(this.data+",");
        }
    }



    public Node find(Node root, int key){
        Node current = root;
        while(current != null){
            if(current.data > key){
                current = current.leftChild;
            }else if (current.data < key){
                current = current.rightChild;
            }else if(current.data == key){
                return current;
            }
        }
        return null;
    }

    private Node root;

    private void add(int data){
        if(root != null){
            root.add(data);
        }else{
            // create the new root node
            root = new Node(data);
        }
    }

    private void print(int type){
        switch (type){
            case 1:
                root.printNodeByPreFix();
                break;
            case 2:
                root.printNodeByMidFix();
                break;
            case 3:
                root.printNodeByPostFix();
                break;
            default:
                System.out.println("Wrong input, 1 for pre, 2 for mid, 3 for post");
        }
    }

    private boolean find(int data){
        return root.find(data);
    }

    public static void main(String[] args) {
        BinaryTree root = new BinaryTree();

        int[] intArray = new int[50];
        for(int i = 0; i < intArray.length; i++){
            int temp = new Random().nextInt(100);
            intArray[i] = temp;
            root.add(temp);
        }
        System.out.println("要查找的数组元素是：" + intArray[20]);
        root.find(intArray[20]);
        root.print(2);
    }

}
