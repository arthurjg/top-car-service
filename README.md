# Top Car Service
back-end do sistema da oficina, com foco em gestão de ordens de serviço, clientes e peças.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.2-brightgreen)
![Maven](https://img.shields.io/badge/Maven-3.8.5-blue)
![Docker](https://img.shields.io/badge/Docker-Enabled-blue)

## Como Executar localmente

### 1. Preparação do Ambiente

Clone e build do repositório:
```bash
git clone https://https://github.com/arthurjg/top-car-service
cd top-car-service
cd app
mvnw package
```

### 2. Subir do Ambiente

Execute o Docker Compose
```bash
cd ..
docker-compose -up -d
```

### 3. Utilizar aplicação

## 3.1 Acessar Swagger

http://localhost:8082/swagger-ui/index.html#/

## 3.2 Autenticar

aceesar o endpoint de autenticação - "autenticação controller - post"

usuario: fgarage
senha: 123456

copiar o conteúdo do campo access_key

utilizar no botão campo "authorize"

## 3.2 Utilizar funcionalidades

criar: Cliente, Veículo, Servico, PeçasInsumos

criar: Ordem Servico

adicionar Servicos e peçasInsumos à Ordem de Servico e visualizar Orçamento

aprovar Ordem de Serviço