# Инструкция по запуску Spring Boot приложения

Нужно установить

Java 21
Maven

Последовательность запуска

# 1. Перейдите в папку с проектом
cd (путь к проекту)/JustSoftTestApplication

# 2. Соберите проект
mvn clean package

# 3. Запустите приложение
java -jar target/ComfortableSoftTestApplication-0.0.1-SNAPSHOT.jar

## Проверка

Swagger UI: http://localhost:8080/swagger-ui.html


Если Maven или Java нет

Установите Java 21
Установите Maven
Убедитесь, что java -version и mvn -version работают

Готово.
Приложение запустится и будет доступно на localhost:8080.