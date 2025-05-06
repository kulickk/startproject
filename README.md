#  10. AOP	

## Реализация по задаче:

### Конфигурация
- **application.yml**  
  Задает параметр `api.max-requests` для глобального лимита вызовов.

- **ApiConfigProperties**  
  Класс с `@ConfigurationProperties(prefix = "api")` для чтения `maxRequests`.

### Аннотация
- **@CountedApi**  
  Аннотация для пометки методов, обращения к которым нужно считать и ограничивать.

### Аспект
- **RateLimitAspect**  
  - Оборачивает все вызовы методов с `@CountedApi`.  
  - Инкрементирует счётчик и сравнивает с порогом из `ApiConfigProperties`.  
  - При превышении бросает `ApiRateLimitExceededException`, иначе — продолжает выполнение оригинального метода.

### Обработка ошибок
- **ApiRateLimitExceededException**  
  Исключение с `@ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)` для возврата HTTP 429.

### Контроллер
- **CustomController**  
  - `GET /api/hello` — помечен `@CountedApi`.
---

**Студент:** Киреев Никита Максимович  
**Преподаватель:** Рогожников Дмитрий
