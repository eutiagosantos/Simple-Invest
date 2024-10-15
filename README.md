**Simple Invest**
Simple Invest é uma aplicação backend desenvolvida em Java que ajuda os usuários a monitorar e acompanhar seus investimentos. Utilizando a API da BRAPI, a aplicação permite que os usuários saibam o valor total investido em ações e gerenciem suas contas de investimento de forma eficiente.

:star: Funcionalidades
Consulta de ações em tempo real utilizando a API da BRAPI.
Cálculo do valor total investido com base nas ações do usuário.
Criação, atualização e exclusão de usuários para o gerenciamento de contas.
Criação, atualização e exclusão de contas de investimento para um controle personalizado das carteiras de ações.
:wrench: Tecnologias Utilizadas
Linguagem: Java
Framework: Spring Boot
API: BRAPI
:rocket: Instalação e Configuração
Clone o repositório:

bash
Copiar código
git clone https://github.com/eutiagosantos/Simple-Invest.git
Importe o projeto na sua IDE favorita (IntelliJ, Eclipse, etc.).

Configure a chave da API BRAPI no arquivo application.properties:

properties
Copiar código
brapi.api.key=your_brapi_api_key
Inicie a aplicação:

Pela IDE, execute a classe principal SimpleInvestApplication.
Ou via linha de comando:
bash
Copiar código
./mvnw spring-boot:run
:gear: Como Usar
Gerencie sua conta de usuário:
Use os endpoints para criar, editar ou excluir usuários.
Gerencie suas contas de investimento:
Use os endpoints para adicionar, editar ou excluir contas de investimento.
Consultar ações e calcular investimentos:
Utilize os endpoints para consultar ações em tempo real e calcular o valor total investido.
:chart_with_upwards_trend: API Utilizada
BRAPI: API para obtenção de dados financeiros de ações e outros ativos financeiros. Saiba mais aqui.
:handshake: Contribuição
Contribuições são muito bem-vindas! Para contribuir, siga os passos:

Faça um fork do projeto.
Crie uma branch para sua feature (git checkout -b minha-feature).
Faça commit das suas alterações (git commit -m 'Minha nova feature').
Envie para a branch (git push origin minha-feature).
Abra um Pull Request.
:page_facing_up: Licença
Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.
