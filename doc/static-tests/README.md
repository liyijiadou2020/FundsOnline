
# 1 ГЛАВА 1. СТАТИЧЕСКИЙ АНАЛИЗ

## 1.1 Инструмент статического анализа
При разработке Java-приложений нам часто необходимо обеспечить качество и согласованность нашего кода. Инструменты статической проверки могут помочь нам автоматически анализировать и проверять код, чтобы найти потенциальные ошибки и точки улучшения. Ради простоты использования и языковой совместимости в этом проекте я выбрал два инструмента для статического анализа: Checkstyle и IDEA.
### 1.1.1 Инструмент статической проверки Checkstyle
Checkstyle был впервые выпущен в 2001 году и в настоящее время является самым популярным (★4,6 тыс.) и постоянно активным инструментом статического анализа Java на GitHub. Данный инструмент в основном ориентирован на проверку стиля кода, в настоящее время поддерживает 14 категорий и 162 правел проверки(см. приложние 1), предоставляет файлы конфигурации, соответствующие спецификациям стиля кода Google/Sun, а также поддерживает гибкую настройку и расширение. Checkstyle имеет богатые методы интеграции: CLI (командная строка), поддержка инструментов сборки, поддержка IDE и т. д. В этом проекте инструмент Checkstyle будет использоваться в виде плагина IDEA.

|         | Checkstyle                                                |
| ------- | --------------------------------------------------------- |
| Version | 5.87.1                                                    |
| Source  | https://plugins.jetbrains.com/plugin/1065-checkstyle-idea |

### 1.1.2 IDEA
IntelliJ IDEA — это интегрированная среда для разработки языка Java. IntelliJ признан одним из лучших инструментов разработки Java в отрасли, особенно с точки зрения интеллектуальных помощников по написанию кода, автоматических подсказок кода, рефакторинга, поддержки J2EE, проверки кода и других функций, которые могут можно сказать, экстраординарный. 

IntelliJ IDEA предоставляет инструмент статической проверки под названием «Инспекции», который может помочь разработчикам обнаружить потенциальные проблемы кода в процессе разработки. Включив этот инструмент, IDEA найдет возможные ошибки, лазейки, неправильные коды и т. д. в коде и предоставит функции автоматического исправления, чтобы сделать код более устойчивым, надежным и эффективным.

|         | IDEA                       |
| ------- | -------------------------- |
| Version | 2023.2.2 Education Version |
| Source  | https://idea.jeter.eu.org/ |


## 1.2 Установка и конфигурирование Checkstyle

### 1.2.1 Установка
Процесс установки:
1. Сначала откроем плагины в настройках в строке меню IDEA, найдите CheckStyle-IDEA и установите его.

![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041155438.png)

2. Импортчеккстиле Checkstyle
Найдем CheckStyle в настройках и импортируем файл конфигурации `checkstyle.xml`, как показано ниже:
![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041201166.png)

![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041206729.png)

### 1.2.2 Конфигурирование
Checkstyle получает файл конфигурации из XML-документа, элементы которого определяют иерархию модулей конфигурации и их свойства. Содержимое нашего файла конфигурации `checkstyle.xml` следующее:

