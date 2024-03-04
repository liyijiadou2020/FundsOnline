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
# ГЛАВА 1. СТАТИЧЕСКИЙ АНАЛИЗ

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
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE module PUBLIC "-//Puppy Crawl//DTD Check Configuration 1.3//EN"
        "http://www.puppycrawl.com/dtds/configuration_1_3.dtd">
<module name="Checker">
    <!-- 官方主页：https://checkstyle.sourceforge.io -->
    <!-- 检查文件是否以一个空行结束 -->
    <module name="NewlineAtEndOfFile"/>
    <!-- 文件长度不超过1500行 -->
    <module name="FileLength">
        <property name="max" value="1500"/>
    </module>
    <!-- 每行不超过120个字 -->
    <module name="LineLength">
        <property name="max" value="150"/>
    </module>

    <module name="TreeWalker">
        <!-- 想严格对文件头进行检查，请把文件头定义在一个外部文件中，如：java_header_file.txt 然后使 用"headerFile"属性：
        <module name="Header">
            <property name="headerFile" value="java_header_file.txt"/>
            <property name="ignoreLines" value="1, 5"/>
        </module>
        -->

        <!-- 忽略掉文件头的几行声明  不指定外部文件时出错，暂不使用
        <module name="Header">
            <property name="ignoreLines" value="1, 5"/>
        </module>
         -->

        <!-- ********************************javadoc的检查********************-->
        <!-- 检查Javadoc -->
        <module name="JavadocStyle">
            <!-- 忽略句号结尾检查 -->
            <property name='checkFirstSentence' value='false'/>
            <property name='checkEmptyJavadoc' value='true'/>
        </module>
        <!-- 检查所有的interface和class的doc -->
        <module name="JavadocType">
            <!-- 注释里允许所有注解 -->
            <property name='allowUnknownTags' value='true'/>
        </module>
        <!-- 检查所有方法的javadoc 注意方法上的@param XXX后必须跟参数说明检查才能通过 -->
        <module name='MissingJavadocMethod'>
            <property name="allowMissingPropertyJavadoc" value="true"/>
            <property name="allowedAnnotations" value="Override,Deprecated,ApiOperation"/>
            <property name="ignoreMethodNamesRegex" value="main"/>
        </module>
        <module name="JavadocMethod"/>
        <!-- 变量的javadoc -->
        <module name="JavadocVariable">
            <!-- 忽略检查的变量名 -->
            <property name='ignoreNamePattern' value='.*Business|.*Service|.*Handler|.*Mapper|.*Template|.*Client|.*Util.*|LOG|LOGGER'/>
        </module>

        <!-- ********************************import方面的检查*********** -->
        <!-- import中避免星号"*" -->
        <module name="AvoidStarImport"/>
        <!-- 检查是否从非法的包中导入了类 -->
        <module name="IllegalImport"/>
        <!-- 检查是否导入了多余的包 -->
        <module name="RedundantImport"/>
        <!--没用的import检查，比如：1.没有被用到 2.重复的 3.import java.lang的 4.import与该类在同一个package的-->
        <module name="UnusedImports"/>

        <!-- ********************************命名规则检查****************** -->
        <!-- 包名检查 ^[a-z]+(\.[a-z][a-z0-9]*)*$ -->
        <module name="PackageName">
            <property name="format" value="^[a-z]+(\.[a-z][a-z0-9]*)*$"/>
            <message key="name.invalidPattern" value="包名 ''{0}'' 要符合 ''{1}''格式."/>
        </module>
        <!-- 类型(Class或Interface)名  ^[A-Z][a-zA-Z0-9]*$-->
        <module name="TypeName">
            <property name="severity" value="warning"/>
            <message key="name.invalidPattern" value="名称 ''{0}'' 要符合 ''{1}''格式."/>
        </module>
        <!-- 方法名  ^[a-z][a-zA-Z0-9]*$-->
        <module name="MethodName"/>
        <!-- 方法的参数命名 ^[a-z][a-zA-Z0-9]*$-->
        <module name="ParameterName "/>
        <!-- 非static型变量  ^[a-z][a-zA-Z0-9]*$-->
        <module name="MemberName"/>
        <!-- 常量(static , final 字段)  ^[A-Z][A-Z0-9]*(_[A-Z0-9]+)*$-->
        <module name="ConstantName"/>
        <!-- 局部的final变量，包括catch中的参数  ^[a-z][a-zA-Z0-9]*$ -->
        <module name="LocalFinalVariableName"/>
        <!-- 局部的非final型的变量，包括catch中的参数  ^[a-z][a-zA-Z0-9]*$ -->
        <module name="LocalVariableName"/>
        <!-- 仅仅是static型的变量（不包括staticfinal型）  ^[a-z][a-zA-Z0-9]*$ -->
        <module name="StaticVariableName"/>

        <!-- **************方法的参数个数不超过5个。 并且不对构造方法和重写方法进行检查*******-->
        <module name="ParameterNumber">
            <property name="tokens" value="METHOD_DEF"/>
            <property name="ignoreOverriddenMethods" value="true"/>
            <property name="max" value="5"/>
        </module>

        <!-- ************************代码行数及行代码长度限制****************** -->
        <!-- 文件长度不超过1500行，放在TreeWalker前面 -->
        <!-- 方法不超过300行 -->
        <module name="MethodLength">
            <property name="tokens" value="METHOD_DEF"/>
            <property name="max" value="300"/>
        </module>
        <!-- 每行不超过120个字
        <module name="LineLength">
            <property name="max" value="150"/>
        </module>
        -->
        <!-- ****************************空格限定***************************** -->
        <!-- 检查约定方法名与左边圆括号之间不许出现空格
            public void wrongStyleMethod (){
            public void wrongStyleMethod
                                        (String para1, String para2){
            都是不能通过的，只允许方法名后紧跟左边圆括号"("-->
        <module name="MethodParamPad"/>

        <!-- 不允许左圆括号右边有空格，也不允许与右圆括号左边有空格
            public void wrongStyleMethod( String para1, String para2 ){
            public void correctStyleMethod(String para1, String para2){
            都不能通过-->
        <module name="ParenPad"/>

        <!-- 在类型转换时，不允许左圆括号右边有空格，也不允许与右圆括号左边有空格
            Object myObject = ( Object )other;
            不能通过-->
        <module name="TypecastParenPad"/>

        <!--  代码中不允许使用"tab"键。('\t') 因为在不同的编辑器下有的tab占8个空格（如windows记事
                  本），有的占4个（如当前大多数IDE）。
        <module name="TabCharacter"/>
        -->
        <!-- 检查在某个特定关键字之后应保留空格 -->
        <module name="NoWhitespaceAfter"/>
        <!-- 检查在某个特定关键字之前应保留空格 -->
        <module name="NoWhitespaceBefore"/>
        <!-- 操作符换行策略检查 -->
        <module name="OperatorWrap"/>
        <!-- 检查分隔符是否在空白之后 -->
        <module name="WhitespaceAfter"/>
        <!-- 检查分隔符周围是否有空白 -->
        <module name="WhitespaceAround"/>


        <!-- **********************关键字********************************** -->
        <!-- 每个关键字都有正确的出现顺序。比如 public static final XXX 是对一个常量的声明。如果使用
            static public final 就是错误的 -->
        <module name="ModifierOrder"/>
        <!-- 过滤多于的关键字-->
        <module name="RedundantModifier"/>


        <!-- ***********************空白域************************************* -->
        <!-- 不能出现空白区域 -->
        <module name="EmptyBlock"/>
        <!-- 所有区域都要使用大括号 if(true)System.out.println("if 嵌套浓度限定");不能通过-->
        <module name="NeedBraces"/>
        <!-- 多余的括号 -->
        <module name="AvoidNestedBlocks">
            <property name="allowInSwitchCase" value="true"/>
        </module>
        <!-- 检查左大括号位置 -->
        <module name="LeftCurly"/>
        <!-- 检查右大括号位置 -->
        <module name="RightCurly"/>

        <!-- ******************************编码方面的检查 **********************-->
        <!-- 检查空的代码段
            不许出现空语句
            int a = 0; //正常
            ; // 这里就是一个空的语句
            int b = 0; //正常
        -->
        <module name="EmptyStatement"/>
        <!-- 如果某个变量一直都没变，那么它就应该是final型的
        <module name="FinalLocalVariable"/>
        -->
        <!-- 检查在重写了equals方法后是否重写了hashCode方法 -->
        <module name="EqualsHashCode"/>
        <!-- 不允许使用switch语句
        <module name="IllegalToken">
            <property name="tokens" value="LITERAL_SWITCH"/>
        </module>
        -->
        <!-- 检查switch语句是否有default -->
        <module name="MissingSwitchDefault"/>
        <!-- 检查局部变量或参数是否隐藏了类中的变量 -->
        <module name="HiddenField">
            <property name="tokens" value="VARIABLE_DEF"/>
        </module>
        <!-- 内部赋值语句 ：String s = Integer.toString(i = 2); -->
        <module name="InnerAssignment"/>
        <!-- 绝对不能容忍魔法数 ，即数据标识常量化
        <module name="MagicNumber"/>
        -->
        <!-- 循环控制变量不能被修改
        for (int i = 0; i < 1; i++) {
            i++; // 这里是极可能是程序员大意写出来的。
        }
        -->
        <module name="ModifiedControlVariable"/>
        <!-- 多余的throw
        <module name="RedundantThrows"/>
        -->
        <!-- 未被简化的条件表达式 检查过度复杂的条件表达式，
            比如： (b == true), b || true, !false, 难读且容易出错 -->
        <module name="SimplifyBooleanExpression"/>
        <!-- 未被简化的布尔返回值
            if (valid()){
                return false;
            }else{
                return true;
            }
            就可以写成：
            return !valid();
         -->
        <module name="SimplifyBooleanReturn"/>
        <!-- String的比较不能用!= 和 == -->
        <module name="StringLiteralEquality"/>
        <!-- 限制for循环最多嵌套2层 -->
        <module name="NestedForDepth">
            <property name="max" value="4"/>
        </module>
        <!-- if最多嵌套3层 -->
        <module name="NestedIfDepth">
            <property name="max" value="5"/>
        </module>
        <!-- try最多被嵌套2层 -->
        <module name="NestedTryDepth">
            <property name="max" value="5"/>
        </module>
        <!--重载方法是否在同个地方-->
        <module name="OverloadMethodsDeclarationOrder"/>
        <!-- 检查并确认一个类的clone()方法调用了父类的clone() -->
        <module name="SuperClone"/>
        <!-- 检查并确认一个类的finalize()调用了父类的finalize() -->
        <module name="SuperFinalize"/>
        <!-- 不能catch java.lang.Exception,异常分类处理
        <module name="IllegalCatch">
            <property name="illegalClassNames" value="java.lang.Exception"/>
        </module>
         -->
        <!-- 确保一个类有package声明 -->
        <module name="PackageDeclaration"/>
        <!-- 一个方法中最多有10个return -->
        <module name="ReturnCount">
            <property name="max" value="10"/>
            <property name="maxForVoid" value="10"/>
        </module>
        <!-- 确保某个class 在被使用时都已经被初始化成默认值(对象是null ,
            数字和字符是0 , boolean 变量是false.)了 -->
        <module name="ExplicitInitialization"/>
        <!-- 不许有同样内容的String
        <module name="MultipleStringLiterals"/>
        -->
        <!-- 同一行不能有多个声明 -->
        <module name="MultipleVariableDeclarations"/>
        <!-- 不必要的圆括号 检查不必要的圆括号”(,)”。比如， if(((((true))))) -->
        <module name="UnnecessaryParentheses"/>
        <!-- 限制一个布尔表达式中的 &&, || 和^的个数。可以让代码看起来更清晰，容易排错和维护  -->
        <module name="BooleanExpressionComplexity">
            <property name="max" value="8"/>
        </module>
        <!-- 一个类中如果使用太多其他的类，是肯定会增加系统复杂度的。使用其他的类越少，耦合度就越少 -->
        <module name="ClassDataAbstractionCoupling">
            <property name="max" value="50"/>
        </module>
        <!-- 确保函数的分支复杂度没有超出限制
        <module name="CyclomaticComplexity">
            <property name="max" value="20"/>
        </module>
        -->
        <!-- NPATH 量度计算了一个函数的可执行的分支个数
        <module name="NPathComplexity">
            <property name="max" value="20"/>
        </module>
        -->

        <!-- 类设计检查 -->
        <!-- 检查只有private构造函数的类是否声明为final -->
        <module name="FinalClass"/>
        <!-- 检查接口是否仅定义类型
        <module name="InterfaceIsType"/>
    	-->
        <!-- 检查类成员的可见度 检查类成员的可见性。只有static final 成员是public的除非在本检查的protectedAllowed和packagedAllowed属性中进行了设置-->
        <module name="VisibilityModifier">
            <property name="packageAllowed" value="true"/>
            <property name="protectedAllowed" value="true"/>
        </module>

        <!-- 禁止使用System.out.println -->
        <module name="Regexp">
            <property name="format" value=".printStackTrace"/>
            <property name="illegalPattern" value="true"/>
        </module>
        <module name="Regexp">
            <property name="format" value="System.out.println"/>
            <property name="illegalPattern" value="true"/>
        </module>

        <!-- ************************其他*********************************** -->
        <!-- 检查并确保所有的常量中的L都是大写的。因为小写的字母l跟数字1太象了 -->
        <module name="UpperEll"/>
        <!-- 检查数组类型的定义是String[] args，而不是String args[] -->
        <module name="ArrayTypeStyle"/>
        <!-- 不许使用与代码同行的注释
        <module name="TrailingComment"/>
        -->
        <!-- 不许存在TO DO
        <module name="TodoComment"/>
        -->
        <!-- 除了正常的程序入口之外，所有的main方法都应该被删掉或注释掉 -->
        <module name="UncommentedMain">
            <property name="excludedClasses" value=".*[Application,Test]$"/>
        </module>
        <!-- 检查并确保所有的常量中的L都是大写的。也就是在常量中没有使用”l”而是用的”L”，比如long型常
            量，都要以”L”结尾。这与Sun编码规范 3.10.1 相一致。小写的字母l 跟数字1 太象了 -->
        <module name="UpperEll"/>
    </module>
</module>
```

## 1.3 Разбор некоторых групп опций анализатора




## 1.4 Запуск анализатор для кода всего проекта







## 1.5 Запуск анализатора для выбранного фрагмента кода





## 1.6 Вывод





# 2 СПИСОК ИСТОЧНИКОВ

[1] Checkstyle, https://checkstyle.sourceforge.io/
[2] Standard Checks, https://checkstyle.sourceforge.io/checks.html


