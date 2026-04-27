# port-container-management-java
A Java-based port management system for registering ships and containers, with cargo loading control and capacity validation.

# 🚢 Sistema de Gerenciamento de Contêineres Portuários

Projeto desenvolvido como Avaliação Parcial 1 (AP1) da disciplina de **Programação Orientada a Objetos** — Ibmec.

## 📋 Sobre o Projeto

Um porto precisa de um sistema para controlar o carregamento de contêineres em navios. Este sistema permite cadastrar navios e contêineres, além de gerenciar o carregamento de contêineres nos navios, respeitando regras de capacidade e associação.

> Um navio pode possuir vários contêineres, mas um contêiner pode estar associado a, no máximo, um navio.

## ⚙️ Funcionalidades

1. **Cadastrar navio** — id único, nome, bandeira (país) e capacidade máxima de carga
2. **Cadastrar contêiner** — com ou sem associação a um navio
3. **Carregar contêiner em navio** — com validações de capacidade e status
4. **Buscar navio por id** — exibe todos os dados do navio e seus contêineres
5. **Listar todos os navios** — exibe dados completos de todos os navios e seus contêineres
6. **Desassociar contêiner de navio** — por meio do id do navio e código do contêiner
7. **Menu interativo em loop** — o usuário pode realizar quantas operações desejar

## 🛡️ Regras de Negócio

- Um contêiner ao ser cadastrado recebe automaticamente o status `unloaded`
- O sistema aceita apenas três tipos de contêiner: `dry`, `reefer` e `open top`
- O carregamento é impedido se o contêiner já estiver associado a um navio (`loaded`)
- O carregamento é impedido se o navio ultrapassar sua capacidade máxima de carga
- IDs de navios e códigos de contêineres são únicos no sistema

## 🗂️ Estrutura do Projeto

```

Main.java        # Classe principal com menu e lógica de interação
Navio.java       # Entidade Navio
Container.java   # Entidade Container

```

## 🚀 Como Executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/ap1-poo-ibmec.git
   ```
2. Abra o projeto no **Eclipse**
3. Execute a classe `Main.java`

## 🛠️ Tecnologias

- Java
- Eclipse IDE

## 👤 Autor

**Pedro Paulucci de Noronha**  