```xml
<?xml version="1.0"?>
<!DOCTYPE module PUBLIC
        "-//Puppy Crawl//DTD Check Configuration 1.3//EN"
        "http://www.puppycrawl.com/dtds/configuration_1_3.dtd">

<module name="Checker">
    <module name="NewlineAtEndOfFile"/>

    <module name="Translation"/>

    <module name="FileLength">
        <property name="max" value="1500"/>
    </module>

    <module name="FileTabCharacter"/>

    <module name="RegexpSingleline">
        <property name="format" value="\s+$"/>
        <property name="minimum" value="0"/>
        <property name="maximum" value="0"/>
        <property name="message" value="Line has trailing spaces."/>
    </module>

    <module name="LineLength">
        <property name="max" value="150" />
    </module>

    <module name="BeforeExecutionExclusionFileFilter">
        <property name="fileNamePattern" value=".*Example\.java$"/>
    </module>

    <!--=============================================================-->
    <module name="TreeWalker">
        <module name="JavadocMethod">
            <property name="tokens" value="METHOD_DEF" />
        </module>
        <module name="JavadocType"/>
        <module name="JavadocVariable">
            <property name='ignoreNamePattern' value='.*Business|.*Service|.*Handler|.*Mapper|.*Template|.*Client|.*Util.*|LOG|LOGGER|logger'/>
        </module>

        <module name="JavadocStyle">
            <property name="checkFirstSentence" value="false"/>
        </module>
        <module name="TodoComment"/>

        <module name="LocalFinalVariableName" />
        <module name="LocalVariableName" />
        <module name="PackageName">
            <property name="format" value="^[a-z]+(\.[a-z][a-z0-9]*)*$" />
            <message key="name.invalidPattern" value="包名 ''{0}'' 要符合 ''{1}''格式."/>
        </module>
        <module name="StaticVariableName" />
        <module name="TypeName">
            <property name="severity" value="warning"/>
            <message key="name.invalidPattern" value="名称 ''{0}'' 要符合 ''{1}''格式."/>
        </module>
        <module name="MemberName" />
        <module name="MethodName" />
        <module name="ParameterName" />
        <module name="ConstantName" />


        <module name="ArrayTypeStyle"/>
        <module name="UpperEll"/>

        <module name="AvoidStarImport"/>
        <module name="IllegalImport"/>
        <module name="RedundantImport"/>
        <module name="UnusedImports" />

        <module name="MethodLength">
            <property name="tokens" value="METHOD_DEF" />
            <property name="max" value="150" />
        </module>
        <module name="ParameterNumber">
            <property name="max" value="10" />
            <property name="ignoreOverriddenMethods" value="true"/>
            <property name="tokens" value="METHOD_DEF" />
        </module>


        <module name="MethodParamPad" />
        <module name="TypecastParenPad" />
        <module name="NoWhitespaceAfter"/>
        <module name="NoWhitespaceBefore"/>
        <module name="OperatorWrap"/>
        <module name="ParenPad"/>
        <module name="WhitespaceAfter"/>
        <module name="WhitespaceAround"/>

        <module name="ModifierOrder"/>
        <module name="RedundantModifier"/>


        <module name="AvoidNestedBlocks"/>
        <module name="EmptyBlock"/>
        <module name="LeftCurly"/>
        <module name="NeedBraces"/>
        <module name="RightCurly"/>


        <module name="EmptyStatement"/>
        <module name="EqualsHashCode"/>
        <module name="HiddenField">
            <property name="tokens" value="VARIABLE_DEF"/>
        </module>
        <module name="IllegalInstantiation"/>
        <module name="InnerAssignment"/>
        <module name="MagicNumber">
            <property name="ignoreNumbers" value="0, 1"/>
            <property name="ignoreAnnotation" value="true"/>
        </module>
        <module name="MissingSwitchDefault"/>
        <module name="SimplifyBooleanExpression"/>
        <module name="SimplifyBooleanReturn"/>


        <module name="FinalClass"/>
        <module name="HideUtilityClassConstructor"/>
        <module name="InterfaceIsType"/>
        <module name="VisibilityModifier"/>

    </module>

</module>

```

Далее мы уже готовы проверить наши коды проекта.

## 1.3 Разбор некоторых групп опций анализатора

В файле конфигурации я установила следующие группы правил:
 - проверка комментариев javadoc
 - Импортировать чеки
 - Проверка правил именования
 - Ограничение количества параметров для метода
 - Ограничения на количество строк кода и длину строк кода
 - Ограничения на использование помещений
 - Ключевые слова
 - пустое поле
 - Проверка кодирования
 - другой

Рассмотрим группы
 - Импортировать чеки
 - Проверка кодирования

### 1.3.1 Группа "Импортировать чеки"

