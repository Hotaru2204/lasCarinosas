# Diagrama ERD (descriptivo)

Entidades principales:
- **Investigation**(id, code, status)
- **Detective**(id, badgeNumber, fullName, rank)
- **Victim**(id, name, family, status, location, deathDateTime, investigation_id)
- **CrimeScene**(id, location, description, discoveredAt, investigation_id)
- **Suspect**(id, name, motive, riskLevel, investigation_id)
- **Evidence**(id, type, description, chainOfCustody, investigation_id)

Relaciones:
- Investigation (1) --- (N) Victim
- Investigation (1) --- (N) CrimeScene
- Investigation (1) --- (N) Suspect
- Investigation (1) --- (N) Evidence
- Detective (1) --- (N) Investigation (lead assignment)

# Diagrama de Clases (descriptivo)

Capas y responsabilidades:
- **controller**
  - `VictimController`: expone `GET/POST/PUT/DELETE /victims`.
- **service**
  - `VictimService`: contrato de negocio de víctimas.
  - `VictimServiceImpl`: implementación con reglas de existencia y persistencia.
- **repository**
  - `VictimRepository`: acceso JPA a entidad `Victim`.
- **model**
  - `Victim`, `CrimeScene`, `Suspect`, `Investigation`, `Evidence`, `Detective`.
- **dto**
  - `VictimCreateDTO`, `VictimUpdateDTO`, `VictimResponseDTO`.
- **mapper**
  - `VictimMapper`: conversión entre DTOs y entidad.
- **common**
  - `ResourceNotFoundException`, `GlobalExceptionHandler`.
- **config**
  - `SecurityConfig`: resource server JWT + autorización por roles (`ADMIN`, `DETECTIVE`, `ANALYST`).
