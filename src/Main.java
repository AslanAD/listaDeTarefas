import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        ArrayList<String> tarefas = new ArrayList<>();
        ArrayList<String> historico = new ArrayList<>();
        String valor = "";
        String tarefa = "";
        int tarefaConcluida = 0;

        while (!valor.equals("4")) {
            System.out.println("\n1-Adicionar tarefas\n2-Marcar tarefas concluídas" +
                    "\n3-Listar todas as tarefas\n4-Sair");
            System.out.println("Escolha uma função:");
            valor = entrada.next();

            entrada.nextLine();

            switch (valor) {
                case "1":
                    System.out.println("Digite a nova tarefa:");
                    tarefa = entrada.nextLine();
                    tarefas.add(tarefa);
                    historico.add(tarefa); // Adiciona ao histórico de tarefas
                    System.out.println("Tarefa adicionada com sucesso!");
                    break;

                case "2":
                    if (tarefas.isEmpty()) {
                        System.out.println("Nenhuma tarefa adicionada! Por favor adicione uma tarefa.");
                        tarefa = entrada.nextLine();
                        tarefas.add(tarefa);
                        historico.add(tarefa);
                        System.out.println("Tarefa adicionada com sucesso!");
                        break;
                    }
                    System.out.println("Qual tarefa será concluída? (Digite o número da tarefa)");
                    for (int i = 0; i < tarefas.size(); i++) {
                        System.out.println((i + 1) + "- " + tarefas.get(i));
                    }

                    tarefaConcluida = -1;

                    while (tarefaConcluida < 1 || tarefaConcluida > tarefas.size()) {
                        System.out.print("Digite o número da tarefa (ou 0 para cancelar): ");
                        while (!entrada.hasNextInt()) {
                            System.out.println("Digite um número válido.");
                            entrada.next();
                        }
                        tarefaConcluida = entrada.nextInt();
                        entrada.nextLine();

                        if (tarefaConcluida == 0) {
                            System.out.println("Operação cancelada.");
                            break;
                        } else if (tarefaConcluida < 1 || tarefaConcluida > tarefas.size()) {
                            System.out.println("Número da tarefa inválido. Tente novamente.");
                        } else {
                            tarefas.remove(tarefaConcluida - 1); // Remove da lista de tarefas ativas
                            System.out.println("Tarefa marcada como concluída!");
                        }
                    }
                    break;

                case "3":
                    if (historico.isEmpty()) {
                        System.out.println("Nenhuma tarefa para listar. Por gentileza adicione uma tarefa.");
                    } else {
                        System.out.println("Listando todas as tarefas:");
                        for (int i = 0; i < historico.size(); i++) {
                            System.out.println((i + 1) + "- " + historico.get(i));
                        }
                    }
                    break;

                case "4":
                    System.out.println("Programa encerrado");
                    break;

                default:
                    System.out.println("Valor inválido! Digite um valor válido!");
                    break;
            }
        }

        entrada.close();
    }
}