```xml
<module name="AvoidStarImport"/>   
<module name="IllegalImport"/>  
<module name="RedundantImport"/>  
<module name="UnusedImports"/>
```

Этот набор правил в основном проверяет спецификации использования ключевого слова import в файлах Java. Четыре предложения в документе соответственно предусматривают:
1. Проверить, используется ли звездочка `*` при импорте
2. Проверить, импортированы ли классы из нелегальных пакетов.
3. Проверить, были ли импортированы дополнительные пакеты.
4. Проверить, нет ли бесполезного импорта. Например: 1. Не используется 2. Дублировать 3. Импортировать java.lang 4. Импортировать в тот же пакет, что и этот класс.

### 1.3.2 Группа "Проверка кодирования"
```xml
<module name="EmptyStatement"/>  
<module name="EqualsHashCode"/>  
<module name="MissingSwitchDefault"/>  
<module name="HiddenField">  
    <property name="tokens" value="VARIABLE_DEF"/>  
</module>  
<module name="InnerAssignment"/>  
<module name="ModifiedControlVariable"/>  
<module name="SimplifyBooleanExpression"/>  
<module name="SimplifyBooleanReturn"/>  
<module name="StringLiteralEquality"/>  
<module name="NestedForDepth">  
    <property name="max" value="4"/>  
</module>  
<module name="NestedIfDepth">  
    <property name="max" value="5"/>  
</module>  
<module name="NestedTryDepth">  
    <property name="max" value="5"/>  
</module>  
<module name="OverloadMethodsDeclarationOrder"/>  
<module name="SuperClone"/>  
<module name="SuperFinalize"/>  
  
<module name="PackageDeclaration"/>  
<module name="ReturnCount">  
    <property name="max" value="10"/>  
    <property name="maxForVoid" value="10"/>  
</module>  
  
<module name="ExplicitInitialization"/>  
  
<module name="MultipleVariableDeclarations"/>  
<module name="UnnecessaryParentheses"/>  
<module name="BooleanExpressionComplexity">  
    <property name="max" value="8"/>  
</module>  
<module name="ClassDataAbstractionCoupling">  
    <property name="max" value="50"/>  
</module>  
<module name="FinalClass"/>  
<module name="VisibilityModifier">  
    <property name="packageAllowed" value="true"/>  
    <property name="protectedAllowed" value="true"/>  
</module>  
  
<module name="Regexp">  
    <property name="format" value=".printStackTrace"/>  
    <property name="illegalPattern" value="true"/>  
</module>  
<module name="Regexp">  
    <property name="format" value="System.out.println"/>  
    <property name="illegalPattern" value="true"/>  
</module>  
  
<module name="UpperEll"/>  
<module name="ArrayTypeStyle"/>  
<module name="UncommentedMain">  
    <property name="excludedClasses" value=".*[Application,Test]$"/>  
</module>  
<module name="UpperEll"/>
```

- `<module name="EmptyStatement"/>` : проверяет наличие пустого оператора (т. е. одной точки с запятой).
- `<module name="EqualsHashCode"/>` : проверяет, что при переопределении методаquals() метод hashCode() также переопределяется соответствующим образом.
- `<module name="MissingSwitchDefault"/>` : проверяет, все ли операторы переключения имеют операторы по умолчанию (то есть выполняются, когда нет соответствующего случая).
- `<module name="HiddenField">` : проверяет, скрыто ли поле локальными переменными или параметрами.
- `<module name="InnerAssignment"/>` : проверяет наличие встроенных присвоений, например присвоений в выражении while (d = getValue()) {}.
- `<module name="ModifiedControlVariable"/>` : проверяет, была ли изменена управляющая переменная цикла в теле цикла.
- `<module name="SimplifyBooleanExpression"/>` : проверяет, можно ли упростить сложное логическое выражение.
- `<module name="SimplifyBooleanReturn"/>` : проверяет, можно ли упростить сложную структуру, возвращающую логическое значение в методе.
- `<module name="StringLiteralEquality"/>` : проверяет, сравниваются ли строки с помощью == вместо методаquals().
- `<module name="NestedForDepth">` : ограничивает глубину вложенных циклов for максимум до 4.
- `<module name="NestedIfDepth">` : ограничивает глубину вложенности операторов if максимум до 5.
- `<module name="NestedTryDepth">` : ограничивает глубину вложенных операторов try-catch максимум до 5.
- `<module name="OverloadMethodsDeclarationOrder"/>` : требует, чтобы перегруженные методы были упорядочены в соответствии с количеством их параметров.
- `<module name="SuperClone"/>` : требует, чтобы метод клонирования вызывал super.clone().

