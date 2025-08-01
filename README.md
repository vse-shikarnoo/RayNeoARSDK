# RayNeo SDK

Комплексный SDK для разработки приложений под платформу RayNeo, включающий библиотеки для AR функциональности и межпроцессного взаимодействия.

## Обзор

RayNeo SDK состоит из двух основных библиотек:

- **RayNeoARSDK** - библиотека для работы с дополненной реальностью (AR)
- **RayNeoIPCSDK** - библиотека для межпроцессного взаимодействия (IPC)

## Структура проекта

```
RayNeoSDK/
├── RayNeoARSDK/          # Библиотека AR функциональности
│   ├── com/rayneo/arsdk/
│   │   ├── android/      # Основные AR компоненты
│   │   ├── touch/        # Система обработки касаний
│   │   ├── focus/        # Система фокусировки
│   │   ├── ui/           # UI компоненты
│   │   └── util/         # Утилиты
│   └── README.md
├── RayNeoIPCSDK/         # Библиотека IPC
│   ├── com/ffalconxr/mercury/ipc/
│   │   ├── speech/       # Речевые функции
│   │   ├── helpers/      # Вспомогательные классы
│   │   └── *.java        # Основные IPC интерфейсы
│   └── README.md
└── README.md             # Этот файл
```

## RayNeoARSDK

Библиотека для работы с дополненной реальностью в системе RayNeo.

### Основные возможности:
- **Система зеркалирования** - отображение контента на внешних экранах
- **Обработка касаний** - система жестов и касаний
- **Система фокусировки** - управление фокусом в AR интерфейсах
- **UI компоненты** - готовые компоненты для AR приложений
- **Утилиты** - вспомогательные инструменты

### Ключевые компоненты:
- `MercurySDK` - основной SDK класс
- `BaseMirrorActivity` - базовая активность для зеркалирования
- `TouchDispatcher` - диспетчер касаний
- `RecyclerViewTracker` - трекер для RecyclerView
- `FToast` - система уведомлений

[Подробная документация ARSDK →](RayNeoARSDK/README.md)

## RayNeoIPCSDK

Библиотека для межпроцессного взаимодействия в системе RayNeo.

### Основные возможности:
- **Удаленный вызов процедур** - RPC между процессами
- **Речевые функции** - распознавание и синтез речи
- **GPS интеграция** - работа с геолокацией
- **Управление кольцевым контроллером** - взаимодействие с кольцом
- **Отслеживание приложений** - мониторинг активных приложений

### Ключевые компоненты:
- `Launcher` - основной класс для управления IPC
- `Speech` - речевые функции
- `GPSIPCHelper` - работа с GPS
- `RingIPCHelper` - управление кольцевым контроллером
- `TopPackageHelper` - отслеживание приложений

[Подробная документация IPCSDK →](RayNeoIPCSDK/README.md)

## Быстрый старт

### 1. Подключение зависимостей

Добавьте библиотеки в ваш проект:

```gradle
dependencies {
    implementation project(':RayNeoARSDK')
    implementation project(':RayNeoIPCSDK')
}
```

### 2. Инициализация ARSDK

```java
public class MainActivity extends BaseMirrorActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Инициализация AR функциональности
        MercurySDK.initialize(this);
    }
}
```

### 3. Инициализация IPCSDK

```java
public class MainActivity extends AppCompatActivity {
    private Launcher launcher;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Инициализация IPC
        launcher = Launcher.getInstance(this);
        launcher.connect();
        
        // Настройка речевых функций
        Speech speech = launcher.getSpeech();
        speech.setAIUIListener(new Speech.AIUIListener() {
            @Override
            public void onAIUIEvent(int eventType, int arg1, int arg2, String info) {
                // Обработка речевых событий
            }
        });
    }
}
```

## Примеры использования

### AR приложение с зеркалированием

```java
public class ARMirrorActivity extends BaseMirrorActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ar_mirror);
        
        // Настройка зеркалирования
        MirrorContainerView mirrorView = findViewById(R.id.mirror_container);
        mirrorView.setMirrorEnabled(true);
    }
    
    @Override
    public void onTouchEvent(MotionEvent event) {
        // Обработка касаний
        TouchDispatcher.getInstance().dispatchTouchEvent(event);
    }
}
```

### Приложение с речевым управлением

```java
public class VoiceControlActivity extends AppCompatActivity {
    private Launcher launcher;
    private Speech speech;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Инициализация IPC
        launcher = Launcher.getInstance(this);
        launcher.connect();
        
        speech = launcher.getSpeech();
        
        // Настройка распознавания речи
        speech.startDialog(new Speech.NLPCallback() {
            @Override
            public void onSpeechResult(SpeechResult result, boolean isLast) {
                if (isLast) {
                    handleVoiceCommand(result.nlpResult);
                }
            }
        }, new Bundle());
    }
    
    private void handleVoiceCommand(String command) {
        // Обработка голосовых команд
        if (command.contains("открыть")) {
            // Логика открытия
        }
    }
}
```

### Интеграция с кольцевым контроллером

```java
public class RingControlActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // Регистрация для получения данных кольца
        RingIPCHelper.registerRingInfo(this);
        
        // Включение IMU кольца
        RingIPCHelper.setRingIMU(this, true);
        
        // Настройка длительного нажатия
        RingIPCHelper.setRingLongClick(this, true);
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        RingIPCHelper.unRegisterRingInfo(this);
    }
}
```

## Архитектура

### ARSDK Архитектура
```
MercurySDK (основной SDK)
├── BaseMirrorActivity (базовая AR активность)
├── TouchDispatcher (система касаний)
├── RecyclerViewTracker (трекер списков)
├── FToast (уведомления)
└── Util (утилиты)
```

### IPCSDK Архитектура
```
Launcher (основной класс)
├── IBinderFactory (фабрика Binder)
├── IRemoteService (удаленный сервис)
├── Speech (речевые функции)
├── Helpers (вспомогательные классы)
└── Utils (утилиты)
```

## Требования

### Системные требования
- Android API 21+
- Устройство RayNeo
- Соответствующие разрешения в манифесте

### Разрешения

```xml
<!-- ARSDK разрешения -->
<uses-permission android:name="android.permission.CAMERA" />
<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />

<!-- IPCSDK разрешения -->
<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION" />
<uses-permission android:name="android.permission.RECORD_AUDIO" />
<uses-permission android:name="android.permission.BIND_ACCESSIBILITY_SERVICE" />
```

## Зависимости

### ARSDK
- Android Support Library
- AndroidX Annotations
- Kotlin Standard Library

### IPCSDK
- Android Support Library
- AndroidX Annotations

## Лицензия

[Укажите лицензию проекта]

## Поддержка

Для получения поддержки и дополнительной информации:
- Документация: [ссылка на документацию]
- Примеры: [ссылка на примеры]
- Вопросы: [ссылка на форум/поддержку]

## Версии

### ARSDK
- Текущая версия: [версия]
- Минимальная версия Android: API 21
- Последнее обновление: [дата]

### IPCSDK
- Текущая версия: [версия]
- Минимальная версия Android: API 21
- Последнее обновление: [дата] 