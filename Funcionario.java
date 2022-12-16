package locadoraJogo;

import java.util.ArrayList;

public class Funcionario extends Pessoa{


    private ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
    private Integer Id;
    private String cargo;

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer Id) {
        this.Id = Id;
    }

      public ArrayList<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(ArrayList<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
    
     public void contratarFuncionario() {
        int idFuncionario = Util.getInt("Digite o Id do Funcionário: ", "ERRO ao processar, Coloque apenas numeros! ");
        String cargoFuncionario = Util.getString("Digite o cargo do Funcionário: \n");
        String nomeFuncionario = Util.getString("Digite o nome do Funcionário:\n ");
        int idadeFuncionario = Util.getInt("Digite a idade do Funcionário: ", "ERRO ao processar, Coloque apenas numeros! ");
        long cpfFuncionario = Util.getlong("Digite o Cpf do Funcionário: ", "ERRO ao processar, Coloque apenas numeros! ");
        int telefoneFuncionario = Util.getInt("Digite o telefone do Funcionário: ", "ERRO ao processar, Coloque apenas numeros! ");
        String emailFuncionario = Util.getString("Digite o Email do Funcionário:\n");

        Funcionario funcionario = new Funcionario();
        funcionario.setId(idFuncionario);
        funcionario.setCargo(cargoFuncionario);
        funcionario.setNome(nomeFuncionario);
        funcionario.setIdade(idadeFuncionario);
        funcionario.setCpf(cpfFuncionario);
        funcionario.setTelefone(telefoneFuncionario);
        funcionario.setEmail(emailFuncionario);

        funcionarios.add(funcionario);
        System.out.println("Funcionário adicionado!");

    }

    public void deletarFuncionario() {
        if (!funcionarios.isEmpty()) {
            int delete = Util.getInt("Você deseja deletar um Funcionário! \n Digite a posição do Funcionario: ", "ERRO ao processar, Coloque apenas numeros!");
            funcionarios.remove((delete) - 1);
            System.out.println("Funcionário Deletado!");
        } else {
            System.out.println("NÃO EXISTE FUNCIONÁRIO, POR FAVOR ADICIONE UM FUNCIONÁRIO ");
        }
    }

    public Funcionario lerFuncionarios(Integer id) {
        if (!funcionarios.isEmpty()) {
            for (Funcionario funcionario : funcionarios) {
                if (funcionario.getId().equals(id)) {
                    System.out.println("--------------------------------------------------------------------------------------------");
                    System.out.println("Posição: " + (funcionarios.indexOf(funcionario) + 1));
                    System.out.println("INFORMAÇÕES DO FUNCIONARIOS: ");
                    System.out.println("ID: " + funcionario.getId());
                    System.out.println("Cargo: " + funcionario.getCargo());
                    System.out.println("Nome: " + funcionario.getNome());
                    System.out.println("Idade: " + funcionario.getIdade() + " ANOS ");
                    System.out.println("CPF: " + funcionario.getCpf());
                    System.out.println("Telefone: " + funcionario.getTelefone());
                    System.out.println("Email: " + funcionario.getEmail());
                }
            }
        } else {
            System.out.println("NÃO EXISTE, NENHUM FUNCIONÁRIO! ");
        }
        return null;
    }

    public Funcionario lerFuncionarios() {
        if (!funcionarios.isEmpty()) {
            for (Funcionario funcionario : funcionarios) {
                System.out.println("--------------------------------------------------------------------------------------------");
                System.out.println("Posição: " + (funcionarios.indexOf(funcionario) + 1));
                System.out.println("INFORMAÇÕES DO FUNCIONARIOS: ");
                System.out.println("ID: " + funcionario.getId());
                System.out.println("Cargo: " + funcionario.getCargo());
                System.out.println("Nome: " + funcionario.getNome());
                System.out.println("Idade: " + funcionario.getIdade() + " ANOS ");
                System.out.println("CPF: " + funcionario.getCpf());
                System.out.println("Telefone: " + funcionario.getTelefone());
                System.out.println("Email: " + funcionario.getEmail());

            }
        } else {
            System.out.println("NÃO EXISTE, NENHUM FUNCIONÁRIO! ");
        }
        return null;
    }

    public void alterarFuncionario() {
        if (!funcionarios.isEmpty()) {
            int alterarfuncionario1 = Util.getInt("Você deseja alterar dados do Funcionário!\nPor favor, digite a posição: ", "ERRO ao processar, Coloque apenas numeros!");
            int alterarfuncionario2 = Util.getInt("Selecione o que deseja alterar: \n1. ID do funcionário\n 2. Cargo do Funcionário\n3. Nome do Funcionario\n4. Idade\n5. CPF\n6. Telefone\n7. Email\n8. Não alterar nada", "ERRO ao processar, Coloque apenas numeros!");

            switch (alterarfuncionario2) {
                case 1 -> {
                    int id = Util.getInt("Digite o novo ID do Funcionário:", "ERRO ao processar, Coloque apenas numeros!");
                    funcionarios.get(alterarfuncionario1 - 1).setId(id);
                    break;
                }
                case 2 -> {
                    String cargo = Util.getString("Digite o novo cargo do Funcionário:\n");
                    funcionarios.get(alterarfuncionario1 - 1).setCargo(cargo);
                    break;
                }
                case 3 -> {
                    String nome = Util.getString("Digite o novo nome do Funcionário:\n");
                    funcionarios.get(alterarfuncionario1 - 1).setNome(nome);
                    break;
                }
                case 4 -> {
                    int idade = Util.getInt("Digite a nova idade do Funcionário: ", "ERRO ao processar, Coloque apenas numeros!");
                    funcionarios.get(alterarfuncionario1 - 1).setIdade(idade);
                    break;
                }
                case 5 -> {
                    long cpf = Util.getlong("Digite o novo Cpf do Funcionário: ", "ERRO ao processar, Coloque apenas numeros!");
                    funcionarios.get(alterarfuncionario1 - 1).setCpf(cpf);
                    break;
                }
                case 6 -> {
                    int telefone = Util.getInt("Digite o novo telefone do Funcionário: ", "ERRO ao processar, Coloque apenas numeros!");
                    funcionarios.get(alterarfuncionario1 - 1).setTelefone(telefone);
                    break;
                }
                case 7 -> {
                    String email = Util.getString("Digite o novo Email do cliente:\n");
                    funcionarios.get(alterarfuncionario1 - 1).setEmail(email);
                    break;
                }
                case 8 -> {
                    System.out.println("Não haverá alteração em nada, você retornará ao menu inicial!\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                    break;
                }
                default -> {
                    System.out.println("DIGITE UM NÚMERO CORRESPONDENTE!! ");
                }
            }
            System.out.println("Dados Atualizados!");
        } else {
            System.out.println("NÃO EXISTE NENHUM FUNCIONÁRIO, SEM POSSIBILIDADE DE ALTERAÇÃO! ");
        }
}