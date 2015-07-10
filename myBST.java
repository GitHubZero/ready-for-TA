/*
 *Basic BST implementation
 *Wenliang
 */

import java.util.*;

//docs about generic version of class: https://docs.oracle.com/javase/tutorial/java/generics/types.html
public class myBST <T extends Comparable<T>>{

    //define tree node using a inner class
    private class Node<T> {
      private T data;
      private Node<T> left, right;

      public Node (T data) {
        this.data = data;
      }

      public Node (T data, Node<T> left, Node<T> right) {
        this.data = data;
        this.left = left;
        this.right = right;
      }
    }

    //Fields
    private Node<T> root;
    private Comparator<T> comparator;

    //Two constructer
    public myBST() {
      root = null;
      comparator = null;
    }

    public myBST(Comparator<T> comparator) {
      root = null;
      this.comparator = comparator;
    }

    private int compare(T x, T y) {
      if (comparator == null) {
        return x.compareTo(y);
      }else{
        return comparator.compare(x, y);
      }
    }

    //**************************************************************************
    //                    insert
    //**************************************************************************
    public void insert(T data) {
      root = insert(root, data);
    }

    private Node<T> insert(Node<T> root, T data) {
      if (root == null) {
        return new Node<T>(data);
      }
      if (compare(root.data, data) == 0) {
        return root;
      }else if (compare(root.data, data) > 0) {
        root.right = insert(root.right, data);
      }else{
        root.left = insert(root.left, data);
      }
      return root;
    }

    //**************************************************************************
    //                    search
    //**************************************************************************
    public boolean search (T data) {
      return search(root, data);
    }
    private boolean search (Node<T> root, T data) {
      if (root == null) {
        return false;
      }
      if (compare(root.data, data) == 0) {
        return true;
      }else if (compare(root.data, data) < 0) {
        return search(root.right, data);
      }else{
        return search(root.left, data);
      }
    }

    //**************************************************************************
    //                    delete
    //**************************************************************************
    public void delete(T data) {
      root = delete(root, data);
    }
    private Node<T> delete(Node<T> root, T data) {
      if (root == null) {
        throw new RuntimeException("Cannot delete");
      }
      if (compare(root.data, data) == 0) {
        if (root.left == null) {
          return root.right;
        }else if (root.right == null) {
          return root.left;
        }else{
          Node<T> cur = root;
          while (cur.left != null) {
            cur = cur.left;
          }
          root.data = cur.data;
          delete(root.left, root.data);
        }
      }else if (compare(root.data, data) < 0) {
        delete(root.right, data);
      }else{
        delete(root.left, data);
      }
      return root;
    }


    public void preOrderTraversal()
    {
        preOrderHelper(root);
    }
    private void preOrderHelper(Node<T> r)
    {
        if (r != null)
        {
            System.out.print(r+" ");
            preOrderHelper(r.left);
            preOrderHelper(r.right);
        }
    }




    public static void main(String[] args) {
      Integer[] a = {1,5,2,7,4};
      BST<Integer> bst = new BST<Integer>(new MyComp1());
      //bst.delete(1);
      for(Integer n : a) bst.insert(n);
      bst.preOrderTraversal();
      System.out.println();
    }
}

class MyComp1 implements Comparator<Integer>
{
    public int compare(Integer x, Integer y)
    {
        return y-x;
    }
}