## 1.4 Запуск анализатор для кода всего проекта
Выбираем поле проверки - весь проект.

![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041433825.png)

Запускаем, получаем результат:

![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041546175.png)

Checkstyle обнаружил 341 ошибки в коде в 28 файлах.

По результатам мы заметили следующие типичные ошибки. Поясню скриншотами и исправлю :
1. **Javadoc отсутствует**
Комментарии к классам, атрибутам классов и методам классов должны использовать спецификации Javadoc и формат `/** содержимого */`, а метод `// xxx` использовать нельзя.
	![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041552730.png)
	После исправления：
	
![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041557458.png)

2. **Проверить наличие дополнительных мест** 

В пустых строках пробелы не допускаются.

![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041556427.png)

После исправления：

![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041557134.png)


3. **Перед `+` нет пробела**

Перед Знаком + должен быть пробел.
![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041601566.png)

После исправления: 

![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041602623.png)

4. **Магическое число (константа)**
![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041613553.png)

После исправления: 

![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041622901.png)

5. Служебные классы не должны иметь общедоступных конструкторов.

Класс инструмента представляет собой набор статических членов или методов, что означает, что он не может быть создан. Даже если это абстрактный класс инструмента, он может быть унаследован, но у него не может быть открытого конструктора. Если класс Java не объявляет конструктор, по умолчанию он будет иметь общедоступный конструктор, поэтому вам необходимо объявить хотя бы один закрытый конструктор для класса инструмента.

![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041625110.png)

После исправления: 

![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041626032.png)

После исправления ошибок, которые нашел инструмент Checkstyle, проверяем повторный сеанс проверки с теми же настройками, что и при первом сеансе проверки. Снова запустили Checkstyle и получили сообщение «Проблема не найдена».

![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041653700.png)

## 1.5 Сравнение результаты двух инструментов

С помощью инструмента Checkstyle получаем следующий результат:

| Номер ошибки | Назвение ошибки                                                                                                                   | Количество вхождений в первую проверку | Количество вхождений в повторную проверку |
|--------------|-----------------------------------------------------------------------------------------------------------------------------------|----------------------------------------|-------------------------------------------|
| A001         | Файл не заканчивается пустой строкой (NewlineAtEndOfFile)                                                                         | 4                                      | 0                                         |
| A002         | Отсутствует Javadoc (JavadocVariable)                                                                                             | 51                                     | 0                                         |
| A003         | Дополнительные пробелы в конце строки (RegexpSingleline)                                                                          | 156                                    | 0                                         |
| A004         | Файл содержит символ табуляции (FileTabCharacter).                                                                                | 23                                     | 0                                         |
| A005         | Классы служебных программ не должны иметь общедоступного конструктора или конструктора по умолчанию (HideUtilityClassConstructor) | 2                                      | 0                                         |
| A006         | До и после знака «+» должны быть пробелы (WhitespaceAround).                                                                      | 11                                     | 0                                         |
| A007         | После «if» должен быть пробел (WhitespaceAfter).                                                                                  | 17                                     | 0                                         |
| A008         | После «if» должен быть пробел (WhitespaceAround)                                                                                  | 17                                     | 0                                         |
| A009         | До и после '=" должны быть пробелы (WhitespaceAround)                                                                             | 16                                     | 0                                         |
| A010         | Перед ';' не должно быть пробела (NoWhitespaceBefore).                                                                            | 3                                      | 0                                         |
| A011         | «16» и «5000» — это магические числа.                                                                                             | 2                                      | 0                                         |
| A012         | Тег @return должен присутствовать и иметь описание (JavadocMethod).                                                               | 4                                      | 0                                         |
| A013         | '' требует аннотации Javadoc @param (JavadocMethod)                                                                               | 4                                      | 0                                         |

