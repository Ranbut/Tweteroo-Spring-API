# Tweteroo-Spring-API

# Descrição
Projeto da Driven Education

Seu primeiro projeto Spring será a construção da API do conhecido **Tweteroo**, um clone do Twitter, que foi implementado no módulo de back-end

<p float="left">
  <img src="https://raw.githubusercontent.com/Ranbut/Tweteroo-Spring-API/main/screenshots/Print1.png" width="450" />
  <img src="https://raw.githubusercontent.com/Ranbut/Tweteroo-Spring-API/main/screenshots/Print2.png" width="450" /> 
</p>

Neste projeto **você NÃO DESENVOLVERÁ** o front-end do projeto. Ele já está pronto e disponível abaixo. No entanto, note que o projeto não está escrito em React e sim no formato web tradicional. Para fazer ele funcionar em desenvolvimento, basta usar o *Live Server ou abrir diretamente o arquivo index.html*:

[tweteroo-front-api-spring.zip](https://github.com/Ranbut/Tweteroo-Spring-API/raw/main/tweteroo-front-api-spring.zip)
# Requisitos

- Geral
    - [X]  A porta utilizada pelo seu servidor deve ser a 8080 (Porta padrão do Spring)
    - [x]  Versionamento usando Git é obrigatório, crie um **repositório público** no seu perfil do GitHub
    - [x]  Faça commits a cada funcionalidade implementada
- Armazenamento de dados
    - [x]  Para persistir os dados (usuários e tweets), utilize variáveis globais em memória
    - [x]  O formato de um **usuário** deve ser:
        
        ```jsx
        {
        	username: 'bobesponja', 
        	avatar: "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info" 
        }
        ```
        
    - [x]  O formato de um **tweet** deve ser:
        
        ```jsx
        {
        	username: "bobesponja",
        	avatar: "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info", 
          text: "eu amo o hub"
        }
        ```
        
- **POST** `/sign-up`
    - [x]  Deve receber (pelo body da request), um parâmetro **username** e um **avatar**, contendo o nome do username do usuário e a sua foto de avatar:
        
        ```jsx
        {
            username: "bobesponja",
        		avatar: "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info"
        }
        ```
        
    - [x]  Por fim, retornar a mensagem `“OK”`
- **POST** `/tweets`
    - [x]  Deve receber (pelo body da request), os parâmetros `username` e `tweet`:
        
        ```jsx
        {
        	username: "bobesponja",
          tweet: "eu amo o hub"
        }
        ```
        
    - [x]  Salvar esse tweet num array de tweets do servidor
    - [x]  Por fim, retornar a mensagem `“OK”`
- **GET** `/tweets` com paginação
    - [x]  Retornar os 5 últimos tweets publicados
    - [x]  Esse endpoint deverá receber a página identificada via query string (`?page=1`).
    - [x]  Deve retornar corretamente os tweets da “página” (`page`) atual, esse endpoint também será chamado ao clicar no botão “**Carregar mais**” (isso já foi feito no front-end). A primeira página corresponde aos últimos 5 tweets, a segunda do 6 ao 10, a terceira do 11 ao 15, etc…
        
        ```jsx
        [
        	{
        		username: "bobesponja",
        		avatar: "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info",
        		tweet: "eu amo o hub"
        	}
        ]
        ```
        
- **GET** `/tweets/USERNAME`
    - [x]  Retornar todos os tweets publicados do usuario recebido por parâmetro de rota
        
        ```jsx
        [
        	{
        		username: "bobesponja",
        		avatar: "https://super.abril.com.br/wp-content/uploads/2020/09/04-09_gato_SITE.jpg?quality=70&strip=info",
        	  tweet: "eu amo o hub"
        	}
        ]
        ```
