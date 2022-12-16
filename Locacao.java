package locadoraJogo;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

public class Locacao {
    Scanner sc = new Scanner(System.in);
    private double valor;
    private String dataInicio;
    private String dataFim;
    private boolean locado;
 
    private ArrayList<Locacao> locacaos = new ArrayList<Locacao>();

    public ArrayList<Locacao> getLocacaos() {
        return locacaos;
    } 

    public void setLocacaos(ArrayList<Locacao> locacaos) {
        this.locacaos = locacaos;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public Jogo getJogo() {
        return jogo;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;  
    }

    public boolean isLocado() {
        return locado;
    }

    public void setLocado(boolean locado) {
        this.locado = locado;
    }


    public void adicionarlocacao() throws ParseException {
        int idFuncionario = Util.getInt("Digite o Id do Funcionário: ", "ERRO ao processar, Coloque apenas numeros!");
        String locacaoNomeCliente = Util.getString("Digite o nome do cliente:\n");
        long locacaoCpfCliente = Util.getlong("Digite o Cpf do Cliente: ", "ERRO ao processar, Coloque apenas numeros!");
        String nomeJogo = Util.getString("Digite o nome do jogo:\n");


        /* DATA INÍCIO */
        Calendar c = Calendar.getInstance();
        Date data = c.getTime();
        DateFormat f = DateFormat.getDateInstance(DateFormat.FULL);
        String dataInicio = f.format(data);

        /* DIA DA DEVOLUÇÃO */
        int diadevolucao = Util.getInt("Quantos dias para a devolução:  ", "ERRO ao processar, Coloque apenas numeros!");
        Calendar d = Calendar.getInstance();
        d.add(Calendar.DATE, diadevolucao);
        Date data1 = d.getTime();
        String dataFim = f.format(data1);

        int valor1 = Util.getInt("Valor: ", "ERRO ao processar, Coloque apenas numeros!");


        Locacao locacao = new Locacao();

        locacao.funcionario.setId(idFuncionario);
        locacao.cliente.setNome(locacaoNomeCliente);
        locacao.cliente.setCpf(locacaoCpfCliente);
        locacao.jogo.setNome(nomeJogo);
        locacao.setDataInicio(dataInicio);
        locacao.setDataFim(dataFim);
        locacao.setValor(valor1);
        locacao.setLocado(true);

        locacaos.add(locacao);


    }

    public void deletarlocacao() {
        if (!locacaos.isEmpty()) {
            int deleteLocacao = Util.getInt("Você deseja deletar uma locação! \n Digite a posição da locação:", "ERRO ao processar, Coloque apenas numeros! \n");
            locacaos.remove((deleteLocacao) - 1);
            System.out.println("Locação Deletada!");
        } else {
            System.out.println("IMPOSSÍVEL DELETAR, ADICIONE UMA LOCAÇÃO. ");
        }

    }

    public Locacao lerLocacoes(String nome) {
        if (!locacaos.isEmpty()) {
            for (Locacao locacao : locacaos) {
                if (locacao.getJogo().getNome().equals(nome)) {
                    System.out.println("--------------------------------------------------------------------------------------------");
                    System.out.println("Posição: " + (locacaos.indexOf(locacao) + 1));
                    System.out.println("INFORMAÇÕES DA LOCAÇÃO: ");
                    System.out.println("Id do funcionário: " + locacao.funcionario.getId());
                    System.out.println("Nome do cliente: " + locacao.cliente.getNome());
                    System.out.println("CPF do cliente: " + locacao.cliente.getCpf());
                    System.out.println("Nome do Jogo: " + locacao.jogo.getNome());
                    System.out.println("Data da Locação: " + locacao.getDataInicio());
                    System.out.println("Data de entrega: " + locacao.getDataFim());
                    System.out.println("Valor:  " + locacao.getValor());
                    System.out.println("Locado: " + locacao.isLocado());
                } else {
                    System.out.println("O NOME DO JOGO ESTÁ INCORRETO , TENTE NOVAMENTE");
                }
            }
        } else {
            System.out.println("NÃO FOI POSSÍVEL REALIZAR A LEITURA, POR FAVOR ADICIONE LOCAÇÃO\n");
        }
        return null;
    }

    public void lerLocacoes() {
        if (!locacaos.isEmpty()) {

            for (Locacao locacao : locacaos) {
                System.out.println("--------------------------------------------------------------------------------------------");
                System.out.println("Posição: " + (locacaos.indexOf(locacao) + 1));
                System.out.println("INFORMAÇÕES DA LOCAÇÃO: ");
                System.out.println("Id do funcionário: " + locacao.funcionario.getId());
                System.out.println("Nome do cliente: " + locacao.cliente.getNome());
                System.out.println("CPF do cliente: " + locacao.cliente.getCpf());
                System.out.println("Nome do Jogo: " + locacao.jogo.getNome());
                System.out.println("Data da Locação: " + locacao.getDataInicio());
                System.out.println("Data de entrega: " + locacao.getDataFim());
                System.out.println("Valor:  " + locacao.getValor());
                System.out.println("Locado: " + locacao.isLocado());
                System.out.println("--------------------------------------------------------------------------------------------");

            }
        } else {
            System.out.println("NÃO FOI POSSÍVEL REALIZAR A LEITURA, POR FAVOR ADICIONE LOCAÇÃO\n");
        }
    }

    public void alterarLocacao() {
        if (!locacaos.isEmpty()) {
            int alterarLocacao1 = Util.getInt("Você deseja alterar dados da locação!\nPor favor, digite a posição: ", "ERRO ao processar, Coloque apenas numeros!");
            int alterarLocacao2 = Util.getInt("Selecione o que deseja alterar: \n1. ID do funcionario \n2. Nome do Cliente:\n3. CPF:\n4. Nome do Jogo;\n5. Dias para Devolução\n6.Não alterar nada", "ERRO ao processar, Coloque apenas numeros!");
            switch (alterarLocacao2) {
                case 1 -> {
                    int idFuncionario = Util.getInt("Digite o novo Id do Funcionário: ", "ERRO ao processar, Coloque apenas numeros!\n");
                    locacaos.get(alterarLocacao1 - 1).funcionario.setId(idFuncionario);
                }
                case 2 -> {
                    String nome = Util.getString("Digite o novo nome do CLiente:\n");
                    locacaos.get(alterarLocacao1 - 1).cliente.setNome(nome);
                }
                case 3 -> {
                    long cpf = Util.getlong("Digite o novo Cpf do Cliente: ", "ERRO ao processar, Coloque apenas numeros!\n");
                    locacaos.get(alterarLocacao1 - 1).cliente.setCpf(cpf);
                }
                case 4 -> {
                    String locacaoNomeJogo = Util.getString("Digite o novo nome do jogo:\n");
                    locacaos.get(alterarLocacao1 - 1).jogo.setNome(locacaoNomeJogo);

                }
                case 5 -> {
                    int data = Util.getInt("Por favor, digite quantos dias para a devolução da Locação: ", "ERRO ao processar, Coloque apenas numeros!\n");
                    Calendar a = Calendar.getInstance();
                    a.add(Calendar.DATE, data);
                    Date data2 = a.getTime();
                    DateFormat f = DateFormat.getDateInstance(DateFormat.FULL);
                    String dataFim = f.format(data2);
                    locacaos.get(alterarLocacao1 - 1).setDataFim(dataFim);

                }
                case 6 -> {
                    System.out.println("Saindo Sem alteração. ");
                }
                default -> {
                    System.out.println("OPÇÃO INCORRETA!! ");
                }
            }
            System.out.println("Dados Atualizados!");
        } else {
            System.out.println("NÃO FOI POSSÍVEL REALIZAR A ALTERAÇÃO, POR FAVOR ADICIONE LOCAÇÃO");
        }
    }
}
