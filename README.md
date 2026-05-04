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