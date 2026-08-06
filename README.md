# Top Car Service
back-end do sistema da oficina, com foco em gestão de ordens de serviço, clientes e peças.

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.5-brightgreen)
![Maven](https://img.shields.io/badge/Maven-3.8.5-blue)
![Docker](https://img.shields.io/badge/Docker-Enabled-blue)
![Kubernetes](https://img.shields.io/badge/Kubernetes-Enabled-blue)
![Terraform](https://img.shields.io/badge/Terraform-Enabled-purple)

### Nota versao Fase 2

#### Objetivos/Entregáveis dessa Fase

- Refatorar o código da fase 1 aplicando Clean Architecture
- Garantir a aplicação containerizada via Docker/Docker-Compose
- Criar manifestos YAML para deploy em Kubernetes(Deployments, Services, ConfigMaps, Secrets e HPA)
- Infraestrutura como Código (IaC) com Terraform para provisionamento Cloud AWS
- Integração Contínua/Entrega Contínua (CI/CD) com Github Actions para build maven, docker, geração imagem ECR, deploy cluster EKS e aplicação de manifestos kubernetes no Cluster

#### Arquitetura

![arquitetura](/docs/diagrama-arquitetura-aws.drawio.png)

## Como Executar localmente;

### Pré-requisitos / Ferramentas

- **Java 21** ou superior
- **Git**
- **Docker** e **Docker Compose**
- **Kubernetes**


### 1.1. Preparação do Ambiente

* Clone e build do repositório:
```bash
git clone https://github.com/arthurjg/top-car-service
cd top-car-service
cd app
mvnw package
docker build -t top-car-service:v1 .
```

### 1.2.1 Subir do Ambiente Via Docker/Docker-compose

* Execute o Docker Compose
```bash
cd ..
docker-compose up -d
```

### 1.2.2 Subir do Ambiente Via Docker/Kubernetes

* execute os manifestos do kubernetes no cluster
```bash
cd ..
k8s-start.bat
kubectl port-forward svc/top-car-service-svc 5000:80
```

### 1.3. Utilizar aplicação

### 1.3.1 Acessar Swagger

http://localhost:8082/swagger-ui/index.html#/

http://localhost:5000/swagger-ui/index.html

### 1.3.2 Autenticar

* aceesar o endpoint de autenticação - "autenticação controller - post"

* usuario: fgarage

* senha: 123456

* copiar o conteúdo do campo access_key

* utilizar no botão campo "authorize"

### 1.3.2 Utilizar funcionalidades

* criar: Cliente, Veículo, Servico, PeçasInsumos

* criar: Ordem Servico

* adicionar Servicos e peçasInsumos à Ordem de Servico e visualizar Orçamento

* aprovar Ordem de Serviço

