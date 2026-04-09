# Автоматизированные тесты для Avito (Intern QA Task)

Проект содержит набор UI и API тестов, написанных на Java с использованием Selenide, Rest-Assured и JUnit 5. Отчеты формируются через Allure.

## Требования

Для запуска тестов необходимо установить:
- **JDK 17** или выше
- **Gradle 8.x** (или использовать wrapper, если он есть в проекте)
- **Allure Commandline** (для просмотра отчетов, опционально, можно использовать плагин Gradle)

## Установка и настройка

1. Клонируйте репозиторий:
   ```bash
   git clone https://github.com/gaginUriy/intern-qa-autotest-task.git
   cd intern-qa-autotest-task

   Запуск тестов с генерацией отчета Allure: gradle clean test allureServe

   Это писала нейро сеть я этого не умею 
