# Kotlin #

由***JetBrains***开发的***JVM语言***。  JetBrains创造了一个基于Intellij的Android Studio。



## 对比Java的优势 ##
 - 代码简洁 
 - 避免空指针异常
 - 扩展函数
 - 高度互操作性


## 创建一个Kotlin项目 ##

1. 安装Kotlin插件
2. 配置gradle

        //build.gradle(Project)
        buildscript {
            ext.kotlin_version = '1.1.2-4'
            ext.anko_version = '0.10.0'
            repositories {
             	   jcenter()
        	}

        	dependencies {
           		classpath 'com.android.tools.build:gradle:2.3.1'
            	classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
        	}
        }

			allprojects {
    			repositories {
        		jcenter()
    		}
		}


3. 转换kotlin格式
    
    	Code -> Convert Java File to Kotlin File
    
## 定义类  


它有一个默认唯一的构造器：
    
	class Person{

	}

请记住当只用到这个默认的构造器，你只需要在类名后面写上它的参数，如果这个类没有任何内容可以省略大括号：

	class Person(name: String, surname: String)

当构造函数需要函数体时，可以写在init{}中：
	
	class Person(name: String, surname: String) {
    	init{
        	...
    	}
	}

## 继承类 ##

默认任何类都是继承自Any（与java中的Object类似）。

所有的类默认都是不可继承的（final），所以我们只能继承那些明确声明open或者abstract的类：

    open class Animal(name: String)
	class Person(name: String, surname: String) : Animal(name)

当只有单个构造器时，我们需要在从父类继承下来的构造器中指定需要的参数,这是用来替换Java中的super的

## 函数 ##
函数（Java中的方法）可以使用fun关键字就可以定义:

    fun onCreate(savedInstanceState: Bundle?) {

    }

如果没有指定它的返回值，它就会返回Unit，与Java中的void类似，但是Unit是一个真正的对象。你也可以指定任何其它的返回类型：

    fun add(x: Int, y: Int) : Int {
    	return x + y
    }
> 小提示：分号不是必须的

如果返回的结果可以使用一个表达式计算出来，你可以不使用括号而是使用等号：

    fun add(x: Int,y: Int) : Int = x + y

Kotlin中的参数与Java中有些不同，先写参数的名字再写它的类型：

    fun add(x: Int, y: Int) : Int {
    	return x + y
	}

**可以给参数指定一个默认值使得它们变得可选**：

    fun toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    	Toast.makeText(this, message, length).show()
    }


## RecyclerView & Adapter ##

