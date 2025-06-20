# План автоматизации тестирования
## Перечень автоматизируемых сценариев:
### Исходные данные:
- валидный номер карты - 4444 4444 4444 4441;
- не валидный номер карты - 4444 4444 4444 4442.
### Примечание:
- ссылки перехода на станицу покупки тура **доступны только при запущенной SUT**.
### Позитивные сценарии:
1. **Оплата картой:**
    - **Открыть** [страницу покупки тура](https://localhost:8080/) -> кликнуть кнопку "Купить" (оплата картой) -> в появившихся полях ввести валидные данные -> кликнуть кнопку "Продолжить";  
      `Результат:`
        - данные успешно отправлены и могут быть просмотрены в соответствующей базе данных;
        - появится всплывающее окно об одобрении операции банком.
1. **Покупка в кредит:**
    - **Открыть** [страницу покупки тура](https://localhost:8080/) -> кликнуть кнопку "Купить в кредит" -> в появившихся полях ввести валидные данные -> кликнуть кнопку "Продолжить";  
      `Результат:`
        - данные успешно отправлены и могут быть просмотрены в соответствующей базе данных;
        - появится всплывающее окно об одобрении операции банком.
### Негативные сценарии:
1. **Пустая форма:**
    - **Открыть** [страницу покупки тура](https://localhost:8080/) -> кликнуть кнопку "Купить" (оплата картой) -> кликнуть кнопку "Продолжить";  
      `Результат:`
        - данные не отправлены;
        - под полем "Номер карты" появится сообщение `Неверный формат`;
        - под полем "Месяц" появится сообщение `Неверный формат`;
        - под полем "Год" появится сообщение `Неверный формат`;
        - под полем "Владелец" появится сообщение `Поле обязательно для заполнения`;
        - под полем "CVC/CVV" появится сообщение `Неверный формат`.
1. **Поле "Номер карты":**
    - **Открыть** [страницу покупки тура](https://localhost:8080/) -> кликнуть кнопку "Купить" (оплата картой) -> поле "Номер карты" **оставить пустым**, остальные поля заполнить валидными данными -> кликнуть кнопку "Продолжить";  
      `Результат:`
        - данные не отправлены;
        - под полем "Номер карты" появится сообщение `Неверный формат`.
    - **Открыть** [страницу покупки тура](https://localhost:8080/) -> кликнуть кнопку "Купить" (оплата картой) -> в поле "Номер карты" **ввести не полный номер** (4444 4444 4444 444), остальные поля заполнить валидными данными -> кликнуть кнопку "Продолжить";  
      `Результат:`
        - данные не отправлены;
        - под полем "Номер карты" появится сообщение `Неверный формат`.
    - **Открыть** [страницу покупки тура](https://localhost:8080/) -> кликнуть кнопку "Купить" (оплата картой) -> в поле "Номер карты" **ввести не валидный номер**, остальные поля заполнить валидными данными -> кликнуть кнопку "Продолжить";  
      `Результат:`
        - данные успешно отправлены и могут быть просмотрены в соответствующей базе данных;
        - появится всплывающее окно об отказе в проведении операции банком.
1. **Поле "Месяц":**
    - **Открыть** [страницу покупки тура](https://localhost:8080/) -> кликнуть кнопку "Купить" (оплата картой) -> поле "Месяц" **оставить пустым**, остальные поля заполнить валидными данными -> кликнуть кнопку "Продолжить";  
      `Результат:`
        - данные не отправлены;
        - под полем "Месяц" появится сообщение `Неверный формат`.
    - **Открыть** [страницу покупки тура](https://localhost:8080/) -> кликнуть кнопку "Купить" (оплата картой) -> в поле "Месяц" **ввести не валидный месяц** (в пределах 01-12), остальные поля заполнить валидными данными -> кликнуть кнопку "Продолжить";  
      `Результат:`
        - данные не отправлены;
        - под полем "Месяц" появится сообщение `Неверно указан срок действия карты`.
    - **Открыть** [страницу покупки тура](https://localhost:8080/) -> кликнуть кнопку "Купить" (оплата картой) -> в поле "Месяц" **ввести не валидный месяц** (нижнее граничное значение 00), остальные поля заполнить валидными данными -> кликнуть кнопку "Продолжить";  
      `Результат:`
        - данные не отправлены;
        - под полем "Месяц" появится сообщение `Неверно указан срок действия карты`.
    - **Открыть** [страницу покупки тура](https://localhost:8080/) -> кликнуть кнопку "Купить" (оплата картой) -> в поле "Месяц" **ввести не валидный месяц** (верхнее граничное значение 13), остальные поля заполнить валидными данными -> кликнуть кнопку "Продолжить";  
      `Результат:`
        - данные не отправлены;
        - под полем "Месяц" появится сообщение `Неверно указан срок действия карты`.
1. **Поле "Год":**
    - **Открыть** [страницу покупки тура](https://localhost:8080/) -> кликнуть кнопку "Купить" (оплата картой) -> поле "Год" **оставить пустым**, остальные поля заполнить валидными данными -> кликнуть кнопку "Продолжить";  
      `Результат:`
        - данные не отправлены;
        - под полем "Год" появится сообщение `Неверный формат`.
    - **Открыть** [страницу покупки тура](https://localhost:8080/) -> кликнуть кнопку "Купить" (оплата картой) -> в поле "Год" **ввести не валидный год** (текущий год - 1), остальные поля заполнить валидными данными -> кликнуть кнопку "Продолжить";  
      `Результат:`
        - данные не отправлены;
        - под полем "Год" появится сообщение `Истёк срок действия карты`.
    - **Открыть** [страницу покупки тура](https://localhost:8080/) -> кликнуть кнопку "Купить" (оплата картой) -> в поле "Год" **ввести не валидный год** (текущий год + 6), остальные поля заполнить валидными данными -> кликнуть кнопку "Продолжить";  
      `Результат:`
        - данные не отправлены;
        - под полем "Год" появится сообщение `Неверно указан срок действия карты`.
1. **Поле "Владелец":**
    - **Открыть** [страницу покупки тура](https://localhost:8080/) -> кликнуть кнопку "Купить" (оплата картой) -> поле "Владелец" **оставить пустым**, остальные поля заполнить валидными данными -> кликнуть кнопку "Продолжить";  
      `Результат:`
        - данные не отправлены;
        - под полем "Владелец" появится сообщение `Поле обязательно для заполнения`.
    - **Открыть** [страницу покупки тура](https://localhost:8080/) -> кликнуть кнопку "Купить" (оплата картой) -> в поле "Владелец" **ввести " "**(пробел), остальные поля заполнить валидными данными -> кликнуть кнопку "Продолжить";  
      `Результат:`
        - данные не отправлены;
        - под полем "Владелец" появится сообщение `Поле обязательно для заполнения`.
    - **Открыть** [страницу покупки тура](https://localhost:8080/) -> кликнуть кнопку "Купить" (оплата картой) -> в поле "Владелец" **ввести #&**(два любых спецсимвола), остальные поля заполнить валидными данными -> кликнуть кнопку "Продолжить";  
      `Результат:`
        - данные не отправлены;
        - под полем "Владелец" появится сообщение `Неверный формат имени владельца`.
    - **Открыть** [страницу покупки тура](https://localhost:8080/) -> кликнуть кнопку "Купить" (оплата картой) -> в поле "Владелец" **ввести двузначное число**(10-99), остальные поля заполнить валидными данными -> кликнуть кнопку "Продолжить";  
      `Результат:`
        - данные не отправлены;
        - под полем "Владелец" появится сообщение `Неверный формат имени владельца`.
1. **Поле "CVC/CVV":**
    - **Открыть** [страницу покупки тура](https://localhost:8080/) -> кликнуть кнопку "Купить" (оплата картой) -> поле "CVC/CVV" **оставить пустым**, остальные поля заполнить валидными данными -> кликнуть кнопку "Продолжить";  
      `Результат:`
        - данные не отправлены;
        - под полем "CVC/CVV" появится сообщение `Неверный формат`.
    - **Открыть** [страницу покупки тура](https://localhost:8080/) -> кликнуть кнопку "Купить" (оплата картой) -> в поле "CVC/CVV" **ввести двузначное число**(10-99), остальные поля заполнить валидными данными -> кликнуть кнопку "Продолжить";  
      `Результат:`
        - данные не отправлены;
        - под полем "CVC/CVV" появится сообщение `Неверный формат`.
- **`Аналогичные негативные сценарии для покупки в кредит.`**
## Перечень используемых инструментов с обоснованием выбора:
- JDK 11, т.к. будет использоваться Java;
- IntelliJ IDEA, удобная среда подготовки авто-тестов;
- Gradle, инструмент управления зависимостями;
- DBeaver, для просмотра базы данных;
- JUnit Jupiter, инструмент тестирования, более превычен нежели JUnit4 или TestNG;
- Selenide, очень удобен при тестировании веб-интерфейса;
- MySQL connector Java, PostgreSQL и Commons DBUtils, для доступа к базе данным из кода авто-тестов;
- Lombok, для упрощения написания кода;
- Faker, для генерации данных при отправке формы;
- Github, в качестве хранилища SUT и авто-тестов;
- Allure, для создания отчетов о выполнении авто-тестов;
- Allure-Selenide, для интеграции одного инструмента с другим.
## Перечень и описание возможных рисков при автоматизации:
- Своеобразная настройка SUT при запуске (заявлена поддержка двух СУБД);
- Отсутствие как таковой спецификации на приложение;
- Необходимость добавления новых тестов для заказчика, при отсутствии документации и спецификации на приложение;
- Зависимость авто-тестов от текущей реализации веб-элементов, даже не значительное их изменение может привести к падению авто-тестов;
- Авто-тесты не проверяют графическую составляющую, а именно едет ли верстка при тех или иных действиях, комфортна ли выбранная цветовая схема оформления и тд.
## Интервальная оценка с учётом рисков (в часах):
- Ориентировочно, 126 рабочих часов.
## План сдачи работ (когда будут авто-тесты, результаты их прогона и отчёт по автоматизации):
1. Написание тестов до 26 июня 2025;
2. Предоставление отчетов до 26 июня 2025:
- Подготовка к проведению тестирования (запуск SUT, подготовка плана автоматизации) - 24 часов;
- Написание и прогон авто-тестов - 60 часов;
- Написание баг-репортов - 10 часов;
- Оформление отчёта по итогам тестирования - 16 часов;
- Оформление отчёта по итогам автоматизации - 16 часов.
