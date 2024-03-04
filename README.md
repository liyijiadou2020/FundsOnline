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
Ниже приводится описание роли каждого модуля:

- <module name="EmptyStatement"/>: проверяет наличие пустого оператора (т. е. одной точки с запятой).

- <module name="EqualsHashCode"/>: проверяет, что при переопределении методаquals() метод hashCode() также переопределяется соответствующим образом.

- <module name="MissingSwitchDefault"/>: проверяет, все ли операторы переключения имеют операторы по умолчанию (то есть выполняются, когда нет соответствующего случая).

- <module name="HiddenField">: проверьте, скрыто ли поле локальными переменными или параметрами.

- <module name="InnerAssignment"/>: проверьте наличие встроенных присвоений, например присвоений в выражении while (d = getValue()) {}.

- <module name="ModifiedControlVariable"/>: проверьте, была ли изменена управляющая переменная цикла в теле цикла.

- <module name="SimplifyBooleanExpression"/>: проверяет, можно ли упростить сложное логическое выражение.

- <module name="SimplifyBooleanReturn"/>: проверьте, можно ли упростить сложную структуру, возвращающую логическое значение в методе.

- <module name="StringLiteralEquality"/>: проверяет, сравниваются ли строки с помощью == вместо методаquals().

- <module name="NestedForDepth">: ограничивает глубину вложенных циклов for максимум до 4.

- <module name="NestedIfDepth">: ограничивает глубину вложенности операторов if максимум до 5.

- <module name="NestedTryDepth">: ограничивает глубину вложенных операторов try-catch максимум до 5.

- <module name="OverloadMethodsDeclarationOrder"/>: требует, чтобы перегруженные методы были упорядочены в соответствии с количеством их параметров.

- <module name="SuperClone"/>: требует, чтобы метод клонирования вызывал super.clone().

- <module name="SuperFinalize"/>: требует, чтобы метод Finalize вызывал super.finalize().

- <module name="PackageDeclaration"/>: проверьте, существует ли объявление пакета и правильно ли оно.

- <module name="ReturnCount">: ограничивает количество операторов возврата, которые может содержать метод.

- <module name="ExplicitInitialization"/>: проверьте, имеет ли поле или переменная ненужную явную инициализацию.

- <module name="MultipleVariableDeclarations"/>: проверьте, объявлено ли несколько переменных в одной строке.

- <module name="UnnecessaryParentheses"/>: проверьте код на наличие ненужных скобок.

- <module name="BooleanExpressionComplexity">: ограничивает сложность логических выражений (измеряется количеством операторов).

- <module name="ClassDataAbstractionCoupling">: Ограничить сложность связи между классами (количество зависимых классов).

- <module name="FinalClass"/>: убедитесь, что классы, помеченные как окончательные, не имеют подклассов.

- <module name="VisibilityModifier">: проверяет модификаторы видимости классов и членов.

- <module name="Regexp">: проверка кода на основе регулярных выражений. Вот два примера регулярных выражений, используемых для обнаружения вызовов .printStackTrace() и System.out.println, оба из которых обычно считаются плохой практикой и должны быть заменены структурой журналирования.

- <module name="ArrayTypeStyle"/>: проверьте, соответствует ли стиль объявления массива стандартам Java.

- <module name="UncommentedMain"/>: проверьте, есть ли у основного метода комментарии.

- <module name="UpperEll"/>: убедитесь, что длинные литералы используют заглавную букву «L», поскольку строчную букву «l» можно спутать с цифрой «1».


## 1.4 Запуск анализатор для кода всего проекта







## 1.5 Запуск анализатора для выбранного фрагмента кода





## 1.6 Вывод





# 2 СПИСОК ИСТОЧНИКОВ

[1] Checkstyle, https://checkstyle.sourceforge.io/
[2] Standard Checks, https://checkstyle.sourceforge.io/checks.html


