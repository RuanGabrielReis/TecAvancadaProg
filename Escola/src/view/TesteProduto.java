package view;

import model.Produto;

public class TesteProduto {

	public static void main(String[] args) {
		Produto produto = new Produto("Manga",8,28);
		
		System.out.println(produto.toString());
	}

}
