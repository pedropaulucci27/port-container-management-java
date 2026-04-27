package ap1;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Navio> listaNavios = new ArrayList<Navio>();
	static ArrayList<Container> listaContainers = new ArrayList<Container>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int opcao;
		do {
			
			System.out.println("### MENU ###");
			System.out.println("1- Cadastrar navio no porto");
			System.out.println("2- Carregar conteiner no navio");
			System.out.println("3- Exibir navio específico e containers");
			System.out.println("4- Exibir todos navios e seus conteiners");
			System.out.println("5- Remover conteiner de navio");
			System.out.println("6- cadastrar container sem navio");
			System.out.println("0- Sair do menu");
			System.out.println("Opção: ");
			opcao = sc.nextInt();
			sc.nextLine();
			
			switch (opcao) {
			case 1 -> cadastrarNavio();
			case 2 -> cadastrarContainer();
			case 3 -> exibirNavio();
			case 4 -> exibirNavios();
			case 5 -> removerContainer();
			case 6 -> cadastrarContainerSemNavio();
			case 0 -> System.out.println("Saindo do menu...");
			default -> System.out.println("Opção inválida");
			
			}
		} while (opcao != 0);
	}

	static void cadastrarNavio() {
		String nome, bandeira;
		int id;
		double capacidade;
		
		System.out.println("### MENU NAVIO ###");
		Navio n = new Navio();
		
		System.out.println("Nome: ");
		nome = sc.nextLine();
		n.setNome(nome);
		System.out.println("Bandeira:");
		bandeira = sc.nextLine();
		n.setBandeira(bandeira);
		System.out.println("id: ");
		id = sc.nextInt();
		sc.nextLine();
		for (Navio navio : listaNavios) {
			if (id == navio.getId()) {
				System.out.println("Outro navio já possui esse id!");
				return;
			}
		}
		
		n.setId(id);
		System.out.println("capacidade: ");
		capacidade = sc.nextDouble();
		sc.nextLine();
		n.setCapacidade(capacidade);
		listaNavios.add(n);
		
	}
	static void cadastrarContainer() {
		if (listaContainers.isEmpty()) {
			System.out.println("Nenhum container cadastrado no porto!");
			return;
		}
		if (listaNavios.isEmpty()) {
			System.out.println("A lista de navios está vazia!");
			return;
		}
		
		System.out.println("### CARREGAR CONTAINER ###");
		System.out.println("Containers disponíveis no porto:");
		boolean temUnloaded = false;
		for (Container c : listaContainers) {
			if (c.getStatus().equals("unloaded")) {
				System.out.println(c.getId());
				temUnloaded = true;
			}
		}
		if (!temUnloaded) {
			System.out.println("Todos os containers já estão carregados em um navio!");
			return;
		}
		
		System.out.println("Escolha um container pelo id:");
		String idC = sc.nextLine();
		Container containerEscolhido = null;
		for (Container c : listaContainers) {
			if (c.getId().equals(idC)) {
				containerEscolhido = c;
			}
		}
		if (containerEscolhido == null) {
			System.out.println("Container não encontrado!");
			return;
		}
		if (containerEscolhido.getStatus().equals("loaded")) {
			System.out.println("Container já está carregado em um navio!");
			return;
		}
		
		for (Navio navio : listaNavios) {
			System.out.println(navio.getId());
		}
		System.out.println("Escolha um navio pelo id:");
		int idN = sc.nextInt();
		sc.nextLine();
		Navio navioEscolhido = null;
		for (Navio navio : listaNavios) {
			if (navio.getId() == idN) {
				navioEscolhido = navio;
			}
		}
		if (navioEscolhido == null) {
			System.out.println("Navio não encontrado!");
			return;
		}
		if (containerEscolhido.getPeso() > navioEscolhido.getCapacidade()) {
			System.out.println("Container pesado demais para o navio!");
			return;
		}
		
		navioEscolhido.addContainer(containerEscolhido);
		containerEscolhido.setNavio(navioEscolhido);
		navioEscolhido.setCapacidade(navioEscolhido.getCapacidade() - containerEscolhido.getPeso());
		containerEscolhido.setStatus("loaded");
		System.out.println("Container carregado com sucesso!");
	}
	static void exibirNavio() {
		if (listaNavios.isEmpty()) {
			System.out.println("Lista de navios está vazia!");
			return;
		}
		else {
			int idN;
			for (Navio navio : listaNavios) {
				System.out.println(navio.getId());
			}
			System.out.println("Escolha um navio pelo id");
			idN = sc.nextInt();
			sc.nextLine();
			Navio navioEscolhido = null;
			for (Navio navio : listaNavios) {
				if (navio.getId() == idN) {
					navioEscolhido = navio;
				}
			}
			if (navioEscolhido == null) {
				System.out.println("Navio não encontrado!");
				return;
			}
			
			System.out.println(navioEscolhido);
		}
}
	static void exibirNavios() {
		if (listaNavios.isEmpty()) {
			System.out.println("Lista de navios vazia!");
			return;
			
		}
		else {
	for (Navio n : listaNavios) {
		System.out.println(n);
		for (Container c : n.getListaContainers()) {
			System.out.println(c);
		}
	}
		}
}
	static void removerContainer() {
	if (listaNavios.isEmpty() || listaContainers.isEmpty()) {
		System.out.println("Alguma das listas está vazia!");
		return;
	}
	else {
		int idN;
		for (Navio navio : listaNavios) {
			System.out.println(navio.getId());
		}
		System.out.println("Escolha um navio pelo id");
		idN = sc.nextInt();
		sc.nextLine();
		Navio navioEscolhido = null;
		for (Navio navio : listaNavios) {
			if (navio.getId() == idN) {
				navioEscolhido = navio;
			}
		}
		if (navioEscolhido == null) {
			System.out.println("Navio não encontrado!");
			return;
		}
		
		String idC;
		for (Container c : navioEscolhido.getListaContainers()) {
			System.out.println(c.getId());
		}
		System.out.println("Escolha um container pelo id");
		idC = sc.nextLine();
		Container containerEscolhido = null;
		for (Container c : listaContainers) {
			if (c.getId().equals(idC)) {
				containerEscolhido = c;
			}
		}
		if (containerEscolhido == null) {
			System.out.println("Container não encontrado!");
			return;
		}
		
		navioEscolhido.removerContainer(containerEscolhido);
		containerEscolhido.setNavio(null);
		navioEscolhido.setCapacidade(navioEscolhido.getCapacidade() + containerEscolhido.getPeso());
		containerEscolhido.setStatus("unloaded");
		
	
	}
	}
	
	static void cadastrarContainerSemNavio() {
		
		String id, tipo, status;
		double peso;
		
		System.out.println("### MENU CONTAINER ###");
		System.out.println("id: ");
		id = sc.nextLine();
		for (Container container : listaContainers) {
			if (container.getId().equals(id)) {
				System.out.println("container já cadastrado!");
				return;
			}
		}
		Container container = new Container();
		container.setId(id);
		
		System.out.println("Tipo: ");
		tipo = sc.nextLine();
		if (tipo.equalsIgnoreCase("dry") || tipo.equalsIgnoreCase("reefer") || tipo.equalsIgnoreCase("open top")) {
			container.setTipo(tipo);
		}
		else {
			System.out.println("Tipo inválido!");
			return;
		}
		
		System.out.println("Peso: ");
		peso = sc.nextDouble();
		sc.nextLine();
		container.setPeso(peso);
		container.setStatus("unloaded");
		listaContainers.add(container);
		
		
	}
}

