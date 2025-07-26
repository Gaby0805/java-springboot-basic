
# 🧊 Fridge API

API REST para controle de alimentos em uma geladeira virtual, desenvolvida com **Spring Boot** seguindo arquitetura em camadas (MVC). Permite cadastrar, listar, editar e remover alimentos.

## � Tecnologias

- Java 17+
- Spring Boot
- Spring Data JPA
- H2 Database (memória)
- Maven

## 📁 Estrutura do Projeto

- `controller/` — Camada responsável pelas requisições HTTP (REST)
- `service/` — Lógica de negócio
- `model/` — Entidades JPA
- `repository/` — Persistência de dados

## ⚙️ Como rodar

1. Clone o projeto:
   ```bash
   git clone <url-do-repo>
   ```
2. Entre na pasta e rode:
   ```bash
   ./mvnw spring-boot:run
   ```
   Ou no Windows:
   ```cmd
   mvnw.cmd spring-boot:run
   ```
3. Acesse o H2 Console em [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

## 🧪 Exemplos de Endpoints

### Listar alimentos
`GET /food`

### Adicionar alimento
`POST /food`
```json
{
  "name": "Maçã",
  "expirationDate": "2025-08-01",
  "quantity": 5
}
```

### Editar alimento
`PUT /food/{id}`
```json
{
  "name": "Maçã",
  "expirationDate": "2025-08-10",
  "quantity": 10
}
```

### Remover alimento
`DELETE /food/{id}`

## 🏗️ Camadas

### Controller
Recebe requisições HTTP e chama o serviço:
```java
@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private final FoodService foodService;
    @GetMapping
    public List<Food> getAll() { return foodService.getAll(); }
    @PostMapping
    public Food save(@RequestBody Food food) { return foodService.save(food); }
    @PutMapping("/{id}")
    public Food edit(@PathVariable Long id, @RequestBody Food food) { food.setId(id); return foodService.edit(food); }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { foodService.delete(id); }
}
```

### Model
Entidade JPA:
```java
@Entity
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDate expirationDate;
    private Integer quantity;
    // Getters e Setters
}
```

### Service
Lógica de negócio:
```java
@Service
public class FoodService {
    private final FoodRepository foodRepository;
    public FoodService(FoodRepository foodRepository) { this.foodRepository = foodRepository; }
    public List<Food> getAll() { return foodRepository.findAll(); }
    public Food save(Food food) { return foodRepository.save(food); }
    public Food edit(Food food) { return foodRepository.save(food); }
    public void delete(Long id) { foodRepository.deleteById(id); }
}
```

### Repository
Persistência de dados:
```java
public interface FoodRepository extends JpaRepository<Food, Long> {}
```

## 📚 Observações

- O banco H2 é em memória, os dados são apagados ao reiniciar.
- O projeto é didático, focado em arquitetura MVC e boas práticas.
