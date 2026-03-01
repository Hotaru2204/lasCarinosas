# Las Cariñosas - Backend Spring Boot

Sistema backend para la investigación de crímenes en "Las Cariñosas".

## Requisitos implementados
- Arquitectura por capas (`controller`, `service`, `repository`, `model`, `dto`, `mapper`, `common`).
- Entidades principales: Victim, CrimeScene, Suspect, Investigation, Evidence, Detective.
- Endpoints REST base de víctimas:
  - `GET /victims`
  - `POST /victims`
  - `PUT /victims/{id}`
  - `DELETE /victims/{id}`
- Seguridad con Keycloak vía OAuth2 Resource Server y roles `ADMIN`, `DETECTIVE`, `ANALYST`.
- Dockerfile y `compose.yml` (backend + PostgreSQL + Keycloak).
- GUI web mínima en `src/main/resources/static/index.html`.
- Diagramas descriptivos ERD y de clases en `docs/diagrams.md`.

## Ejecución local
```bash
mvn spring-boot:run
```

## Ejecución con contenedores
```bash
docker compose -f compose.yml up --build
```
