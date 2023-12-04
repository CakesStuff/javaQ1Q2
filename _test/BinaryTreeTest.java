package _test;
import gui.GUI;
import baeume.BinaryTree;
import baeume.TreeViewer;


public class BinaryTreeTest {
	public BinaryTree<Integer> suchbaum;
	
	public BinaryTreeTest(){
        suchbaum = new BinaryTree<>(59);
        BinaryTree<Integer> b4= new BinaryTree<>(4);
        BinaryTree<Integer> b34 = new BinaryTree<>(34);
        BinaryTree<Integer> b16 = new BinaryTree<>(16);
        BinaryTree<Integer> b7= new BinaryTree<>(7);
        BinaryTree<Integer> b6 = new BinaryTree<>(6);
        BinaryTree<Integer> b12 = new BinaryTree<>(12);
        BinaryTree<Integer> b18= new BinaryTree<>(18);
        BinaryTree<Integer> b17= new BinaryTree<>(17);
        BinaryTree<Integer> b53 = new BinaryTree<>(53);
        BinaryTree<Integer> b45 = new BinaryTree<>(45);
        BinaryTree<Integer> b78 = new BinaryTree<>(78);
        BinaryTree<Integer> b62 = new BinaryTree<>(62);
        BinaryTree<Integer> b61= new BinaryTree<>(61);
        BinaryTree<Integer> b71 = new BinaryTree<>(71);
        BinaryTree<Integer> b73 = new BinaryTree<>(73);
        
        suchbaum.setLeftTree(b4);
        b4.setRightTree(b34);
        b7.setLeftTree(b6);
        b7.setRightTree(b12);
        b16.setRightTree(b18);
        b18.setLeftTree(b17);
        b16.setLeftTree(b7);
        b34.setLeftTree(b16);
        b34.setRightTree(b53);
        b53.setLeftTree(b45);
        suchbaum.setRightTree(b78);
        b78.setLeftTree(b62);
        b62.setLeftTree(b61);
        b62.setRightTree(b71);
        b71.setRightTree(b73);
        TreeViewer.showTree(suchbaum, 600, 400);
	}
	
	// Rahmenmethode
	public int summe(){
		return summe(suchbaum);
	}
	

	private int summe(BinaryTree<Integer> pTree) {
		if(pTree == null || pTree.isEmpty())return 0;
		return pTree.getContent() + summe(pTree.getLeftTree()) + summe(pTree.getRightTree());
	}

    public int gibTiefe(BinaryTree pBaum) {
        if(pBaum == null || pBaum.isEmpty())return 0;
        return (((pBaum.getLeftTree() != null && !pBaum.getLeftTree().isEmpty()) || (pBaum.getRightTree() != null && !pBaum.getRightTree().isEmpty())) ? 1 : 0) + Math.max(gibTiefe(pBaum.getLeftTree()), gibTiefe(pBaum.getRightTree()));
    }

	public static void main(String[] args) {
		new GUI(new BinaryTreeTest());
	}
}
