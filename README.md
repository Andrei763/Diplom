Дипломный проект профессии «Тестировщик»
В рамках дипломного проекта требовалось автоматизировать тестирование комплексного сервиса покупки тура, взаимодействующего с СУБД и API Банка.

База данных хранит информацию о заказах, платежах, статусах карт, способах оплаты.

Для покупки тура есть два способа: с помощью карты и в кредит. В приложении используются два отдельных сервиса оплаты: Payment Gate и Credit Gate.

[Ссылка на дипломное задание](https://github.com/netology-code/qa-diploma?tab=readme-ov-file)

## Тестовая документация
1. [План автоматизации тестирования](https://github.com/Andrei763/Diplom/blob/main/documents/Plan.md) 
2. [Отчет о проведенном тестировании](https://github.com/Andrei763/Diplom/blob/main/documents/Report.md)
3. [Отчет о проведённой автоматизации тестирования](https://github.com/Andrei763/Diplom/blob/main/documents/Summary.md)
### Подготовительный этап
1. Установить IntelliJ IDEA;
2. Установать Docker Desktop;
3. Скопировать репозиторий с Github по [ссылке](https://github.com/Andrei763/Diplom).

## Запуск SUT, авто-тестов и генерация репорта
### Подключение SUT к PostgreSQL
1. Запустить Docker
2. Открыть скопированный проект в IntelliJ IDEA
3. В терминале в корне проекта запустить контейнеры:
 > docker-compose up -d
4. Запустить приложение:
> java -jar .\artifacts\aqa-shop\aqa-shop.jar --spring.datasource.url=jdbc:postgresql://localhost:5432/app
5. Открыть второй терминал
6. Запустить тесты:
> .\gradlew clean test -DdbUrl=jdbc:postgresql://localhost:5432/app
7. Создать отчёт Allure и открыть в браузере
> .\gradlew allureServe
8. Закрыть отчёт:
> CTRL + C -> y -> Enter
9. Перейти в первый терминал
10. Остановить приложение:
> CTRL + C
11. Остановить контейнеры:
> docker-compose down
### Подключение SUT к MySQL
1. Запустить Docker
2. Открыть скопированный проект в IntelliJ IDEA
3. В терминале в корне проекта запустить контейнеры:
 > docker-compose up -d
4. Запустить приложение:
> java -jar .\artifacts\aqa-shop\aqa-shop.jar --spring.datasource.url=jdbc:mysql://localhost:3306/app
5. Открыть второй терминал
6. Запустить тесты:
> .\gradlew clean test -DdbUrl=jdbc:mysql://localhost:3306/app
7. Создать отчёт Allure и открыть в браузере
> .\gradlew allureServe
8. Закрыть отчёт:
> CTRL + C -> y -> Enter
9. Перейти в первый терминал
10. Остановить приложение:
> CTRL + C
11. Остановить контейнеры:
> docker-compose down
