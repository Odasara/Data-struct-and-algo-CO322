//E/17/153 - KARUNACHANDRA R.H.I.O.

public class AVLTree{

    public class Node{
        int key;
        int height;
        Node left;
        Node right;

        Node(int key){
            this.key = key;
        }
    }

    private Node root;
    //define the AVL tree
    private Node mostLeftChild(Node node){
        Node current = node;
        //loop down to find the leftmost leaf
        while (current.left != null){
            current= current.left;
        }
        return current;
    }

    private void updateHeight(Node n){
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    private int height(Node n){
        return n == null? -1 : n.height;
    }

    public int getBalance(Node n){
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }

    //Balance an AVL Tree
    private Node rotateRight(Node y){
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    private Node rotateLeft(Node y){
        Node x = y.right;
        Node z = x.left;
        x.left = y;
        y.right = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }
//keep the AVL Tree balanced after any change in its nodes
    private Node rebalance(Node z){
        updateHeight(z);
        int balance = getBalance(z);
        if(balance > 1){
            if(height(z.right.right) > height(z.right.left)){
                z = rotateLeft(z);
            }else{
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }    
        }else if (balance < -1){
            if(height(z.left.left) > height(z.left.right)){
                z = rotateRight(z);
            }else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
  
    }

//Insert a Node
    private Node insert(Node node, int key){
        if(node == null){
            return new Node(key);
        } else if (node.key > key){
            node.left = insert(node.left, key);
        } else if (node.key < key){
            node.right = insert(node.right, key);
        } else {
            throw new RuntimeException("duplicate Key!");
        }
        return rebalance(node);
    }

    //Delete Node
    private Node delete(Node node, int key){
        if ( node == null) {
            return node;
        } else if(node.key > key){
            node.left = delete(node.left, key);
        } else if(node.key < key){
            node.right = delete(node.right, key);
        }else {
            if(node.left == null || node.right == null){
                node = (node.left == null) ? node.right : node.left;
            }else{
                Node mostLeftChild = mostLeftChild(node.right);
                node.key = mostLeftChild.key;
                node.right = delete(node.right, node.key);
            }
        }
        if(node != null){
            node = rebalance(node);
        }
        return node;
    }

    //search a node
    public Node find(int key){
        Node current = root;
        while (current != null){
            if(current.key == key){
                break;
            }
            current = current.key < key ? current.right : current.left;
        }
        return current;
    }

    //Part 2
    void preOrder(Node node){
        if (node != null){
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    private void inOrder(Node node){
        if(node != null){
            inOrder(node.left);
            System.out.print(node.key+ " ");
            inOrder(node.right);
        }
    }

    void postOrder(Node node){
        if (node!= null){
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.key+" ");
        }
        
    }










//main method

    public static void main(String[] arg){

        AVLTree tree = new AVLTree();

        /*Constructing tree given in the above figure*/
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);

        System.out.println("Preorder traversal" + " of constructed tree is : ");
        tree.preOrder(tree.root);

        System.out.println('\n' + "Inorder traversal" + " of costructed tree is : ");
        tree.inOrder(tree.root);

        System.out.println('\n' + "Postorder traversal" + " of constructed tree is : ");
        tree.postOrder(tree.root);
    }
}

