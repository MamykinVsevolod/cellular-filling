# Клеточное наполнение

Вы делаете приложение для демиурга Шамбамбукли. 

Создавая новый мир, он наполняет его клетками. Каждый раз, нажимая на кнопку в приложении, в список клеток добавляется новая:

— равновероятно она может быть как живой, так и мёртвой;

— жизнь зарождается, если до этого трижды подряд создалась живая клетка;

— если трижды подряд родилась мёртвая клетка, жизнь рядом умирает.

**В моей реализации "жизнь рядом умирает" означает, что ближайшая в списке "жизнь" меняет свой статус на "смерть", также меняестя иконка и текст**



Изначально список клеток пуст. 

Можно пользоваться сторонними библиотеками, например — Picasso, Glide.

Не нужно делать release-сборку, code shrinking, proguard, подписи для apk и выкладывать play store. Срок: два дня.



Макет: 

[Figma](https://www.figma.com/file/RNGiOtbn0Iiyjt82BwMXWX/%D0%9F%D1%80%D0%B8%D0%BB%D0%BE%D0%B6%D0%B5%D0%BD%D0%B8%D0%B5-%D0%B4%D0%BB%D1%8F-%D0%B4%D0%B5%D0%BC%D0%B8%D1%83%D1%80%D0%B3%D0%B0-%D0%A8%D0%B0%D0%BC%D0%B1%D0%B0%D0%BC%D0%B1%D1%83%D0%BA%D0%BB%D0%B8?node-id=0%3A1)

## Написано с использованием Jetpack Compose

## Структура проекта

```plaintext
app/
├── manifests/
│   └── AndroidManifest.xml
├── java/            
│   ├── com.example.cellular_filling/  
        ├── model/
        │   ├── RectangleItem.kt       
        │   └── RectangleType.kt
        ├── ui/
            ├── components/
            │   ├── Button.kt       
            │   ├── RectangleItemView.kt
            │   ├── RectangleListView.kt
            │   └── Title.kt
            ├── components/
            │   ├── Button.kt       
            │   ├── RectangleItemView.kt
            │   ├── RectangleListView.kt
            │   └── Title.kt
            ├── theme/
            │   ├── Color.kt
            │   ├── Theme.kt
            │   └── Type.kt
            ├── utils/
            │    ├── ColorUtils.kt
            │    ├── PictureUtils.kt
            │    ├── TextUtils.kt
            └── MainScreen.kt    
└── program2/            
    ├── CMakeLists.txt        
    └── main.cpp         
```
