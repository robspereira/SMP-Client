Microsserviço CLIENT, que faz parte do desafio proposto pelo mentor para a meta de desafio do primeiro ciclo do programa trainee da SysMap Solutions.

Desafio
Desenvolver um sistema baseado em arquitetura de microserviços para simular uma operadora de cartão de crédito, incluindo processamento de transações, armazenamento e geração de relatórios.

Microserviços Requeridos
1.	API Gateway – Responsável por receber as transações, validar dados e encaminhar para os serviços internos.
2.	Card Service – Gerenciamento de cartões e operações (CRUD).
3.	Control Operation – Processamento e controle das transações do ecossistema.
4.	Client Service – Gestão dos dados dos clientes titulares dos cartões.
5.	Extractor Service – Geração de relatórios de operações e envio de arquivos.

Requisitos Técnicos
•	Implementação seguindo boas práticas de desenvolvimento.
•	Comunicação entre microserviços utilizando mensageria AWS SQS.
•	Persistência de dados utilizando Oracle e MongoDB.
•	Armazenamento de arquivos em AWS S3.
•	Execução do ambiente em contêineres Docker, garantindo a interoperabilidade entre os serviços.
