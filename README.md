# FundsOnline
**fundsonline.com** - A financing platform that helps entrepreneurs publish entrepreneurial projects and raise start-up funds from the public.

## 1 Project Description
**fundsonline.com** is an online crowdfunding platform that supports entrepreneurial projects by raising funds from the general public, and supporters can receive returns equivalent to the amount of support.

## 2 Project Functions
The business functions of **fundsonline.com** include:
1. Users views crowdfunding projects
2. Users views crowdfunding project details
3. User supports Project
4. User views personal center
5. Users initiates crowdfunding
6. Administrator login
7. Administrator maintains data
8. Administrator maintains role data
9. Administrator maintains menu data
10. Administrator control permissions

## 3 Project Structure
This project can be divided into two parts: backend management and frontend membership. Its overall framework diagram is as follows:

![img](img/2024021301.png)
### 3.1 Backend management system
The backend management system has a single architecture, implemented by the SSM framework, and integrates SpringSecurity to control user permissions. The picture below shows the control panel page of the backend management system. You can see that the backend management mainly has three major functions, namely authority management, business review and business management. Although the Shangcho.com project has only completed the permission management part, it is enough for us to be familiar with the SSM framework.

![img](img/20200803140926683.png)

### 3.2 Front desk membership system
The front-end membership system is a distributed microservice architecture, implemented by SpringBoot + SpringCloud. At the same time, it integrates the oss service for uploading project pictures, and integrates Alibaba's payment API for payment. The picture below shows the user center page of the front-end membership system. Since the  **fundsonline.com** project is mainly used for teaching, most of the data in the picture is fake data. The most important function of this page is to initiate crowdfunding:

![img](img/2020080314203573.png)


The picture shows the page after clicking to initiate crowdfunding:
![img](img/20200813212725196.png)

## 4 Development / Deployment Environment

Аппаратные среды, использованные для разработки, показаны в Таблице 1:

*Таблица 1. Hardware environments*

| Item | Specification | Comments |
| ---- | ---- | ---- |
| CPU | AMD Ryzen 5 5600H with Radeon Graphics 3.30 GHZ | - |
| RAM | 16.0 GB | Software uses up to 1 GB |
| Operating System | Windows 10 Professional | - |

The software environments used in development are shown in Table 1:

*Таблица 2. Software enviroments*

| Item | version | Comments |
| ---- | ---- | ---- |
| Java | 8u121 | This or higher version |
| IntelliJ IDEA | 2023.2.2 (Educational Edition) | This or higher version |
| MySQL | 8.0.35 Community | This or higher version |
| Redis | 4.0.2 | This or higher version |
| Checkstyle | 8.1 | This or higher version |
| JUnit | 5.7.0 | This or higher version |


## 5 Test Environment
а) название приложения и ссылка, где оно находится в Интернете (если это open-source приложение), год выпуска приложения (разрешённый период с 2019 по настоящее время)
- название приложения: **fundsonline.com**
- ссылка: https://github.com/liyijiadou2020/FundsOnline.git

б) язык программирования <название и версия>;
- язык программирования: Java 8u121

в) размер всего приложения или размер фрагмента кода, который вы будете проверять, если размер приложения больше 1К (в исходных строках кода);
 - размер фрагмента кода, который вы будете проверять: 300 lines

г) среда разработки <название и версия>;
- среда разработки: IntelliJ IDEA 2023.2.2 Educational Edition

д) выбранные ДВА инструмента для статического анализа кода <название и версия>;
- выбранные ДВА инструмента для статического анализа кода:
	- Checkstyle 8.1
	- IntelliJ IDEA 2023.2.2 Educational Edition

е) выбранный фреймворк для разработки и выполнения модульных тестов
- JUnit 5.7.0

---
# 1 ГЛАВА 1. СТАТИЧЕСКИЙ АНАЛИЗ

## 1.1 Инструмент статического анализа
在开发Java应用程序时，我们经常需要确保代码的质量和一致性。静态检查工具可以帮助我们自动分析和检查代码，以寻找潜在的错误和改进点。处于易用性和语言兼容性的考虑我在本项目中的静态分析中我选择了两个工具：Checkstyle 和 IDEA。
При разработке Java-приложений нам часто необходимо обеспечить качество и согласованность нашего кода. Инструменты статической проверки могут помочь нам автоматически анализировать и проверять код, чтобы найти потенциальные ошибки и точки улучшения. Ради простоты использования и языковой совместимости в этом проекте я выбрал два инструмента для статического анализа: Checkstyle и IDEA.
### 1.1.1 Инструмент статической проверки Checkstyle
Checkstyle был впервые выпущен в 2001 году и в настоящее время является самым популярным (★4,6 тыс.) и постоянно активным инструментом статического анализа Java на GitHub. Данный инструмент в основном ориентирован на проверку стиля кода, в настоящее время поддерживает 14 категорий и 162 правел проверки(写在附录中), предоставляет файлы конфигурации, соответствующие спецификациям стиля кода Google/Sun, а также поддерживает гибкую настройку и расширение. Checkstyle имеет богатые методы интеграции: CLI (командная строка), поддержка инструментов сборки, поддержка IDE и т. д. В этом проекте инструмент Checkstyle будет использоваться в виде плагина IDEA.

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
1. Сначала откройте плагины в настройках в строке меню IDEA, найдите CheckStyle-IDEA и установите его.
![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041153675.png)
![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041155438.png)

2. Импортчеккстиле Checkstyle
Найдем CheckStyle в настройках и импортируем файл конфигурации `checkstyle.xml`, как показано ниже:
![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041201166.png)
![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041206729.png)

