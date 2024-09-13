/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Telas;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 *
 * @author ester
 */
public class Teste extends JFrame {

    private JTable tableLivros, tableAutores, tableCategorias;
    private DefaultTableModel modelLivros, modelAutores, modelCategorias;
    private JButton btnAdd, btnEdit, btnRemove;

    public Teste() {
        setTitle("Sistema Gerenciador de Biblioteca");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel principal
        JPanel panel = new JPanel(new GridLayout(1, 3));

        // Painel para lista de livros
        modelLivros = new DefaultTableModel(new String[]{"Título", "Autor", "Categoria"}, 0);
        tableLivros = new JTable(modelLivros);
        JScrollPane scrollLivros = new JScrollPane(tableLivros);
        panel.add(createPanel("Lista de Livros", scrollLivros));

        // Painel para lista de autores
        modelAutores = new DefaultTableModel(new String[]{"Nome", "Nacionalidade"}, 0);
        tableAutores = new JTable(modelAutores);
        JScrollPane scrollAutores = new JScrollPane(tableAutores);
        panel.add(createPanel("Lista de Autores", scrollAutores));

        // Painel para lista de categorias
        modelCategorias = new DefaultTableModel(new String[]{"Categoria", "Descrição"}, 0);
        tableCategorias = new JTable(modelCategorias);
        JScrollPane scrollCategorias = new JScrollPane(tableCategorias);
        panel.add(createPanel("Lista de Categorias", scrollCategorias));

        add(panel, BorderLayout.CENTER);

        // Painel para os botões
        JPanel panelButtons = new JPanel(new FlowLayout());

        btnAdd = new JButton("Adicionar");
        btnEdit = new JButton("Editar");
        btnRemove = new JButton("Remover");

        panelButtons.add(btnAdd);
        panelButtons.add(btnEdit);
        panelButtons.add(btnRemove);

        add(panelButtons, BorderLayout.SOUTH);

        // Adiciona ações aos botões
        addListeners();
    }

    private JPanel createPanel(String title, JScrollPane scrollPane) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder(title));
        panel.add(scrollPane, BorderLayout.CENTER);
        return panel;
    }

    private void addListeners() {
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para adicionar um item (dependendo da tabela selecionada)
                JOptionPane.showMessageDialog(null, "Adicionar item!");
            }
        });

        btnEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para editar um item (dependendo da tabela selecionada)
                JOptionPane.showMessageDialog(null, "Editar item!");
            }
        });

        btnRemove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para remover um item (dependendo da tabela selecionada)
                JOptionPane.showMessageDialog(null, "Remover item!");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Teste().setVisible(true);
            }
        });
    }
}


