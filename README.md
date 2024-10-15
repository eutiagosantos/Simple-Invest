Simple Invest
Simple Invest é uma aplicação backend que ajuda os usuários a monitorar e acompanhar seus investimentos. Utilizando a API da BRAPI, a aplicação permite que os usuários saibam o valor total investido em ações, além de gerenciar suas contas de investimento de forma simples.

Funcionalidades
Consulta de ações em tempo real utilizando a API da BRAPI.
Cálculo do valor total investido com base nas ações do usuário.
Criação, atualização e exclusão de usuários para facilitar o gerenciamento das contas.
Criação, atualização e exclusão de contas de investimento, permitindo que os usuários gerenciem suas carteiras de ações.
Tecnologias Utilizadas
Linguagem: Java
Framework: Spring Boot (ou outro framework usado)
API: BRAPI
Instalação e Configuração
Clone o repositório:

bash
Copiar código
git clone https://github.com/seuusuario/simple-invest.git
Importe o projeto em sua IDE favorita (IntelliJ, Eclipse, etc.).

Configure a API Key da BRAPI no arquivo application.properties:

vbnet
Copiar código
brapi.api.key=your_brapi_api_key
Inicie a aplicação:

Pela IDE, execute a classe principal SimpleInvestApplication.
Ou via linha de comando:
bash
Copiar código
./mvnw spring-boot:run
Como Usar
Gerencie sua conta de usuário:
Endpoints para criar, editar e excluir usuários.
Gerencie suas contas de investimento:
Endpoints para adicionar, editar ou excluir suas contas de investimento.
Consultar ações e calcular investimentos:
Enviar requisições para consultar ações em tempo real e calcular o valor total investido.
API Utilizada
BRAPI: API para obtenção de dados financeiros de ações e outros ativos financeiros.
Contribuição
Contribuições são bem-vindas! Para contribuir, siga os passos:

Faça um fork do projeto.
Crie uma branch para sua feature (git checkout -b minha-feature).
Faça commit de suas mudanças (git commit -m 'Minha nova feature').
Envie para a branch (git push origin minha-feature).
Abra um Pull Request.
Licença
Este projeto está sob a licença MIT. Veja o arquivo LICENSE para mais detalhes.
