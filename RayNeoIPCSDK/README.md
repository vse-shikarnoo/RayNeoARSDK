# RayNeo IPCSDK

Библиотека для межпроцессного взаимодействия (IPC) в системе RayNeo, обеспечивающая связь между приложениями и системными сервисами.

## Обзор

IPCSDK предоставляет интерфейсы для:
- Удаленного вызова процедур (RPC) между процессами
- Управления речевыми функциями (распознавание речи, синтез речи)
- Работы с GPS данными
- Управления кольцевым контроллером
- Отслеживания активных приложений

## Основные компоненты

### 1. Основные интерфейсы IPC

#### `IBinderFactory`
Фабрика для создания Binder объектов различных типов:
- `BINDER_TYPE_DEFAULT` (0) - стандартный тип
- `BINDER_TYPE_SPEECH` (1) - для речевых функций

#### `IRemoteService`
Основной интерфейс удаленного сервиса:
- `register(callback, packageName)` - регистрация клиента
- `request(request)` - отправка запроса
- `unRegister(callback, packageName)` - отмена регистрации

#### `IRemoteServiceCallback`
Интерфейс для получения ответов от сервиса:
- `onResponse(response)` - обработка ответа

### 2. Модели данных

#### `Request`
Класс для отправки запросов:
- `packageName` - имя пакета отправителя
- `data` - данные запроса

#### `Response`
Класс для получения ответов:
- `packages` - список пакетов-получателей
- `data` - данные ответа

### 3. Основной класс Launcher

Центральный класс для управления IPC соединением:

#### Основные методы:
```java
// Получение экземпляра
Launcher launcher = Launcher.getInstance(context);

// Управление соединением
launcher.connect();
launcher.disConnect();
boolean isReady = launcher.isReady();

// Отправка запросов
launcher.request("command_data");

// Управление логированием
launcher.enableLog();
launcher.disableLog();
```

#### Слушатели событий:
```java
// Слушатель ответов
launcher.addOnResponseListener(new Launcher.OnResponseListener() {
    @Override
    public void onResponse(Response response) {
        // Обработка ответа
    }
});

// Слушатель состояния соединения
launcher.addOnConnectionStateListener(new Launcher.OnConnectionStateListener() {
    @Override
    public void onConnectionState(Launcher.ConnectionState state) {
        // Обработка изменения состояния
    }
});
```

### 4. Речевые функции (Speech)

#### Основной класс `Speech`:
```java
Speech speech = launcher.getSpeech();

// Управление диалогом
speech.startDialog(nlpCallback, bundle);
speech.stopDialog();

// Синтез речи (TTS)
speech.startTTS("текст для озвучивания", ttsListener);
speech.stopTTS();

// Установка AIUI слушателя
speech.setAIUIListener(aiuiListener);
```

#### Интерфейсы речевых функций:

**`ISpeechInterface`** - основной интерфейс речевых функций
**`INLPCallback`** - обработка результатов распознавания речи
**`ITTSListener`** - события синтеза речи
**`IAIUIEventListener`** - события AIUI

#### `SpeechResult` - результат распознавания речи:
- `nlpResult` - результат обработки естественного языка
- `eventType` - тип события
- `arg1`, `arg2` - дополнительные аргументы
- `info` - дополнительная информация

### 5. Вспомогательные классы

#### `RequestHelper`
Утилита для отправки запросов с автоматическим ожиданием соединения:
```java
RequestHelper.request(context, "command");
```

#### `GPSIPCHelper`
Управление GPS данными:
```java
// Регистрация для получения GPS данных
GPSIPCHelper.registerGPSInfo(context);

// Отмена регистрации
GPSIPCHelper.unRegisterGPSInfo(context);
```

#### `RingIPCHelper`
Управление кольцевым контроллером:
```java
// Регистрация информации о кольце
RingIPCHelper.registerRingInfo(context);
RingIPCHelper.unRegisterRingInfo(context);

// Управление IMU кольца
RingIPCHelper.setRingIMU(context, true/false);

// Управление длительным нажатием
RingIPCHelper.setRingLongClick(context, true/false);

// Управление разделением кнопок
RingIPCHelper.setRingSeparateButton(context, true/false);

// Отправка QR кода для входа
RingIPCHelper.sendLoginQRCode(context, "qr_code_data");
```

#### `TopPackageHelper`
Отслеживание активных приложений:
```java
// Добавление приложения в список активных
TopPackageHelper.addTopPackage(context);

// Удаление приложения из списка активных
TopPackageHelper.removeTopPackage(context);
```

### 6. Утилиты

#### `LogUtil`
Управление логированием:
```java
LogUtil.enableLog();
LogUtil.disableLog();
LogUtil.d("TAG", "message");
LogUtil.i("TAG", "message");
LogUtil.w("TAG", "message");
LogUtil.e("TAG", "message");
```

## Архитектура

Библиотека использует Android Binder для межпроцессного взаимодействия:

1. **Launcher** - основной класс, управляющий соединением с удаленным сервисом
2. **IBinderFactory** - создает различные типы Binder объектов
3. **IRemoteService** - интерфейс для взаимодействия с удаленным сервисом
4. **Специализированные интерфейсы** - для конкретных функций (речь, GPS, кольцо)

## Жизненный цикл

1. **Инициализация**: `Launcher.getInstance(context)`
2. **Подключение**: `launcher.connect()`
3. **Использование**: отправка запросов и получение ответов
4. **Отключение**: `launcher.disConnect()`

## Автоматическое управление

Библиотека автоматически:
- Отслеживает жизненный цикл активностей
- Управляет состоянием соединения
- Обрабатывает разрывы соединения
- Переподключается при необходимости

## Пример использования

```java
public class MainActivity extends AppCompatActivity {
    private Launcher launcher;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Инициализация
        launcher = Launcher.getInstance(this);
        
        // Добавление слушателей
        launcher.addOnResponseListener(response -> {
            Log.d("IPC", "Получен ответ: " + response.getData());
        });
        
        launcher.addOnConnectionStateListener(state -> {
            if (state == Launcher.ConnectionState.CONNECTED) {
                // Отправка запроса после подключения
                launcher.request("test_command");
            }
        });
        
        // Подключение
        launcher.connect();
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        launcher.disConnect();
    }
}
```

## Требования

- Android API 21+
- Подключение к системе RayNeo
- Соответствующие разрешения в манифесте

## Зависимости

- Android Support Library
- AndroidX Annotations 