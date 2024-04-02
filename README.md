Программа повзволяет получить данные о погоде на сегодня и на 7 дней вперед как по местоположению, так и в выбранном городе. В случае отсутсвия разрешения на получение геолокации программа будет работать в обычном режиме.
Полученные в ходе работы с сервером ошибки отображаются пользователю в понятном формате.

Стэк:
Kotlin, Retrofit2, dagger Hilt, Jetpack Compose, Cleam Architecture + MVVM, Kotlin Coroutines, Kotlin Flow.

Сервер:
https://www.weatherapi.com/
https://www.weatherapi.com/docs/
В Получаемом Json файле хранятся объекты о Текущей погоде для выбранного город, так и о Прогнозе на неделю. Причем информацию можно получить на русском языке.