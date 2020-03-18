package ivanmarkovic.algorithms.trees.binarysearchtree;


import java.util.NoSuchElementException;

public class BinarySearchTree {
	
	TreeNode root;
	int length;
	
	public BinarySearchTree() {
		this.length = 0;
	}
	
	public void put(int key) {
		this.length++;
		if(this.root == null) {
			this.root = new TreeNode(key);
		}
		else
			this.root.put(key);
	}
	
	public TreeNode get(int key) {
		if(this.root == null)
			throw new NoSuchElementException("Node with key " + key + " doesn't exists");
		else
			return this.root.get(key);
	}
	
	public void delete(int key) throws NoSuchElementException {
		TreeNode toDelete = this.get(key);
		if(this.root == toDelete) {
			if(this.root.isLeaf()) {
				this.length--;
				this.root = null;
			}
			else if(this.root.hasBothChildren()) {
				TreeNode tmp = this.root.leftChild.findMax();
				int tmpKey = tmp.key;
				this.delete(tmpKey);
				this.root.key = tmpKey;
			}
			else {
				this.length--;
				if(this.root.hasLeftChild()) {
					this.root = this.root.leftChild;
					this.root.parent = null;
				}
				else {
					this.root = this.root.rightChild;
					this.root.parent = null;
				}
			}
		}
		else {
			if(toDelete.isLeaf()) {
				this.length--;
				if(toDelete.isLeftChild()) 
					toDelete.parent.leftChild = null;
				else
					toDelete.parent.rightChild = null;
			}
			else if(toDelete.hasBothChildren()) {
				TreeNode tmp = toDelete.leftChild.findMax();
				int tmpKey = tmp.key;
				this.delete(tmpKey);
				toDelete.key = tmpKey;
			}
			else {
				this.length--;
				if(toDelete.hasLeftChild()) {
					if(toDelete.isLeftChild()) {
						toDelete.parent.leftChild = toDelete.leftChild;
						toDelete.leftChild.parent = toDelete.parent;
					}
					else {
						toDelete.parent.rightChild = toDelete.leftChild;
						toDelete.leftChild.parent = toDelete.parent;
					}
				}
				else {
					if(toDelete.isLeftChild()) {
						toDelete.parent.leftChild = toDelete.rightChild;
						toDelete.rightChild.parent = toDelete.parent;
					}
					else {
						toDelete.parent.rightChild = toDelete.rightChild;
						toDelete.rightChild.parent = toDelete.parent;
					}
				}
			}
		}
	}
	
	public boolean contains(int key) {
		if(this.root == null)
			return false;
		else
			return this.root.contains(key);
	}
	
	public int size() {
		return this.length;
	}

}