### 1.2.2 Конфигурирование
Checkstyle получает файл конфигурации из XML-документа, элементы которого определяют иерархию модулей конфигурации и их свойства. Содержимое нашего файла конфигурации checkstyle.xml следующее:

```xml

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
- 
- `<module name="EqualsHashCode"/>` : проверяет, что при переопределении методаquals() метод hashCode() также переопределяется соответствующим образом.
- 
- `<module name="MissingSwitchDefault"/>` : проверяет, все ли операторы переключения имеют операторы по умолчанию (то есть выполняются, когда нет соответствующего случая).
- 
- `<module name="HiddenField">` : проверяет, скрыто ли поле локальными переменными или параметрами.
- 
- `<module name="InnerAssignment"/>` : проверяет наличие встроенных присвоений, например присвоений в выражении while (d = getValue()) {}.
- 
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
Выбираем поле проверки - весь проект

![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041433825.png)

Запускаем, получаем результат:

![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041546175.png)

Checkstyle обнаружил 341 ошибки в коде в 28 файлах.

По результатам мы заметили следующие типичные ошибки. Поясню скриншотами и исправлю  :
1. 缺少 Javadoc 。说明：类、类属性、类方法的注释必须使用 Javadoc 规范，使用 `/** 内容 */` 格式，不得使用 `// xxx `方式。
	![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041552730.png)
	修改后：
![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041557458.png)

2. 多余空格。说明：

![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041556427.png)

修改后：
![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041557134.png)


3. +前没有空格。说明：+前应该有空格。
![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041601566.png)

修改后：
![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041602623.png)

4. `xx` 是一个魔法数字（常数）
![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041613553.png)

修改后：

![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041622901.png)

5. 工具类不应该有公有的构造函数。说明：工具类是一系列静态成员或方法的集合，意味着它不可以被实例化，即使是抽象的工具类，它可以被继承，但也不可以有公有的构造函数。Java类如果没有声明构造函数，则会默认有一个公有的构造函数，因此需要给工具类至少声明一个非公有的构造函数。
	错误：
	![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041625110.png)
改正后：
![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041626032.png)

После исправления ошибок, которые нашел инструмент Checkstyle, проверяем повторный сеанс проверки с теми же настройками, что и при первом сеансе проверки. Снова запустили Checkstyle и получили сообщение «Проблема не найдена».

![image.png](https://raw.githubusercontent.com/liyijiadou2020/picrepo/master/202403041653700.png)

## 1.5 Сравнение результаты двух инструментов

С помощью инструмента Checkstyle получаем следующий результат:

| 编码   | 错误类型                                                      | 在第一次检查中出现的数量 | 在第二次检查中出现的数量 |
|----| --------------------------------------------------------- | ------------ | ------------ |
| A001 | 文件未以空行结尾 (NewlineAtEndOfFile)                             | 4            | 0            |
| A002 | 缺少 Javadoc (JavadocVariable)                              | 51           | 0            |
| A003 | 行尾有多余空格 (RegexpSingleline)                                | 156          | 0            |
| A004 | 文件含有制表符tab (FileTabCharacter)                             | 23           | 0            |
| A005 | 工具类不应有 public 或 default 构造器 (HideUtilityClassConstructor) | 2            | 0            |
| A006 | '+' 前后应有空格 (WhitespaceAround)                             | 11           | 0            |
| A007 | 'if' 后应有空格 (WhitespaceAfter)                              | 17           | 0            |
| A008 | 'if' 后应有空格 (WhitespaceAround)                             | 17           | 0            |
| A009 | '=' 前后应有空格 (WhitespaceAround)                             | 16           | 0            |
| A010 | ';' 前不应有空格 (NoWhitespaceBefore)                           | 3            | 0            |
| A011 | '16' 和 '5000' 是魔术数字 (MagicNumber)                         | 2            | 0            |
| A012 | '@return'标签应存在并具有说明 (JavadocMethod)                       | 4            | 0            |
| A013 | '<Type>'需要Javadoc注释 @param (JavadocMethod)                | 4            | 0            |

С помощью инструмента IDEA-Inspection получаем следующий результат (Total warning: 88):

| 错误的类型                                          | 在第一次检查中出现的数量 | 在第二次检查中出现的数量 | 编码   |
| ---------------------------------------------- | ------------ | ------------ | ---- |
| Duplicated code fragment                       | 4            | 0            | B001 |
| Call to 'printStackTrace()'                    | 3            | 3            | B002 |
| Field may be 'final'                           | 9            | 9            | B003 |
| 'size() == 0' can be replaced with 'isEmpty()' | 12           | 12           | B004 |
| Redundant local variable                       | 5            | 5            | B005 |
| Declaration can have 'final' modifier          | 17           | 17           | B006 |
| Method always returns the same value           | 6            | 6            | B007 |
| Method can be made 'void'                      | 9            | 9            | B008 |
| Method parameter always has the same value     | 8            | 8            | B009 |
| Redundant 'throws' clause                      | 1            | 0            | B010 |
| Explicit type can be replaced with '<>'        | 11           | 11           | B011 |
| Javadoc declaration problems                   | 3            | 0            | B012 |

我们保留一些错误是基于两方面的考虑：
1. 逆向工程生成的 java 文件不应该轻易改动。
2. 保留程序的可读性。

由于逆向工程生成的 java 文件有与数据库交互的功能，所以为了保证与数据库的兼容性，逆向工程自动生成的代码不应该轻易改动。所以我们留下了“不规范” B002 ~ B009, B011.

为了使程序更具可读性，我们保留了 B012 的 “不规范”.

## 1.6 Вывод





# 2 СПИСОК ИСТОЧНИКОВ

[1] Checkstyle, https://checkstyle.sourceforge.io/
[2] Standard Checks, https://checkstyle.sourceforge.io/checks.html


