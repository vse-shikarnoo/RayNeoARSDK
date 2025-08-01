# RayNeoARSDK

Библиотека для разработки AR приложений с поддержкой стереоскопического отображения, продвинутой системой касаний и управления фокусом, оптимизированная для носимых устройств типа AR очков.

## 📋 Содержание

- [Установка](#установка)
- [Быстрый старт](#быстрый-старт)
- [Основная архитектура](#основная-архитектура)
- [Система управления фокусом](#система-управления-фокусом)
- [Система обработки касаний](#система-обработки-касаний)
- [UI компоненты](#ui-компоненты)
- [Зеркальные компоненты](#зеркальные-компоненты)
- [Диалоги и уведомления](#диалоги-и-уведомления)
- [Адаптеры и привязки данных](#адаптеры-и-привязки-данных)
- [Утилиты и расширения](#утилиты-и-расширения)
- [Игровые компоненты](#игровые-компоненты)
- [Система пар](#система-пар)
- [Звуковые эффекты](#звуковые-эффекты)
- [Специфичные для AR функции](#специфичные-для-ar-функции)
- [Примеры использования](#примеры-использования)
- [Лицензия](#лицензия)

## 🚀 Установка

### Требования
- Android API 21+
- Kotlin 1.7+
- AndroidX

### Подключение
```gradle
dependencies {
    implementation 'com.rayneo:arsdk:1.0.0'
}
```

## ⚡ Быстрый старт

### Инициализация
```kotlin
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        MercurySDK.init(this)
    }
}
```

### Базовая активность с поддержкой касаний
```kotlin
class MainActivity : BaseTouchActivity() {
    override fun onClick(): Boolean {
        // Обработка одиночного касания
        return true
    }
    
    override fun onDoubleClick(): Boolean {
        // Обработка двойного касания
        return true
    }
}
```

## 🏗️ Основная архитектура

### MercurySDK
Главный класс для инициализации библиотеки.

**Основные методы:**
- `init(Application application)` - инициализация библиотеки
- `getMApplication()` - получение контекста приложения

**Пример использования:**
```kotlin
// Инициализация в Application
MercurySDK.init(this)

// Получение контекста
val app = MercurySDK.INSTANCE.mApplication
```

## 🎯 Система управления фокусом

### IFocusable
Интерфейс для элементов с фокусом.

**Основные свойства:**
- `hasFocus: Boolean` - состояние фокуса
- `focusParent: IFocusable?` - родительский элемент фокуса

**Пример реализации:**
```kotlin
class MyFocusableItem : IFocusable {
    private var hasFocus = false
    private var focusParent: IFocusable? = null
    
    override fun getHasFocus(): Boolean = hasFocus
    override fun setHasFocus(value: Boolean) {
        hasFocus = value
        // Обновление UI при изменении фокуса
    }
    
    override fun getFocusParent(): IFocusable? = focusParent
    override fun setFocusParent(value: IFocusable?) {
        focusParent = value
    }
}
```

### FocusTracker
Трекер фокуса для диалогов и модальных окон.

**Основные методы:**
- `next()` - переход к следующему элементу
- `previous()` - переход к предыдущему элементу
- `getCurrentFocusItem()` - получение текущего элемента с фокусом

**Пример использования:**
```kotlin
val focusTracker = FocusTracker()
focusTracker.next() // Переход к следующему элементу
focusTracker.previous() // Переход к предыдущему элементу
```

### RecyclerViewFocusTracker
Специализированный трекер для RecyclerView с автоматической прокруткой.

**Основные возможности:**
- Автоматическая прокрутка к выбранному элементу
- Поддержка циклической навигации
- Обработка событий Pull-to-Refresh
- Настройка чувствительности прокрутки

**Конструктор:**
```kotlin
RecyclerViewFocusTracker(
    mPair: ViewPair<RecyclerView>,
    ignoreDelta: Int = 50,
    loop: Boolean = false
)
```

**Основные методы:**
- `setCurrentSelectPos(index: Int)` - установка текущей позиции
- `getCurrentSelectPos(): Int` - получение текущей позиции
- `handleActionEvent(action: TempleAction, block: (TempleAction) -> Unit)` - обработка действий
- `checkPosSelected(pos: Int): Boolean` - проверка выбора позиции
- `notifyDataSetChanged()` - уведомление об изменении данных

**Пример использования:**
```kotlin
val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
val viewPair = ViewPair(recyclerView, recyclerView)
val focusTracker = RecyclerViewFocusTracker(viewPair, ignoreDelta = 30, loop = true)

// Обработка действий касаний
focusTracker.handleActionEvent(action) { templeAction ->
    when (templeAction) {
        is TempleAction.SlideForward -> {
            // Обработка свайпа вперед
        }
        is TempleAction.SlideBackward -> {
            // Обработка свайпа назад
        }
    }
}

// Установка слушателей
focusTracker.setOnItemFocusListener { position, view ->
    // Обработка фокуса на элементе
}

focusTracker.setOnFocusChangeListener { hasFocus ->
    // Обработка изменения фокуса
}

focusTracker.setRefreshListener {
    // Обработка Pull-to-Refresh
}
```

**Настройка циклической навигации:**
```kotlin
// С циклической навигацией
val focusTracker = RecyclerViewFocusTracker(viewPair, loop = true)

// Без циклической навигации (с Pull-to-Refresh)
val focusTracker = RecyclerViewFocusTracker(viewPair, loop = false)
```

## 👆 Система обработки касаний

### TouchDispatcher
Основной диспетчер для обработки касаний и жестов.

**Конструктор:**
```kotlin
TouchDispatcher(source: TouchDispatcher.Source)
```

**Источники касаний:**
- `TouchDispatcher.Source.Activity` - для Activity
- `TouchDispatcher.Source.Global` - для глобальных событий
- `TouchDispatcher.Source.Window` - для событий окна

**Основные методы:**
- `onMotionEvent(event: MotionEvent, callback: CommonTouchCallback?)` - обработка событий движения
- `onKeyEvent(event: KeyEvent, callback: CommonTouchCallback?)` - обработка событий клавиатуры
- `toggleClickSoundEffect(type: Int, enable: Boolean)` - управление звуковыми эффектами

**Пример использования:**
```kotlin
val touchDispatcher = TouchDispatcher(TouchDispatcher.Source.Activity)
val callback = object : CommonTouchCallback {
    override fun onTPClick(): Boolean {
        // Обработка одиночного касания
        return true
    }
    
    override fun onTPDoubleClick(): Boolean {
        // Обработка двойного касания
        return true
    }
    
    override fun onTPLongClick(): Boolean {
        // Обработка длительного касания
        return true
    }
    
    override fun onTPSlideForward(args: FlingArgs): Boolean {
        // Обработка свайпа вперед
        return true
    }
    
    override fun onTPSlideBackward(args: FlingArgs): Boolean {
        // Обработка свайпа назад
        return true
    }
    
    override fun onTPSlideContinuous(delta: Float, longClick: Boolean): Boolean {
        // Обработка непрерывного скольжения
        return true
    }
    
    override fun onTPMoveUp(isLongClick: Boolean): Boolean {
        // Обработка поднятия пальца
        return true
    }
    
    override fun onActionUp() {
        // Обработка завершения действия
    }
    
    override fun onTPTripleClick() {
        // Обработка тройного касания
    }
    
    override fun onKeyPinch() {
        // Обработка жеста щипка
    }
    
    override fun onKeyLongPinch() {
        // Обработка длительного жеста щипка
    }
}

// Обработка событий
override fun onTouchEvent(event: MotionEvent): Boolean {
    touchDispatcher.onMotionEvent(event, callback)
    return super.onTouchEvent(event)
}
```

### TempleAction
Система действий касаний с поддержкой различных типов жестов.

**Типы действий:**

#### Click
Одиночное касание.
```kotlin
val click = TempleAction.Click(consumed = false, id = SystemClock.uptimeMillis())
```

#### DoubleClick
Двойное касание.
```kotlin
val doubleClick = TempleAction.DoubleClick(consumed = false, id = SystemClock.uptimeMillis())
```

#### TripleClick
Тройное касание.
```kotlin
val tripleClick = TempleAction.TripleClick(consumed = false, id = SystemClock.uptimeMillis())
```

#### LongClick
Длительное касание.
```kotlin
val longClick = TempleAction.LongClick(consumed = false, id = SystemClock.uptimeMillis())
```

#### SlideForward/SlideBackward
Свайпы вперед и назад с параметрами FlingArgs.
```kotlin
val flingArgs = FlingArgs(e1, e2, velocityX, velocityY)
val slideForward = TempleAction.SlideForward(flingArgs, consumed = false, id = SystemClock.uptimeMillis())
val slideBackward = TempleAction.SlideBackward(flingArgs, consumed = false, id = SystemClock.uptimeMillis())
```

#### SlideContinuous
Непрерывное скольжение с дельтой и флагом длительного касания.
```kotlin
val slideContinuous = TempleAction.SlideContinuous(
    delta = 10.5f,
    longClick = false,
    id = SystemClock.uptimeMillis()
)
```

#### MoveUp
Поднятие пальца с флагом длительного касания.
```kotlin
val moveUp = TempleAction.MoveUp(isLongClick = false, id = SystemClock.uptimeMillis())
```

#### ActionUp
Завершение действия.
```kotlin
val actionUp = TempleAction.ActionUp(id = SystemClock.uptimeMillis())
```

**Обработка действий:**
```kotlin
fun handleTempleAction(action: TempleAction) {
    when (action) {
        is TempleAction.Click -> {
            // Обработка одиночного касания
        }
        is TempleAction.DoubleClick -> {
            // Обработка двойного касания
        }
        is TempleAction.TripleClick -> {
            // Обработка тройного касания
        }
        is TempleAction.LongClick -> {
            // Обработка длительного касания
        }
        is TempleAction.SlideForward -> {
            // Обработка свайпа вперед
            val args = action.args
            val velocityX = args.velocityX
            val velocityY = args.velocityY
        }
        is TempleAction.SlideBackward -> {
            // Обработка свайпа назад
        }
        is TempleAction.SlideContinuous -> {
            // Обработка непрерывного скольжения
            val delta = action.delta
            val isLongClick = action.longClick
        }
        is TempleAction.MoveUp -> {
            // Обработка поднятия пальца
            val isLongClick = action.isLongClick
        }
        is TempleAction.ActionUp -> {
            // Обработка завершения действия
        }
    }
    
    // Проверка, было ли действие обработано
    if (action.consumed) {
        // Действие уже обработано
    }
}
```

### FlingArgs
Параметры для жестов свайпа.

**Свойства:**
- `e1: MotionEvent` - начальное событие касания
- `e2: MotionEvent` - конечное событие касания
- `velocityX: Float` - скорость по оси X
- `velocityY: Float` - скорость по оси Y

**Пример использования:**
```kotlin
val flingArgs = FlingArgs(e1, e2, velocityX, velocityY)
val distanceX = e2.x - e1.x
val distanceY = e2.y - e1.y
val velocity = sqrt(velocityX * velocityX + velocityY * velocityY)
```

### CommonTouchCallbackMapping
Маппинг обратных вызовов касаний с поддержкой Flow.

**Пример использования:**
```kotlin
val scope = CoroutineScope(Dispatchers.Main)
val callbackMapping = CommonTouchCallbackMapping(scope)

// Подписка на действия
callbackMapping.action.collect { action ->
    when (action) {
        is TempleAction.Click -> {
            // Обработка касания
        }
        is TempleAction.SlideForward -> {
            // Обработка свайпа
        }
    }
}
```

## 🎨 UI компоненты

### BaseActivity
Базовая активность с автоматическим скрытием ActionBar.

**Особенности:**
- Автоматически скрывает ActionBar при создании
- Расширяет AppCompatActivity

**Пример использования:**
```kotlin
class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // ActionBar автоматически скрыт
    }
}
```

### BaseTouchActivity
Активность с полной поддержкой системы касаний.

**Основные возможности:**
- Интеграция с TouchDispatcher
- Обработка всех типов касаний
- Управление звуковыми эффектами
- Автоматическая обработка MotionEvent

**Переопределяемые методы:**
```kotlin
class MyTouchActivity : BaseTouchActivity() {
    override fun onClick(): Boolean {
        // Обработка одиночного касания
        return true
    }
    
    override fun onDoubleClick(): Boolean {
        // Обработка двойного касания
        return true
    }
    
    override fun onLongClick(): Boolean {
        // Обработка длительного касания
        return true
    }
    
    override fun onTPTripleClick() {
        // Обработка тройного касания
    }
    
    override fun onSlideForward(args: FlingArgs): Boolean {
        // Обработка свайпа вперед
        return true
    }
    
    override fun onSlideBackward(args: FlingArgs): Boolean {
        // Обработка свайпа назад
        return true
    }
    
    override fun onSlideContinuous(delta: Float, longClick: Boolean): Boolean {
        // Обработка непрерывного скольжения
        return true
    }
    
    override fun onMoveUp(isLongClick: Boolean): Boolean {
        // Обработка поднятия пальца
        return true
    }
    
    override fun onActionUp() {
        // Обработка завершения действия
    }
}
```

**Управление звуковыми эффектами:**
```kotlin
// Включение звукового эффекта
toggleSoundEffect(1, true)

// Отключение звукового эффекта
toggleSoundEffect(1, false)
```

**Получение MotionEventDispatcher:**
```kotlin
val motionEventDispatcher = motionEventDispatcher
// Использование для дополнительной обработки событий
```

### BaseMirrorActivity
Активность с поддержкой зеркального отображения для AR устройств.

**Особенности:**
- Поддержка стереоскопического отображения
- Автоматическое создание парных View
- Синхронизация состояния между экранами

### BaseMirrorFragment
Фрагмент с поддержкой зеркального отображения.

**Пример использования:**
```kotlin
class MyMirrorFragment : BaseMirrorFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Создание зеркального интерфейса
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}
```

### BaseEventActivity
Активность с поддержкой событий и ViewModel.

**Особенности:**
- Интеграция с ViewModel
- Поддержка событий через LiveData
- Автоматическое управление жизненным циклом

## 🖼️ Зеркальные компоненты

### MirrorContainerView
Контейнер с автоматическим зеркальным отображением для AR устройств.

**Основные возможности:**
- Автоматическое создание парных ViewBinding
- Горизонтальное расположение элементов
- Поддержка 3D эффектов
- Синхронизация состояния между экранами

**Конструкторы:**
```kotlin
MirrorContainerView(context: Context)
MirrorContainerView(context: Context, attrs: AttributeSet?)
MirrorContainerView(context: Context, attrs: AttributeSet?, defStyleAttr: Int)
```

**Основные методы:**
- `bindTo(bindingClz: Class<B>): BindingPair<B>` - привязка ViewBinding
- `getMBindingPair(): BindingPair<*>?` - получение пары привязок

**Пример использования:**
```kotlin
val mirrorContainer = MirrorContainerView(this)
val bindingPair = mirrorContainer.bindTo(MyLayoutBinding::class.java)

// Настройка левого экрана
bindingPair.left.title.text = "Левый экран"
bindingPair.left.button.setOnClickListener {
    // Обработка нажатия на левом экране
}

// Настройка правого экрана
bindingPair.right.title.text = "Правый экран"
bindingPair.right.button.setOnClickListener {
    // Обработка нажатия на правом экране
}

// Применение 3D эффекта
BindingPairKt.make3DEffect(
    bindingPair.left.root,
    bindingPair.right.root,
    enabled = true,
    depth = 8.0f
)
```

**Синхронизация состояния:**
```kotlin
// Обновление обоих экранов одновременно
bindingPair.update { binding ->
    binding.title.text = "Обновленный текст"
    binding.progressBar.progress = 50
}

// Обновление только левого экрана
bindingPair.setLeft { binding ->
    binding.status.text = "Статус: Активен"
}
```

### BaseMirrorContainerView
Базовый абстрактный класс для зеркальных контейнеров.

**Особенности:**
- Абстрактный класс для создания кастомных зеркальных компонентов
- Поддержка базовой функциональности зеркального отображения
- Возможность расширения для специфичных нужд

**Пример реализации:**
```kotlin
class CustomMirrorContainer : BaseMirrorContainerView {
    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)
    
    override fun initMirrorView() {
        // Инициализация зеркального отображения
    }
    
    override fun syncState() {
        // Синхронизация состояния между экранами
    }
}
```

### Зеркальные компоненты в диалогах

**Использование в FDialog:**
```kotlin
val dialog = FDialog.Builder<MyDialogBinding>(this, R.style.DialogTheme)
    .setContentView(
        bindingClz = MyDialogBinding::class.java,
        initViewBlock = { bindingPair, dialog ->
            // Настройка левого экрана
            bindingPair.left.title.text = "Подтверждение"
            bindingPair.left.message.text = "Вы уверены?"
            
            // Настройка правого экрана
            bindingPair.right.title.text = "Confirmation"
            bindingPair.right.message.text = "Are you sure?"
            
            // Применение 3D эффекта
            BindingPairKt.make3DEffect(
                bindingPair.left.root,
                bindingPair.right.root,
                enabled = true,
                depth = 10.0f
            )
        }
    )
    .build()
```

### Зеркальные компоненты в тостах

**Использование в FToast:**
```kotlin
FToast.showCustom(
    msg = "Уведомление",
    bindingClz = MyToastBinding::class.java
) { bindingPair, message ->
    // Настройка левого экрана
    bindingPair.left.message.text = message
    bindingPair.left.icon.setImageResource(R.drawable.ic_info)
    
    // Настройка правого экрана
    bindingPair.right.message.text = message
    bindingPair.right.icon.setImageResource(R.drawable.ic_info)
}
```

### 3D эффекты

**Применение 3D эффектов:**
```kotlin
// Включение 3D эффекта
BindingPairKt.make3DEffect(
    leftView = leftScreen.root,
    rightView = rightScreen.root,
    enabled = true,
    depth = 8.0f
)

// Отключение 3D эффекта
BindingPairKt.make3DEffect(
    leftView = leftScreen.root,
    rightView = rightScreen.root,
    enabled = false,
    depth = 0.0f
)
```

**Настройка глубины эффекта:**
```kotlin
// Легкий 3D эффект
val lightDepth = 4.0f

// Средний 3D эффект
val mediumDepth = 8.0f

// Сильный 3D эффект
val strongDepth = 12.0f
```

## 💬 Диалоги и уведомления

### FDialog
Кастомный диалог с поддержкой зеркального отображения и системы касаний.

**Основные возможности:**
- Поддержка зеркального отображения
- Интеграция с системой касаний
- Builder паттерн для конфигурации
- Обработка событий через TempleAction
- Поддержка FocusTracker

**Builder методы:**
```kotlin
val dialog = FDialog.Builder<MyDialogBinding>(this, R.style.DialogTheme)
    .setContentView(
        bindingClz = MyDialogBinding::class.java,
        initViewBlock = { bindingPair, dialog ->
            // Настройка интерфейса
        }
    )
    .setCancelable(true)
    .setCanceledOnTouchOutside(false)
    .setOnDismissListener { dialog ->
        // Обработка закрытия диалога
    }
    .setOnShowListener { dialog ->
        // Обработка показа диалога
    }
    .setEventHandler { action, dialog ->
        // Обработка событий касаний
        when (action) {
            is TempleAction.Click -> {
                // Обработка касания
            }
            is TempleAction.SlideForward -> {
                // Обработка свайпа вперед
            }
        }
    }
    .setFocusTracker(focusTracker)
    .build()
```

**Полный пример использования:**
```kotlin
class MyActivity : BaseTouchActivity() {
    fun showCustomDialog() {
        val focusTracker = FocusTracker()
        
        val dialog = FDialog.Builder<DialogLayoutBinding>(this, R.style.CustomDialog)
            .setContentView(
                bindingClz = DialogLayoutBinding::class.java,
                initViewBlock = { bindingPair, dialog ->
                    // Настройка левого экрана
                    bindingPair.left.title.text = "Подтверждение"
                    bindingPair.left.message.text = "Вы уверены, что хотите продолжить?"
                    bindingPair.left.confirmButton.text = "Да"
                    bindingPair.left.cancelButton.text = "Нет"
                    
                    // Настройка правого экрана
                    bindingPair.right.title.text = "Confirmation"
                    bindingPair.right.message.text = "Are you sure you want to continue?"
                    bindingPair.right.confirmButton.text = "Yes"
                    bindingPair.right.cancelButton.text = "No"
                    
                    // Применение 3D эффекта
                    BindingPairKt.make3DEffect(
                        bindingPair.left.root,
                        bindingPair.right.root,
                        enabled = true,
                        depth = 10.0f
                    )
                    
                    // Обработчики кнопок
                    bindingPair.left.confirmButton.setOnClickListener {
                        // Действие подтверждения
                        dialog.dismiss()
                    }
                    
                    bindingPair.left.cancelButton.setOnClickListener {
                        // Действие отмены
                        dialog.dismiss()
                    }
                }
            )
            .setCancelable(true)
            .setCanceledOnTouchOutside(false)
            .setOnDismissListener { dialog ->
                // Очистка ресурсов при закрытии
            }
            .setEventHandler { action, dialog ->
                when (action) {
                    is TempleAction.SlideForward -> {
                        // Переход к следующему элементу фокуса
                        focusTracker.next()
                    }
                    is TempleAction.SlideBackward -> {
                        // Переход к предыдущему элементу фокуса
                        focusTracker.previous()
                    }
                    is TempleAction.Click -> {
                        // Активация текущего элемента фокуса
                        focusTracker.getCurrentFocusItem()?.getEventHandler()?.invoke(action, dialog)
                    }
                }
            }
            .setFocusTracker(focusTracker)
            .build()
        
        dialog.show()
    }
}
```

### FToast
Кастомные уведомления с поддержкой зеркального отображения.

**Основные методы:**
```kotlin
// Простое уведомление
FToast.show("Простое сообщение")

// Уведомление с настройками
FToast.show(
    msg = "Настроенное сообщение",
    short = false, // Длительное отображение
    yOffset = 200 // Смещение по Y
)

// Уведомление с ресурсом
FToast.show(R.string.message_text)

// Кастомное уведомление
FToast.showCustom(
    msg = "Кастомное сообщение",
    bindingClz = MyToastBinding::class.java
) { bindingPair, message ->
    // Настройка интерфейса
    bindingPair.left.message.text = message
    bindingPair.left.icon.setImageResource(R.drawable.ic_success)
    
    bindingPair.right.message.text = message
    bindingPair.right.icon.setImageResource(R.drawable.ic_success)
}
```

**Примеры использования:**
```kotlin
// Успешное уведомление
FToast.showCustom(
    msg = "Операция выполнена успешно!",
    bindingClz = SuccessToastBinding::class.java
) { bindingPair, message ->
    bindingPair.left.message.text = message
    bindingPair.left.icon.setImageResource(R.drawable.ic_success)
    bindingPair.left.root.setBackgroundColor(Color.GREEN)
    
    bindingPair.right.message.text = message
    bindingPair.right.icon.setImageResource(R.drawable.ic_success)
    bindingPair.right.root.setBackgroundColor(Color.GREEN)
}

// Уведомление об ошибке
FToast.showCustom(
    msg = "Произошла ошибка!",
    bindingClz = ErrorToastBinding::class.java
) { bindingPair, message ->
    bindingPair.left.message.text = message
    bindingPair.left.icon.setImageResource(R.drawable.ic_error)
    bindingPair.left.root.setBackgroundColor(Color.RED)
    
    bindingPair.right.message.text = message
    bindingPair.right.icon.setImageResource(R.drawable.ic_error)
    bindingPair.right.root.setBackgroundColor(Color.RED)
}

// Информационное уведомление
FToast.showCustom(
    msg = "Новая информация доступна",
    bindingClz = InfoToastBinding::class.java
) { bindingPair, message ->
    bindingPair.left.message.text = message
    bindingPair.left.icon.setImageResource(R.drawable.ic_info)
    bindingPair.left.root.setBackgroundColor(Color.BLUE)
    
    bindingPair.right.message.text = message
    bindingPair.right.icon.setImageResource(R.drawable.ic_info)
    bindingPair.right.root.setBackgroundColor(Color.BLUE)
}
```

**Настройка позиции и длительности:**
```kotlin
// Короткое уведомление в верхней части экрана
FToast.show(
    msg = "Короткое уведомление",
    short = true,
    yOffset = 100
)

// Длительное уведомление в центре экрана
FToast.show(
    msg = "Длительное уведомление",
    short = false,
    yOffset = 0
)

// Уведомление в нижней части экрана
FToast.show(
    msg = "Нижнее уведомление",
    short = true,
    yOffset = 300
)
```

## 📋 Адаптеры и привязки данных

### BaseBindingAdapter
Базовый адаптер с поддержкой ViewBinding для типизированной работы с данными.

**Основные возможности:**
- Поддержка ViewBinding
- Типизированные адаптеры
- Автоматическое управление жизненным циклом View

**Пример реализации:**
```kotlin
class MyAdapter : BaseBindingAdapter<MyItem, MyItemBinding>() {
    
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = MyItemBinding.inflate(
            LayoutInflater.from(parent.context), 
            parent, 
            false
        )
        return MyViewHolder(binding)
    }
    
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
    
    class MyViewHolder(private val binding: MyItemBinding) : 
        RecyclerView.ViewHolder(binding.root) {
        
        fun bind(item: MyItem) {
            binding.title.text = item.title
            binding.description.text = item.description
            binding.icon.setImageResource(item.iconRes)
            
            binding.root.setOnClickListener {
                // Обработка нажатия
            }
        }
    }
}
```

### BaseBindingHolder
Базовый холдер с интеграцией ViewBinding.

**Пример использования:**
```kotlin
class CustomViewHolder(binding: CustomItemBinding) : 
    BaseBindingHolder<CustomItemBinding>(binding) {
    
    override fun bind(item: CustomItem) {
        binding.title.text = item.title
        binding.progressBar.progress = item.progress
        
        // Настройка состояния фокуса
        binding.root.isSelected = item.isSelected
    }
    
    override fun onFocusChanged(hasFocus: Boolean) {
        binding.root.isSelected = hasFocus
        if (hasFocus) {
            binding.root.setBackgroundColor(Color.BLUE)
        } else {
            binding.root.setBackgroundColor(Color.TRANSPARENT)
        }
    }
}
```

### SimpleBindingAdapter
Упрощенный адаптер для простых случаев использования.

**Пример использования:**
```kotlin
class SimpleAdapter : SimpleBindingAdapter<String, SimpleItemBinding>() {
    
    override fun onBindViewHolder(holder: SimpleViewHolder, position: Int) {
        val item = getItem(position)
        holder.binding.textView.text = item
    }
    
    class SimpleViewHolder(binding: SimpleItemBinding) : 
        RecyclerView.ViewHolder(binding.root) {
        val binding = binding
    }
}

// Использование
val adapter = SimpleAdapter()
adapter.submitList(listOf("Item 1", "Item 2", "Item 3"))
recyclerView.adapter = adapter
```

### Интеграция с RecyclerViewFocusTracker

**Пример адаптера с поддержкой фокуса:**
```kotlin
class FocusableAdapter : BaseBindingAdapter<FocusableItem, FocusableItemBinding>() {
    
    private var focusTracker: RecyclerViewFocusTracker? = null
    
    fun setFocusTracker(tracker: RecyclerViewFocusTracker) {
        this.focusTracker = tracker
    }
    
    override fun onBindViewHolder(holder: FocusableViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, position)
    }
    
    class FocusableViewHolder(binding: FocusableItemBinding) : 
        RecyclerView.ViewHolder(binding.root) {
        
        fun bind(item: FocusableItem, position: Int) {
            binding.title.text = item.title
            binding.description.text = item.description
            
            // Проверка состояния фокуса
            val isSelected = focusTracker?.checkPosSelected(position) ?: false
            binding.root.isSelected = isSelected
            
            if (isSelected) {
                binding.root.setBackgroundColor(Color.BLUE)
                binding.title.setTextColor(Color.WHITE)
            } else {
                binding.root.setBackgroundColor(Color.TRANSPARENT)
                binding.title.setTextColor(Color.BLACK)
            }
        }
    }
}

// Использование с фокусом
val adapter = FocusableAdapter()
val focusTracker = RecyclerViewFocusTracker(viewPair, loop = true)
adapter.setFocusTracker(focusTracker)

// Обработка действий
focusTracker.handleActionEvent(action) { templeAction ->
    when (templeAction) {
        is TempleAction.Click -> {
            val selectedPos = focusTracker.checkedSelectPos()
            if (selectedPos >= 0) {
                val item = adapter.getItem(selectedPos)
                // Обработка выбора элемента
            }
        }
    }
}
```

### Зеркальные адаптеры

**Адаптер с зеркальным отображением:**
```kotlin
class MirrorAdapter : BaseBindingAdapter<MirrorItem, MirrorItemBinding>() {
    
    override fun onBindViewHolder(holder: MirrorViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }
    
    class MirrorViewHolder(binding: MirrorItemBinding) : 
        RecyclerView.ViewHolder(binding.root) {
        
        fun bind(item: MirrorItem) {
            // Настройка левого экрана
            binding.leftTitle.text = item.leftTitle
            binding.leftIcon.setImageResource(item.leftIcon)
            
            // Настройка правого экрана
            binding.rightTitle.text = item.rightTitle
            binding.rightIcon.setImageResource(item.rightIcon)
            
            // Применение 3D эффекта
            BindingPairKt.make3DEffect(
                binding.leftContainer,
                binding.rightContainer,
                enabled = true,
                depth = 6.0f
            )
        }
    }
}
```

### Слушатели событий

**Настройка слушателей:**
```kotlin
// Слушатель фокуса на элементе
focusTracker.setOnItemFocusListener { position, view ->
    // Анимация при получении фокуса
    view.animate()
        .scaleX(1.1f)
        .scaleY(1.1f)
        .setDuration(200)
        .start()
}

// Слушатель изменения фокуса
focusTracker.setOnFocusChangeListener { hasFocus ->
    if (hasFocus) {
        // Активация трекера
    } else {
        // Деактивация трекера
    }
}

// Слушатель Pull-to-Refresh
focusTracker.setRefreshListener {
    // Обновление данных
    loadMoreData()
}
```

## 🔧 Утилиты и расширения

### ViewExtensionKt
Расширения для View с полезными утилитами.

**Основные функции:**
- Конвертация dp в px
- Работа с размерами
- Утилиты для позиционирования

**Примеры использования:**
```kotlin
// Конвертация dp в px
val pixels = ViewExtensionKt.getDp(16) // 16dp в пиксели

// Получение размера экрана
val screenWidth = ViewExtensionKt.getScreenWidth(context)
val screenHeight = ViewExtensionKt.getScreenHeight(context)

// Работа с размерами View
view.post {
    val viewWidth = view.width
    val viewHeight = view.height
    val centerX = viewWidth / 2
    val centerY = viewHeight / 2
}
```

### FLogger
Система логирования с различными уровнями.

**Уровни логирования:**
- `FLogger.d()` - Debug
- `FLogger.v()` - Verbose
- `FLogger.i()` - Info
- `FLogger.e()` - Error

**Примеры использования:**
```kotlin
// Простое логирование
FLogger.d("MyTag", "Debug message")
FLogger.i("MyTag", "Info message")
FLogger.e("MyTag", "Error message")

// Логирование с исключением
FLogger.e("MyTag", "Error occurred", exception)

// Логирование с дополнительными параметрами
FLogger.d("TouchDispatcher", "Touch event: x=${event.x}, y=${event.y}")

// Логирование состояния
FLogger.i("FocusTracker", "Focus changed: hasFocus=$hasFocus")
```

**Настройка логирования:**
```kotlin
// Включение/отключение логирования
FLogger.setEnabled(true) // Включить логирование
FLogger.setEnabled(false) // Отключить логирование

// Настройка уровня логирования
FLogger.setLogLevel(FLogger.LEVEL_DEBUG) // Показать все логи
FLogger.setLogLevel(FLogger.LEVEL_ERROR) // Показать только ошибки
```

### MyTouchUtils
Утилиты для работы с касаниями.

**Основные функции:**
- Определение правого касания
- Проверка на тестовые касания (monkey)
- Утилиты для анализа событий касаний

**Примеры использования:**
```kotlin
// Проверка правого касания
if (MyTouchUtils.isRight(event)) {
    // Обработка правого касания
}

// Проверка на тестовые касания
if (MyTouchUtils.isMonkey()) {
    // Игнорировать или обработать по-другому
}

// Анализ события касания
val isTouchDown = event.action == MotionEvent.ACTION_DOWN
val isTouchUp = event.action == MotionEvent.ACTION_UP
val isTouchMove = event.action == MotionEvent.ACTION_MOVE

// Получение информации о касании
val touchX = event.x
val touchY = event.y
val pressure = event.pressure
val size = event.size
```

### StartSnapHelper
Улучшенный помощник для SnapHelper в RecyclerView.

**Основные возможности:**
- Улучшенная прокрутка
- Поддержка различных типов SnapHelper
- Кастомизация поведения прокрутки

**Пример использования:**
```kotlin
// Создание StartSnapHelper
val snapHelper = StartSnapHelper()

// Привязка к RecyclerView
snapHelper.attachToRecyclerView(recyclerView)

// Настройка поведения
snapHelper.setSnapToStart(true) // Привязка к началу
snapHelper.setSnapToEnd(false) // Не привязывать к концу
```

### Утилиты для работы с парами

**BaseMirrorAction**
Базовый класс для действий с зеркальными компонентами.

**Пример использования:**
```kotlin
class MyMirrorAction(left: MyView, right: MyView) : 
    BaseMirrorAction<MyView>(left, right) {
    
    fun updateTitle(title: String) {
        update { view ->
            view.title.text = title
        }
    }
    
    fun updateLeftOnly(block: (MyView) -> Unit) {
        setLeft(block)
    }
    
    fun isLeftView(view: MyView): Boolean {
        return checkIsLeft(view)
    }
}
```

### Утилиты для работы с событиями

**MotionEventDispatcher**
Диспетчер событий движения с логированием.

**Пример использования:**
```kotlin
val dispatcher = MotionEventDispatcher("MyActivity")

// Диспетчеризация события
dispatcher.dispatchTouchEvent(event)

// Логирование будет автоматическим
// [MyActivity] Touch event: x=100, y=200, action=ACTION_DOWN
```

### Утилиты для работы с размерами

**Конвертация размеров:**
```kotlin
// dp в px
val pixels = context.resources.displayMetrics.density * dp

// px в dp
val dp = pixels / context.resources.displayMetrics.density

// sp в px
val pixels = context.resources.displayMetrics.scaledDensity * sp

// px в sp
val sp = pixels / context.resources.displayMetrics.scaledDensity
```

**Работа с экраном:**
```kotlin
// Получение размеров экрана
val displayMetrics = context.resources.displayMetrics
val screenWidth = displayMetrics.widthPixels
val screenHeight = displayMetrics.heightPixels

// Получение плотности экрана
val density = displayMetrics.density
val scaledDensity = displayMetrics.scaledDensity

// Проверка ориентации
val isLandscape = screenWidth > screenHeight
val isPortrait = screenHeight > screenWidth
```

### Утилиты для работы с цветами

**Работа с цветами:**
```kotlin
// Получение цвета из ресурсов
val color = ContextCompat.getColor(context, R.color.my_color)

// Создание цвета с прозрачностью
val transparentColor = Color.argb(128, 255, 0, 0) // Полупрозрачный красный

// Изменение прозрачности цвета
val originalColor = Color.RED
val alpha = 128
val transparentColor = Color.argb(alpha, Color.red(originalColor), 
    Color.green(originalColor), Color.blue(originalColor))
```

## 🎮 Игровые компоненты

### KeyguardUtils
Утилиты для работы с блокировкой экрана.

**Основные возможности:**
- Управление состоянием блокировки экрана
- Проверка состояния блокировки
- Взаимодействие с системными настройками

**Примеры использования:**
```kotlin
// Проверка, заблокирован ли экран
val isKeyguardLocked = KeyguardUtils.isKeyguardLocked(context)

// Проверка, защищен ли экран паролем
val isKeyguardSecure = KeyguardUtils.isKeyguardSecure(context)

// Получение KeyguardManager
val keyguardManager = KeyguardUtils.getKeyguardManager(context)

// Проверка, можно ли отключить блокировку
val canDisableKeyguard = KeyguardUtils.canDisableKeyguard(context)
```

### MotionEventDispatcher
Диспетчер событий движения с расширенным логированием.

**Основные возможности:**
- Логирование всех событий касаний
- Отслеживание координат и времени
- Интеграция с системой логирования

**Пример использования:**
```kotlin
val dispatcher = MotionEventDispatcher("GameActivity")

// Диспетчеризация события касания
dispatcher.dispatchTouchEvent(event)

// Автоматическое логирование будет включать:
// - Координаты касания (x, y)
// - Тип действия (ACTION_DOWN, ACTION_UP, ACTION_MOVE)
// - ID устройства
// - Имя устройства
// - Время нажатия и события
```

**Пример лога:**
```
[GameActivity] Touch event: x=150, y=300, action=ACTION_DOWN, 
deviceId=1, deviceName=TouchScreen, downTime=1234567890, eventTime=1234567890
```

### Интеграция с игровыми компонентами

**Обработка игровых событий:**
```kotlin
class GameActivity : BaseTouchActivity() {
    
    private lateinit var gameEngine: GameEngine
    private lateinit var motionEventDispatcher: MotionEventDispatcher
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        
        gameEngine = GameEngine()
        motionEventDispatcher = MotionEventDispatcher("GameActivity")
        
        // Настройка игрового движка
        setupGameEngine()
    }
    
    override fun onTouchEvent(event: MotionEvent): Boolean {
        // Диспетчеризация события для логирования
        motionEventDispatcher.dispatchTouchEvent(event)
        
        // Обработка игровых событий
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                gameEngine.onTouchDown(event.x, event.y)
            }
            MotionEvent.ACTION_MOVE -> {
                gameEngine.onTouchMove(event.x, event.y)
            }
            MotionEvent.ACTION_UP -> {
                gameEngine.onTouchUp(event.x, event.y)
            }
        }
        
        return super.onTouchEvent(event)
    }
    
    override fun onClick(): Boolean {
        // Обработка одиночного касания в игре
        gameEngine.onClick()
        return true
    }
    
    override fun onDoubleClick(): Boolean {
        // Обработка двойного касания в игре
        gameEngine.onDoubleClick()
        return true
    }
    
    override fun onLongClick(): Boolean {
        // Обработка длительного касания в игре
        gameEngine.onLongClick()
        return true
    }
    
    override fun onSlideForward(args: FlingArgs): Boolean {
        // Обработка свайпа вперед в игре
        gameEngine.onSwipeForward(args.velocityX, args.velocityY)
        return true
    }
    
    override fun onSlideBackward(args: FlingArgs): Boolean {
        // Обработка свайпа назад в игре
        gameEngine.onSwipeBackward(args.velocityX, args.velocityY)
        return true
    }
    
    private fun setupGameEngine() {
        // Настройка игрового движка
        gameEngine.setTouchSensitivity(1.5f)
        gameEngine.setSoundEnabled(true)
        gameEngine.setVibrationEnabled(true)
    }
}
```

### Звуковые эффекты для игр

**Управление звуковыми эффектами:**
```kotlin
// Включение звуковых эффектов
toggleSoundEffect(1, true) // Тип 1 - стандартный звук
toggleSoundEffect(2, true) // Тип 2 - игровой звук
toggleSoundEffect(3, true) // Тип 3 - звук победы

// Отключение звуковых эффектов
toggleSoundEffect(1, false)
toggleSoundEffect(2, false)
toggleSoundEffect(3, false)
```

### Система событий для игр

**Обработка игровых действий:**
```kotlin
class GameEventHandler {
    
    fun handleGameAction(action: TempleAction) {
        when (action) {
            is TempleAction.Click -> {
                // Простое нажатие - выстрел
                gameEngine.fire()
            }
            is TempleAction.DoubleClick -> {
                // Двойное нажатие - двойной выстрел
                gameEngine.doubleFire()
            }
            is TempleAction.LongClick -> {
                // Длительное нажатие - прицеливание
                gameEngine.aim()
            }
            is TempleAction.SlideForward -> {
                // Свайп вперед - движение вперед
                gameEngine.moveForward()
            }
            is TempleAction.SlideBackward -> {
                // Свайп назад - движение назад
                gameEngine.moveBackward()
            }
            is TempleAction.SlideContinuous -> {
                // Непрерывное скольжение - поворот
                gameEngine.rotate(action.delta)
            }
        }
    }
}
```

### Интеграция с AR функциями

**Использование AR возможностей в играх:**
```kotlin
class ARGameActivity : BaseTouchActivity() {
    
    private lateinit var arRenderer: ARRenderer
    private lateinit var mirrorContainer: MirrorContainerView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ar_game)
        
        setupARRenderer()
        setupMirrorDisplay()
    }
    
    private fun setupARRenderer() {
        arRenderer = ARRenderer()
        arRenderer.setStereoMode(true)
        arRenderer.setDepthEnabled(true)
    }
    
    private fun setupMirrorDisplay() {
        mirrorContainer = findViewById(R.id.mirror_container)
        val bindingPair = mirrorContainer.bindTo(GameLayoutBinding::class.java)
        
        // Настройка левого экрана (левый глаз)
        bindingPair.left.gameView.setRenderer(arRenderer.getLeftRenderer())
        
        // Настройка правого экрана (правый глаз)
        bindingPair.right.gameView.setRenderer(arRenderer.getRightRenderer())
        
        // Применение 3D эффекта для стереоскопического отображения
        BindingPairKt.make3DEffect(
            bindingPair.left.root,
            bindingPair.right.root,
            enabled = true,
            depth = 15.0f
        )
    }
    
    override fun onSlideContinuous(delta: Float, longClick: Boolean): Boolean {
        // Поворот камеры в AR
        arRenderer.rotateCamera(delta)
        return true
    }
}
```

## 🔄 Система пар

### ViewPair
Пара View для зеркального отображения с синхронизированным обновлением.

**Основные возможности:**
- Синхронизированное обновление левого и правого View
- Поддержка типизированных пар
- Автоматическое управление состоянием

**Конструктор:**
```kotlin
ViewPair<T>(left: T, right: T)
```

**Основные методы:**
- `getLeft(): T` - получение левого элемента
- `getRight(): T` - получение правого элемента
- `update(block: (T) -> Unit)` - обновление обоих элементов
- `setLeft(block: (T) -> Unit)` - обновление только левого элемента

**Пример использования:**
```kotlin
val leftView = findViewById<TextView>(R.id.left_text)
val rightView = findViewById<TextView>(R.id.right_text)
val viewPair = ViewPair(leftView, rightView)

// Обновление обоих View одновременно
viewPair.update { textView ->
    textView.text = "Обновленный текст"
    textView.setTextColor(Color.BLUE)
}

// Обновление только левого View
viewPair.setLeft { textView ->
    textView.text = "Только левый"
}
```

### BindingPair
Пара ViewBinding для работы с привязками данных.

**Основные возможности:**
- Синхронизация привязок данных
- Поддержка 3D эффектов
- Автоматическое создание парных привязок

**Пример использования:**
```kotlin
val bindingPair = BindingPair(leftBinding, rightBinding)

// Обновление обоих привязок
bindingPair.update { binding ->
    binding.title.text = "Новый заголовок"
    binding.progressBar.progress = 75
}

// Применение 3D эффекта
BindingPairKt.make3DEffect(
    bindingPair.left.root,
    bindingPair.right.root,
    enabled = true,
    depth = 8.0f
)
```

### HolderPair
Пара холдеров для RecyclerView.

**Пример использования:**
```kotlin
class MirrorViewHolder(leftBinding: ItemBinding, rightBinding: ItemBinding) : 
    RecyclerView.ViewHolder(MirrorContainerView(context)) {
    
    private val holderPair = HolderPair(
        LeftViewHolder(leftBinding),
        RightViewHolder(rightBinding)
    )
    
    fun bind(item: MirrorItem) {
        // Обновление обоих холдеров
        holderPair.update { holder ->
            holder.bind(item)
        }
    }
}
```

### AnyPair
Универсальная пара для любых объектов.

**Пример использования:**
```kotlin
val stringPair = AnyPair("Левая строка", "Правая строка")
val intPair = AnyPair(100, 200)

// Обновление значений
stringPair.update { value ->
    // Обновление обоих значений
}

// Проверка левого элемента
val isLeft = stringPair.checkIsLeft("Левая строка")
```

### Синхронизация состояния

**Автоматическая синхронизация:**
```kotlin
class MirrorStateManager {
    private val viewPair = ViewPair(leftView, rightView)
    private val bindingPair = BindingPair(leftBinding, rightBinding)
    
    fun updateState(newState: AppState) {
        // Синхронизация View
        viewPair.update { view ->
            view.visibility = if (newState.isVisible) View.VISIBLE else View.GONE
        }
        
        // Синхронизация привязок
        bindingPair.update { binding ->
            binding.title.text = newState.title
            binding.subtitle.text = newState.subtitle
        }
    }
    
    fun updateLeftOnly(block: (View) -> Unit) {
        viewPair.setLeft(block)
    }
}
```

### Работа с коллекциями

**Синхронизация списков:**
```kotlin
class MirrorListManager {
    private val leftAdapter = MyAdapter()
    private val rightAdapter = MyAdapter()
    private val adapterPair = AnyPair(leftAdapter, rightAdapter)
    
    fun updateList(newItems: List<MyItem>) {
        adapterPair.update { adapter ->
            adapter.submitList(newItems)
        }
    }
    
    fun updateItem(position: Int, item: MyItem) {
        adapterPair.update { adapter ->
            adapter.notifyItemChanged(position)
        }
    }
}
```

## 🔊 Звуковые эффекты

### GestureDetectorWithSound
Детектор жестов со встроенной поддержкой звуковых эффектов.

**Основные возможности:**
- Звуковые эффекты при касаниях
- Настройка типов звуков
- Интеграция с системными настройками
- Поддержка различных жестов

**Пример использования:**
```kotlin
val gestureDetector = GestureDetectorWithSound(
    context = this,
    leftListener = leftGestureListener,
    rightListener = rightGestureListener
)

// Настройка для глобальных событий
gestureDetector.a()

// Настройка для событий Activity
gestureDetector.a(3)
```

### Управление звуковыми эффектами

**Включение/отключение звуков:**
```kotlin
// Включение звукового эффекта
gestureDetector.b(soundType)

// Отключение звукового эффекта
gestureDetector.a(soundType)
```

**Типы звуковых эффектов:**
```kotlin
// Тип 1 - стандартный звук касания
val SOUND_TYPE_CLICK = 1

// Тип 2 - звук двойного касания
val SOUND_TYPE_DOUBLE_CLICK = 2

// Тип 3 - звук длительного касания
val SOUND_TYPE_LONG_CLICK = 3

// Тип 4 - звук свайпа
val SOUND_TYPE_SWIPE = 4
```

### Интеграция с TouchDispatcher

**Автоматическое управление звуками:**
```kotlin
class MyTouchActivity : BaseTouchActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // Включение звуковых эффектов
        toggleSoundEffect(1, true) // Стандартные касания
        toggleSoundEffect(2, true) // Двойные касания
        toggleSoundEffect(3, true) // Длительные касания
    }
    
    override fun onClick(): Boolean {
        // Звук будет воспроизведен автоматически
        return true
    }
    
    override fun onDoubleClick(): Boolean {
        // Звук двойного касания будет воспроизведен автоматически
        return true
    }
}
```

### Кастомизация звуков

**Настройка пользовательских звуков:**
```kotlin
class CustomSoundManager {
    
    fun setupCustomSounds() {
        // Настройка звуков для различных действий
        setupClickSound()
        setupSwipeSound()
        setupLongPressSound()
    }
    
    private fun setupClickSound() {
        // Настройка звука для одиночного касания
    }
    
    private fun setupSwipeSound() {
        // Настройка звука для свайпов
    }
    
    private fun setupLongPressSound() {
        // Настройка звука для длительного нажатия
    }
}
```

## 🥽 Специфичные для AR функции

### TempleAction для AR устройств
Специализированные действия для носимых AR устройств.

**Особенности AR действий:**
- Поддержка жестов щипка (pinch)
- Обработка длительных жестов
- Специализированные жесты для AR очков
- Интеграция с системой касаний

**Жесты щипка:**
```kotlin
// Обработка жеста щипка
override fun onKeyPinch() {
    // Увеличение/уменьшение масштаба в AR
    arRenderer.zoomIn()
}

// Обработка длительного жеста щипка
override fun onKeyLongPinch() {
    // Сброс масштаба в AR
    arRenderer.resetZoom()
}
```

### AR жесты и взаимодействия

**Специализированные жесты для AR:**
```kotlin
class ARGestureHandler {
    
    fun handleARGesture(action: TempleAction) {
        when (action) {
            is TempleAction.Click -> {
                // Выбор объекта в AR
                arScene.selectObject(action.x, action.y)
            }
            is TempleAction.DoubleClick -> {
                // Активация объекта в AR
                arScene.activateObject(action.x, action.y)
            }
            is TempleAction.LongClick -> {
                // Контекстное меню в AR
                arScene.showContextMenu(action.x, action.y)
            }
            is TempleAction.SlideForward -> {
                // Переход к следующему AR элементу
                arScene.nextElement()
            }
            is TempleAction.SlideBackward -> {
                // Переход к предыдущему AR элементу
                arScene.previousElement()
            }
            is TempleAction.SlideContinuous -> {
                // Поворот камеры в AR
                arCamera.rotate(action.delta)
            }
        }
    }
}
```

### Стереоскопическое отображение

**Поддержка 3D отображения:**
```kotlin
class ARDisplayManager {
    
    fun setupStereoDisplay() {
        // Настройка левого экрана (левый глаз)
        setupLeftEye()
        
        // Настройка правого экрана (правый глаз)
        setupRightEye()
        
        // Применение 3D эффектов
        apply3DEffects()
    }
    
    private fun setupLeftEye() {
        // Настройка рендерера для левого глаза
        leftRenderer.setEyeOffset(-eyeDistance / 2)
        leftRenderer.setFOV(leftEyeFOV)
    }
    
    private fun setupRightEye() {
        // Настройка рендерера для правого глаза
        rightRenderer.setEyeOffset(eyeDistance / 2)
        rightRenderer.setFOV(rightEyeFOV)
    }
    
    private fun apply3DEffects() {
        // Применение глубины и параллакса
        BindingPairKt.make3DEffect(
            leftView.root,
            rightView.root,
            enabled = true,
            depth = 15.0f
        )
    }
}
```

### AR навигация

**Навигация в AR пространстве:**
```kotlin
class ARNavigationManager {
    
    fun handleARNavigation(action: TempleAction) {
        when (action) {
            is TempleAction.SlideForward -> {
                // Движение вперед в AR
                arCamera.moveForward()
            }
            is TempleAction.SlideBackward -> {
                // Движение назад в AR
                arCamera.moveBackward()
            }
            is TempleAction.SlideContinuous -> {
                // Поворот в AR
                arCamera.rotate(action.delta)
            }
            is TempleAction.LongClick -> {
                // Телепортация в AR
                arCamera.teleport(action.x, action.y)
            }
        }
    }
    
    fun setupARControls() {
        // Настройка чувствительности AR контролов
        arCamera.setSensitivity(1.5f)
        arCamera.setSmoothMovement(true)
        arCamera.setCollisionDetection(true)
    }
}
```

## 📚 Примеры использования

### Полный пример AR приложения

**Основная активность:**
```kotlin
class ARMainActivity : BaseTouchActivity() {
    
    private lateinit var arRenderer: ARRenderer
    private lateinit var mirrorContainer: MirrorContainerView
    private lateinit var focusTracker: RecyclerViewFocusTracker
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ar_main)
        
        setupARComponents()
        setupMirrorDisplay()
        setupFocusTracker()
        setupSoundEffects()
    }
    
    private fun setupARComponents() {
        arRenderer = ARRenderer()
        arRenderer.setStereoMode(true)
        arRenderer.setDepthEnabled(true)
    }
    
    private fun setupMirrorDisplay() {
        mirrorContainer = findViewById(R.id.mirror_container)
        val bindingPair = mirrorContainer.bindTo(ARLayoutBinding::class.java)
        
        // Настройка левого экрана
        bindingPair.left.arView.setRenderer(arRenderer.getLeftRenderer())
        bindingPair.left.controlsView.setupLeftControls()
        
        // Настройка правого экрана
        bindingPair.right.arView.setRenderer(arRenderer.getRightRenderer())
        bindingPair.right.controlsView.setupRightControls()
        
        // Применение 3D эффекта
        BindingPairKt.make3DEffect(
            bindingPair.left.root,
            bindingPair.right.root,
            enabled = true,
            depth = 12.0f
        )
    }
    
    private fun setupFocusTracker() {
        val recyclerView = findViewById<RecyclerView>(R.id.ar_menu)
        val viewPair = ViewPair(recyclerView, recyclerView)
        focusTracker = RecyclerViewFocusTracker(viewPair, ignoreDelta = 30, loop = true)
        
        focusTracker.setOnItemFocusListener { position, view ->
            // Анимация при получении фокуса
            view.animate()
                .scaleX(1.1f)
                .scaleY(1.1f)
                .setDuration(200)
                .start()
        }
    }
    
    private fun setupSoundEffects() {
        // Включение звуковых эффектов
        toggleSoundEffect(1, true) // Касания
        toggleSoundEffect(2, true) // Двойные касания
        toggleSoundEffect(3, true) // Длительные касания
    }
    
    override fun onClick(): Boolean {
        // Обработка одиночного касания в AR
        arRenderer.handleClick()
        return true
    }
    
    override fun onDoubleClick(): Boolean {
        // Обработка двойного касания в AR
        arRenderer.handleDoubleClick()
        return true
    }
    
    override fun onLongClick(): Boolean {
        // Обработка длительного касания в AR
        arRenderer.handleLongClick()
        return true
    }
    
    override fun onSlideForward(args: FlingArgs): Boolean {
        // Обработка свайпа вперед в AR
        arRenderer.moveForward()
        return true
    }
    
    override fun onSlideBackward(args: FlingArgs): Boolean {
        // Обработка свайпа назад в AR
        arRenderer.moveBackward()
        return true
    }
    
    override fun onSlideContinuous(delta: Float, longClick: Boolean): Boolean {
        // Обработка непрерывного скольжения в AR
        arRenderer.rotate(delta)
        return true
    }
    
    override fun onKeyPinch() {
        // Обработка жеста щипка в AR
        arRenderer.zoomIn()
    }
    
    override fun onKeyLongPinch() {
        // Обработка длительного жеста щипка в AR
        arRenderer.resetZoom()
    }
}
```

### Пример диалога с AR поддержкой

**AR диалог:**
```kotlin
class ARDialogActivity : BaseTouchActivity() {
    
    fun showARDialog() {
        val focusTracker = FocusTracker()
        
        val dialog = FDialog.Builder<ARDialogBinding>(this, R.style.ARDialog)
            .setContentView(
                bindingClz = ARDialogBinding::class.java,
                initViewBlock = { bindingPair, dialog ->
                    // Настройка левого экрана
                    bindingPair.left.title.text = "AR Настройки"
                    bindingPair.left.option1.text = "Включить 3D"
                    bindingPair.left.option2.text = "Настройки звука"
                    
                    // Настройка правого экрана
                    bindingPair.right.title.text = "AR Settings"
                    bindingPair.right.option1.text = "Enable 3D"
                    bindingPair.right.option2.text = "Sound Settings"
                    
                    // Применение 3D эффекта
                    BindingPairKt.make3DEffect(
                        bindingPair.left.root,
                        bindingPair.right.root,
                        enabled = true,
                        depth = 10.0f
                    )
                }
            )
            .setEventHandler { action, dialog ->
                when (action) {
                    is TempleAction.SlideForward -> {
                        focusTracker.next()
                    }
                    is TempleAction.SlideBackward -> {
                        focusTracker.previous()
                    }
                    is TempleAction.Click -> {
                        val currentItem = focusTracker.getCurrentFocusItem()
                        currentItem?.getEventHandler()?.invoke(action, dialog)
                    }
                }
            }
            .setFocusTracker(focusTracker)
            .build()
        
        dialog.show()
    }
}
```

### Пример тоста с AR поддержкой

**AR уведомление:**
```kotlin
fun showARToast() {
    FToast.showCustom(
        msg = "AR объект загружен!",
        bindingClz = ARToastBinding::class.java
    ) { bindingPair, message ->
        // Настройка левого экрана
        bindingPair.left.message.text = message
        bindingPair.left.arIcon.setImageResource(R.drawable.ic_ar_success)
        bindingPair.left.root.setBackgroundColor(Color.GREEN)
        
        // Настройка правого экрана
        bindingPair.right.message.text = message
        bindingPair.right.arIcon.setImageResource(R.drawable.ic_ar_success)
        bindingPair.right.root.setBackgroundColor(Color.GREEN)
        
        // Применение 3D эффекта
        BindingPairKt.make3DEffect(
            bindingPair.left.root,
            bindingPair.right.root,
            enabled = true,
            depth = 6.0f
        )
    }
}
```

## 📄 Лицензия

```
MIT License

Copyright (c) 2024 RayNeo

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
```

---
