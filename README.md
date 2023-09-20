# Instruções para a execução da API
Como sugestão, essa API poderá ser executada atráves de uma imagem docker ou através da 
execução direta do projeto em um servidor de aplicação (IDE / SpringBoot).

### Docker
Foi disponibilizado no diretório raiz o arquivo Dockerfile, com o intuito de facilitar a execução do projeto para a devida avaliação.

* Dockerfile\
Para a criação do container a partir do arquivo em questão, deverão ser executados
os seguintes passos:

  * No diretório onde se localiza o arquivo Dockerfile, iniciar o prompt de comando e executar todo o conteúdo entre aspas:
    *  "docker build -t labseq ."
    *  "docker run --name docker-labseq -p 8080:8080 labseq"
    
### Swagger 
Após a inicialização do container docker, a URL para ter acesso ao swagger é: http://localhost:8080/swagger-ui/index.html


### Testes Unitários
Foram desenvolvidos os seguintes testes unitários:
* Para garantir que a performance durante o cálculo era a esperada;
* Para garantir que apenas numeros inteiros não negativos poderiam ser usados como o índice fornecido. 
