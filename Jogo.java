package locadoraJogo;

import java.util.ArrayList;

public class Jogo {

    private String nome;
    private String Categoria;
    private int anoLancamento;
    private boolean locado;
    private ArrayList<Jogo> jogos = new ArrayList<Jogo>();

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String categoria) {
        Categoria = categoria;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public boolean getLocado() {
        return locado;
    }

    public void setLocado(boolean locado) {
        this.locado = locado;
    }
        public ArrayList<Jogo> getJogos() {
        return jogos;
    }

    public void setJogos(ArrayList<Jogo> jogos) {
        this.jogos = jogos;
    }
     public static void adicionarjogo() {
        String nomeJogo = Util.getString("Digite o nome do jogo:\n");
        String categoriaJogo = Util.getString("Digite a categoria do jogo:\n");
        int anoLancamentoJogo = Util.getInt("Digite o ano de Lançamento do jogo:", "ERRO ao processar, Coloque apenas numeros!");
        Jogo jogo = new Jogo();
        jogo.setNome(nomeJogo);
        jogo.setCategoria(categoriaJogo);
        jogo.setAnoLancamento(anoLancamentoJogo);

        jogos.add(jogo);
        System.out.println("Jogo adicionado!");
    }

    public void deletarJogo() {
        if (!jogos.isEmpty()) {
            int delete = Util.getInt("Você deseja deletar um Jogo! \n Digite a posição do Jogo: ", "ERRO ao processar, Coloque apenas numeros!");
            jogos.remove((delete) - 1);
            System.out.println("Jogo Deletado!");
        } else {
            System.out.println("NÃO EXISTE JOGO, POR FAVOR ADICIONE. ");
        }
    }

    public Jogo lerJogos(String titulo) {
        if (!jogos.isEmpty()) {
            for (Jogo jogo : jogos) {
                if (jogo.getNome().equals(titulo)) {
                    System.out.println("--------------------------------------------------------------------------------------------");
                    System.out.println("Posição: " + (jogos.indexOf(jogo) + 1));
                    System.out.println("INFORMAÇÕES DO JOGO: ");
                    System.out.println("Nome do Jogo: " + jogo.getNome());
                    System.out.println("Categoria do Jogo: " + jogo.getCategoria());
                    System.out.println("Ano de lançamento do Jogo: " + jogo.getAnoLancamento());
                    System.out.println("--------------------------------------------------------------------------------------------");
                }else {
                    System.out.println("O NOME DO JOGO ESTÁ INCORRETO , TENTE NOVAMENTE");
                }
            }
        } else {
            System.out.println("NÃO FOI POSSÍVEL REALIZAR A LEITURA, POR FAVOR ADICIONE UM JOGO ");
        }
        return null;
    }


    public Jogo lerJogos() {
        if (!jogos.isEmpty()) {
            for (Jogo jogo : jogos) {
                System.out.println("--------------------------------------------------------------------------------------------");
                System.out.println("Posição: " + (jogos.indexOf(jogo) + 1));
                System.out.println("INFORMAÇÕES DO JOGO: ");
                System.out.println("Nome do Jogo: " + jogo.getNome());
                System.out.println("Categoria do Jogo: " + jogo.getCategoria());
                System.out.println("Ano de lançamento do Jogo: " + jogo.getAnoLancamento());
                System.out.println("--------------------------------------------------------------------------------------------");
            }
        } else {
            System.out.println("NÃO FOI POSSÍVEL REALIZAR A LEITURA, POR FAVOR ADICIONE UM JOGO ");
        }
        return null;
    }
    public static void alterarJogo() {
        if (!jogos.isEmpty()) {
            int alterarjogo1 = Util.getInt("Você deseja alterar dados do Jogo!\nPor favor, digite a posição do Jogo: ", "ERRO ao processar, Coloque apenas numeros!");
            int alterarjogo2 = Util.getInt("Selecione o que deseja alterar: \n1. Nome do Jogo:\n2. Categoria;\n3. Ano de lançamento:\n4. Não alterar nada.", "ERRO ao processar, Coloque apenas numeros!");
            switch (alterarjogo2) {
                case 1 -> {
                    String nome = Util.getString("Digite o novo nome do jogo:\n");
                    jogos.get(alterarjogo1 - 1).setNome(nome);
                }
                case 2 -> {
                    String categoria = Util.getString("Digite a nova categoria do jogo:\n");
                    jogos.get(alterarjogo1 - 1).setCategoria(categoria);
                }
                case 3 -> {
                    int anoLancamento = Util.getInt("Por favor, digite o novo ano de Lançamento:", "ERRO ao processar, Coloque apenas numeros!");
                    jogos.get(alterarjogo1 - 1).setAnoLancamento(anoLancamento);
                }
                case 4 ->
                        System.out.println("Não haverá alteração em nada, você retornará ao menu inicial!\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            }
            System.out.println("Dados Atualizados!");
        } else {
            System.out.println("NÃO FOI POSSÍVEL REALIZAR A ALTERAÇÃO, POR FAVOR ADICIONE UM JOGO");
        }
    }
}
