## Descrizione
Questo progetto è un’applicazione **Spring Boot** che espone **REST API** per gestire un database di **orologi di lusso**.  
È strutturato secondo il classico pattern **Controller → Service → Repository** e utilizza **PostgreSQL** come database.

---

## Database
- **Database:** PostgreSQL  
- **Nome database:** `LuxuryWatches`
- **Nota:** Alcuni dati numerici (come prezzi o misure) sono memorizzati come **VARCHAR** invece che come tipi numerici. Questo può influenzare operazioni come ordinamento o calcoli diretti nel database.

---

## Dipendenze principali
- Spring Boot  
- Spring Web  
- Spring Data JPA  
- PostgreSQL Driver  
- Spring Boot Starter Validation
