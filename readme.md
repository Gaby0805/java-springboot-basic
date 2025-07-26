# 🧊 Fridge API - Sistema de Controle de Alimentos

Este projeto é uma API REST simples feita com **Spring Boot**, com foco em ensinar e praticar a **arquitetura em camadas (MVC)**. O objetivo é cadastrar, listar, editar e remover alimentos de uma "geladeira" virtual.

## 🔧 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Data JPA
- H2 Database (banco em memória)
- Maven


## 🧱 Camadas

### Controller
Responsável por lidar com as requisições HTTP. Recebe os dados do usuário, chama o serviço e retorna a resposta.

```java
@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private final FoodService foodService;

    @GetMapping
    public List<Food> getAll() {
        return foodService.getAll();
    }

    @PostMapping
    public Food save(@RequestBody Food food) {
        return foodService.save(food);
    }

    @PutMapping("/{id}")
    public Food edit(@PathVariable Long id, @RequestBody Food food) {
        food.setId(id);
        return foodService.edit(food);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        foodService.delete(id);
    }
}
```
### Model

Representa as entidades persistidas no banco de dados. Usa anotações do JPA.
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

Contém a lógica de negócio. É responsável por processar os dados antes de salvar ou retornar.
```java
@Service
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getAll() {
        return foodRepository.findAll();
    }

    public Food save(Food food) {
        return foodRepository.save(food);
    }

    public Food edit(Food food) {
        return foodRepository.save(food);
    }

    public void delete(Long id) {
        foodRepository.deleteById(id);
    }
}
```
### Repository
Faz a comunicação com o banco de dados. Herda métodos prontos como save(), findAll(), deleteById().

```java
public interface FoodRepository extends JpaRepository<Food, Long> {}
```
