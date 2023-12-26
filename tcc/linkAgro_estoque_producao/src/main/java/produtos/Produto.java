/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produtos;

/**
 *
 * @author Lenovo
 */
public class Produto {
    
    private static ProdutosGUI produtosgui;
    
    String produto;
    String cor_produto;
    
    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getCor_produto() {
        return cor_produto;
    }

    public void setCor_produto(String cor_produto) {
        this.cor_produto = cor_produto;
    }

    public static ProdutosGUI getProdutosgui() {
        return produtosgui;
    }

    public static void setProdutosgui(ProdutosGUI produtosgui) {
        Produto.produtosgui = produtosgui;
    }
    
    
    
    
}