С помощью инструмента IDEA-Inspection получаем следующий результат (Total warning: 88):

| Номер ошибки | Назвение ошибки                                | Количество вхождений в первую проверку | Количество вхождений в повторную проверку |
|--------------|------------------------------------------------|----------------------------------------|-------------------------------------------|
| B001         | Duplicated code fragment                       | 4                                      | 0                                         |
| B002         | Call to 'printStackTrace()'                    | 3                                      | 3                                         |
| B003         | Field may be 'final'                           | 9                                      | 9                                         |
| B004         | 'size() == 0' can be replaced with 'isEmpty()' | 12                                     | 12                                        |
| B005         | Redundant local variable                       | 5                                      | 5                                         |
| B006         | Declaration can have 'final' modifier          | 17                                     | 17                                        |
| B007         | Method always returns the same value           | 6                                      | 6                                         |
| B008         | Method can be made 'void'                      | 9                                      | 9                                         |
| B009         | Method parameter always has the same value     | 8                                      | 8                                         |
| B010         | Redundant 'throws' clause                      | 1                                      | 0                                         |
| B011         | Explicit type can be replaced with '<>'        | 11                                     | 11                                        |
| B012         | Javadoc declaration problems                   | 3                                      | 0                                         |

Мы оставим некоторые ошибки, основанные на двух причин:
1. Java-файлы, созданные методом реверс-инжиниринга, не должны легко изменяться.
2. Сохранить читабельность программы.
Поскольку файлы Java, созданные методом реверс-инжиниринга, имеют функцию взаимодействия с базой данных, для обеспечения совместимости с базой данных код, автоматически сгенерированный методом реверс-инжиниринга, не следует легко изменять. Таким образом, у нас остались «ошибки» B002 ~ B009, B011.
Чтобы сделать программу более читабельной, мы сохранили «ошибку» B012.

## 1.6 Вывод

В ходе проведения статического анализа кода программы с использованием инструментов Checkstyle и IDEA была выполнена комплексная проверка качества кода. Эти инструменты позволили выявить разнообразные типы ошибок, начиная от нарушений стиля кодирования и заканчивая более глубокими структурными проблемами. Были обнаружены и исправлены ошибки, связанные с ненужным использованием пробелов, отсутствием Javadoc комментариев, использованием магических чисел, неправильной организацией кода и другие.

Статический анализ, проведённый с помощью инструментов Checkstyle и IDEA на ранних этапах разработки, демонстрирует значительную эффективность в выявлении и исправлении многочисленных ошибок, от стилевых до структурных. Он должен применяться регулярно, адаптируя частоту к динамике проекта, что позволяет минимизировать риски и улучшать качество кода. Этот подход не только обнаруживает типичные ошибки, но и способствует повышению чистоты кода, его стандартизации и упрощает последующую поддержку и развитие продукта, являясь ключевым элементом в современных методологиях разработки.


# 2 СПИСОК ИСТОЧНИКОВ

[1] Документация Checkstyle, [Электронный ресурс], URL: https://checkstyle.sourceforge.io/ (Дата обращения: 01.03.2024)

[2] Standard Checks For Checkstyle, [Электронный ресурс], URL: https://checkstyle.sourceforge.io/checks.html

[3] Документация IDEA Language injections, [Электронный ресурс], URL:https://www.jetbrains.com/help/idea/using-language-injections.html

# 3 ПРИЛОЖЕНИЕ

## 3.1 Список правил статических анализатора Checkstyle

![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403042102578.png)

![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403042103992.png)

![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403042103501.png)

![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403042103656.png)

![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403042103250.png)


