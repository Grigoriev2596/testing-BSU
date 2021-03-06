## **[travelata](https://travelata.ru/)**

## **Функциональные тест кейсы**

**Тест** **кейс №1**

**Название тест** **кейса:** Проверка ближайшей даты вылета
**Шаги тест** **кейса:**

1. Зайти на сайт [travelata](https://travelata.ru)

2. Нажать на кнопку "дата вылета"

3. Пролистать календарь назад, насколько возможно

**Ожидаемый результат тест кейса:**  Ближайшая активная дата в календаре = текущая дата + 1 день

------

**Тест** **кейс №2**

**Название тест** **кейса:** Проверка минимального и максимального значений диапазона "кол-во ночей"
**Шаги тест** **кейса:**

1. Зайти на сайт [travelata](https://travelata.ru)

2. Нажать на кнопку "кол-во ночей"

3. в пункте "от" прокликать до минимального значения, в пункте "до" прокликать до максимального значения

**Ожидаемый результат тест кейса:** поле "от" имеет минимальное значение равное 1, "до" имеет максимальное значение равное 29

------

**Тест** **кейс №3**

**Название тест** **кейса:** Проверка поиска туров
**Шаги тест** **кейса:**

1. Зайти на сайт [travelata](https://travelata.ru)

2. Заполнить параметры : "город вылета", "страна, курорт или отель", "дата вылета", "кол-во ночей", "туристы"

3. Нажать кнопку "искать туры"

**Ожидаемый результат тест кейса:** отображаемые туры должны соответствовать введенным параметрам

------

**Тест** **кейс №4**

**Название тест** **кейса:** Проверка поиска туров
**Шаги тест** **кейса:**

1. Зайти на сайт [travelata](https://travelata.ru)

2. Перейти во вкладку "Поиск туров"


**Ожидаемый результат тест кейса:** отображается страница со списков туров, туры отсортированы по популярности

------

**Тест** **кейс №4**

**Название тест** **кейса:** Проверка отображения предложений для конкретного тура
**Шаги тест** **кейса:**

1. Зайти на сайт [travelata](https://travelata.ru)
2. Перейти во вкладку "Поиск туров"
3. Перейти на страницу любого тура
4. Пролистать чуть ниже

**Ожидаемый результат тест кейса:** конкретные предложения для данного тура отображаются и отсортированы по возрастанию цены

------

**Тест** **кейс №5**

**Название тест** **кейса:** Проверка отображения туров различных типов
**Шаги тест** **кейса:**

1. Зайти на сайт [travelata](https://travelata.ru)
2. Перейти во вкладку "Отдых в России"
3. Выбрать тип отдыха "Горнолыжный"

**Ожидаемый результат тест кейса:** отображение только горнолыжных туров

------

**Тест** **кейс №6**

**Название тест** **кейса:** Проверка отображения туров, выбранных через "календарь низких цен"
**Шаги тест** **кейса:**

1. Зайти на сайт [travelata](https://travelata.ru)
2. Перейти во вкладку "Календарь низких цен"
3. Нажать в секции "Популярные направления" на Турцию
4. Выбрать Санкт-Петербург как город вылета
5. Нажать на любую заполненную ячейку таблицы (пример: Октябрь - на 3 ночи - 10 822 руб.)

**Ожидаемый результат тест кейса:** пользователь находится во вкладке "Поиск туров", под шапкой сайта выбран город вылета Санкт-Петербург; месяц "даты вылета" совпадает с месяцем, выбранном в таблице ранее (октябрь); диапазон "кол-во ночей" включает значение, выбранное пользователем; отображается список туров по данным параметрам, отсортированный по возрастанию цены. 

------

**Тест** **кейс №7**

**Название тест** **кейса:** Проверка вкладки "Отель" услуги "Купить тур в офисе"
**Шаги тест** **кейса:**

1. Зайти на сайт [travelata](https://travelata.ru)
2. Нажать на кнопку "Купить тур в офисе" в правом верхнем углу
3. В секции "Куда" оставить Турцию и нажать "Далее"
4. В секции "Когда" оставить Турцию и нажать "Далее"
5. В секции "Кто" оставить Турцию и нажать "Далее"
6. в секции "Отель" убрать галочку с пункта "Любой"

**Ожидаемый результат тест кейса:** кнопка "Далее" становится некликабельной

------

**Тест** **кейс №8**

**Название тест** **кейса:** Проверка вкладки "Офис" услуги "Купить тур в офисе"

**Предусловия тест** **кейса:** шаги тест кейса №7

**Шаги тест кейса:**

1. в секции "Отель" поставить галочку в пункте "Любой", нажать "Далее"
2. нажать на кнопку "список", поставить галочку напротив любого офиса, нажать "Далее"

**Ожидаемый результат тест кейса:** после выполнения 1 шага во вкладке "Офис", на месте кнопки "Далее" находится неактивная серая кнопка "Выбрать офис", после выбора офиса кнопка становится активной кнопкой "Далее", при этом снять галочку с выбранного офиса уже нельзя(только выбрать другой)

------

**Тест** **кейс №9**

**Название тест** **кейса:** Проверка работы поиска туров по количеству возрослых на тур

**Шаги тест кейса:**

1. Зайти на сайт [travelata](https://travelata.ru)
2. Выбрать "Туристы"
3. Выбрать "4 взрослых"
4. Нажать кнопку "Искать туры"

**Ожидаемый результат тест кейса:** на странице отображаются только туры, у которых справа в описании написано "4 взрослых"

------

**Тест** **кейс №10**

**Название тест** **кейса:** Проверка фильтра "класс отеля" во вкладке "Поиск туров"

**Шаги тест кейса:**

1. Зайти на сайт [travelata](https://travelata.ru)
2. Зайти во вкладку "Поиск туров"
3. В фильтрах слева поставить галочку на против пятизвездочных отелей 

**Ожидаемый результат тест кейса:** на странице отображаются только туры с пятизвездочными отелями
