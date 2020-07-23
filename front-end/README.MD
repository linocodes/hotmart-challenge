## **Contextualização**

Na Hotmart as demandas internas são tão importantes quanto as externas. Aqui, cuidamos com muito carinho de todas as solicitações dos nosso troopers (do Brasil e de todo o mundo) através de uma plataforma chamada QuickOps. 

Este teste consiste na reprodução de uma das funcionalidades desta plataforma: A tela de solicitação de antecipações e reembolsos.

Para construí-la, você irá receber:

*   O layout da tela disponível no Zeplin
*   A [listagem de endpoints](#endpoints) para trazer os dados da tela


## **O desafio**

Sua tarefa consiste em montar e integrar com a API as seguintes estruturas da página:

1. Header

![Alt text](assets/images/header.jpeg?raw=true "Header")

*   Exibir dados da solicitação
    *   Nome do Solicitante
    *   Email do Solicitante
    *   Justificativa
    *   Finalidade
    *   Centro de Custo
    *   Projeto
    *   Data
    *   Quantidade de pessoas
    *   Flag - café da manhã
*   Permitir Atribuição de Analista

2. Timeline

![Alt text](assets/images/timeline.jpeg?raw=true "Timeline")

*   Criar uma timeline de itens
    *   Cada tipo de item deve apresentar um layout específico. \


![Alt text](assets/images/item.jpeg?raw=true "Item")
![Alt text](assets/images/item-detail.jpeg?raw=true "Item Detail")

*   Despesa: Alimentação, Viagem, etc..
    *   É editável
    *   É possível visualizar e baixar anexos

3. Rodapé

![Alt text](assets/images/rodape.jpeg?raw=true "Rodapé")


*   Ações disponíveis: Cancelar e Aprovar
*   Status: Aberto, Em Aprovação e Concluído

4. Sidebar

![Alt text](assets/images/sidebar.jpeg?raw=true "Sidebar")

*   Exibir o status da solicitação
*   Exibir a lista de moedas envolvidas (Todas as moedas que tem alguma despesa)

5. Ações

*   Baixar todos os anexos das despesas
![Alt text](assets/images/barra-acoes.jpeg?raw=true "Barra Ações")

*   Adicionar despesa
![Alt text](assets/images/despesa.jpeg?raw=true "Adicionar Despesa")
	


### **O que nós esperamos do seu desafio**

Queremos entender sua proficiência técnica, raciocínio analítico e apresentação de resultados. 

Você precisará fazer **apenas** **3 partes** à sua escolha. Se decidir fazer as 5, entenda que isso não irá adicionar vantagem em sua avaliação. Queremos ter uma clara percepção sobre como você resolve problemas e não quantos problemas você consegue resolver.

Para isso fique a vontade para incluir/alterar/remover o que sentir necessidade para atender melhor a demanda.

Mais especificamente na entrega do projeto gostaríamos de ver:



1. Documentação básica para executá-lo;
2. Código escrito da maneira mais legível possível. _Manutenção importa tanto quanto performance, muitas vezes um não precisa comprometer o outro_;
3. Uma boa estruturação do projeto;
4. Utilização das ferramentas adequadas;
5. Utilização correta da API.


### **O que nós ficaríamos felizes de ver em seu desafio**



1. Testes;
2. Análise automatizada de código (Ex.: ESLint);
3. Utilização das APIs nativas do browser;
4. Otimização do tamanho final do seu build.


### **O que nós não gostaríamos**



*   Descobrir que não foi você quem fez seu teste;
*   Não atendimento aos objetivos propostos;
*   Ver um código muito ilegível.

## 
**O que avaliaremos em seu desafio**

*   Alcance dos objetivos propostos;
*   Semântica, estrutura, legibilidade, manutenibilidade, escalabilidade do seu código e suas tomadas de decisões;
*   Organização do projeto;
*   Arquitetura da solução, utilização de design patterns adequados;
*   Performance, resiliência e tratamento de erros;


### **Pré-requisitos**

*   Utilização de Javascript "puro" ou os frameworks React ou Vue;


### **Endpoints**

* Status da API: `https://api-front-end-challenge.buildstaging.com/api/status`
* Dados do Header: `https://api-front-end-challenge.buildstaging.com/api/header`
* Dados da Timeline: `https://api-front-end-challenge.buildstaging.com/api/timeline`
* Dados da Sidebar: `https://api-front-end-challenge.buildstaging.com/api/sidebar`
