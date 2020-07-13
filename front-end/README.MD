## Contextualização

Na Hotmart as demandas internas são tão importantes quanto as externas. Aqui, cuidamos com muito carinho de todas as solicitações dos nosso troopers (do Brasil e de todo o mundo) através de uma plataforma chamada QuickOps. 

Este teste consiste na reprodução de uma das funcionalidades desta plataforma: A tela de solicitação de antecipações e reembolsos.

Para construí-la, você irá receber:
- O layout da tela disponível no Zeplin
- A listagem de endpoints para trazer os dados da tela


## O desafio

Sua tarefa consiste em:

- Criar um Crud(create, read, update, delete) de produtos.
- Criar uma API de produtos e disponibilizar as operações de crud (list, find, delete, update, insert).
- Criar um serviço para buscar os produtos ordenados pelo ranqueamento pelo nome e pela categoria.
- Dados de cada produto = {identificador, nome, descrição, data de criação, score}
- Informação geral = {dataAtual, termo pesquisado}
- Todos os serviços devem ser auditados.

## Observações:
-   Para buscar a quantidade de notícias de uma determinada categoria você pode utilizar a api https://newsapi.org/ . As notícias podem ser (D-1), ou seja, do dia anterior a data corrente do sistema.
Criar o mapeamento das entidades para atender ao cenário criado.
Crie uma carga inicial para as entidades.
	
## O que nós esperamos do seu teste
- Queremos entender sua proficiência técnica, raciocínio analítico e apresentação de resultados. 

- Você não precisa necessariamente fazer tudo que foi proposto porém, queremos ter uma clara percepção sobre como você resolve problemas.

- Para isso fique a vontade para incluir/alterar/remover Entidades, atributos nas entidades existem, tecnologias, jobs, e o que mais sentir necessidade para atender melhor a demanda.

## Mais especificamente na entrega do projeto gostaríamos de ver:

- Documentação.
- Utilização adequada das bibliotecas.
- Código escrito da maneira mais semântica possível, legibilidade importa tanto quanto performance, muitas vezes um não precisa comprometer o outro.
- Desacoplamento e uma clara Hierarquia entre componentes do sistema.
- Testes automatizados.
- O que nós ficaríamos felizes de ver em seu teste
- Tolerância a falha, na chamada da lib externa é possível implementar uma tolerância para deixar o serviço mais robusto.
- Cache - pesquise alguma biblioteca de cache para tornar a busca mais rápida
- Suporte a paginação na listagem dos produtos
- Conteinerização do projeto - Docker
- Estratégia para evitar o consumo excessivo da api de notícias.
- Testes automatizados além do unitário.
- Utilização de ferramenta para versionamento dos scripts de carga
- Arquitetura da solução, utilização de design patterns adequados e orientação a objetos
- Colocar segurança nos endpoints que persistem dados. (Pode usar usuário/senha em memória)


## O que nós não gostaríamos
- Descobrir que não foi você quem fez seu teste
- Não atendimento aos objetivos propostos.
- Ver um código muito ilegível.
- Não ter documentação com instruções de como rodar o seu código.
- O que avaliaremos de seu teste
- Alcance dos objetivos propostos.
- Semântica, estrutura, legibilidade, manutenibilidade, escalabilidade do seu código e suas tomadas de decisões.
- Organização do projeto.
- Arquitetura da solução, utilização de design patterns adequados e orientação a objetos
- Performance, resiliência e tratamento de erros.
- Documentação da API.
- Modelagem das entidades.


# Pré-requisitos
- Utilização da linguagem Java/Kotlin.
- Não utilizar ferramentas e ou banco de dados que possuem licença comercial.
- Todas tabelas devem ter no mínimo 100 registros.
