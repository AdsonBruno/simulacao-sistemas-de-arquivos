# SIMULAÇÃO SISTEMAS DE ARQUIVOS COM JAVA

## Descrição
Implementação de Sistema Arquivos
Em Python, C ou Java
Descrição do trabalho:
Considere a implementação de arquivos com lista encadeada. A memória pode ser "loteada" considerando que seu menor bloco tem tamanho de 3 bytes (um caractere e um short int). A estrutura de cada bloco deve ser composta por um caractere (que representará um pedaço do arquivo) e um inteiro de 2 bytes (short int).

Para simular a memória auxiliar (disco rígido, por exemplo) em um programa, podemos usar vetores onde cada posição do vetor é estruturada da forma descrita acima. Por exemplo, podemos dizer que nossa memória com total de 96 bytes será representada por um vetor de 32 posições.

Vamos simular esta implementação utilizando um vetor que representa o disco. Cada posição do vetor terá tamanho equivalente de um bloco de 1 byte (consideraremos um tipo char) mais o espaço de 1 inteiro representando o ponteiro. Assim uma memória de 96 bytes será representada por um vetor do tipo char+inteiro (estrutura de dados) com 32 posições.

Quando um arquivo é armazenado, ele é dividido em vários blocos encadeados no disco. Cada bloco deve armazenar um pedaço do arquivo e um ponteiro indicando onde está a parte seguinte do arquivo, sendo o último bloco com ponteiro nulo indicando seu final.

Objetivo é simular a criação, leitura e exclusão de arquivos. Imagine que cada arquivo criado ou apagado seja uma palavra (conteúdo). Ao longo destas operações executadas repetidamente com arquivos/palavras diferentes, “buracos” de memória surgirão. Nem sempre esses espaços acomodam um arquivo e este precisa ser particionado.

Implemente uma solução que permita a criação, leitura e exclusão destas palavras que representam arquivos. A criação de novas palavras deve levar em conta o tamanho total de espaços livres, mesmo que não sejam contíguos. Logo, também é necessário implementar o gerenciamento de espaços livres. Use mapa de bits ou lista encadeada. Se o espaço livre é menor que a palavra, a aplicação deve apresentar uma mensagem de memória insuficiente. A leitura do aquivo/palavra deve imprimir na telao que está armazenado.

A tabela de diretório deverá ser simples, onde cada linha indica o nome do arquivo (f1, f2 etc.) o índice/endereço no vetor onde começa o arquivo.

