**Android Studio4.0****安装**

**一、jdk环境**

我们在下载好安装程序之后，最好先检查自己电脑的jdk版本，查看是否符合新版的Android Studio，毕竟新建项目的时候，如果某些库缺失的时候就会很麻烦了。查看方法：打开系统命令行，输入 java -version 即可。

![img](android_work1.assets/clip_image002-16950527098101.jpg)

我这个基本是比较新的jdk版本了，要想下载安装可以到[官网](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)直接下载。安装过程就略过了，基本是一路next，最好安装在C盘，因为也占不了多少空间，过程注意记录jdk和jre的安装路径，并在最后进入计算机 ->属性->高级系统设置->环境变量，新建系统变量 JAVA_HOME,并添加的值是C:\ProgramFiles\Java\jdk1.8.0_161，至此，Java 环境配置完成。

**二、Android Studio4.0安装**

 1、下载好AS安装包之后，点击进行安装，依次出现以下界面

https://www.androiddevtools.cn/

![http://files.jb51.net/file_images/article/201711/201711130959594.png](android_work1.assets/clip_image003-16950527098102.png)![http://files.jb51.net/file_images/article/201711/201711130959595.png](android_work1.assets/clip_image004-16950527098103.png)

![http://files.jb51.net/file_images/article/201711/201711130959596.png](android_work1.assets/clip_image005-16950527098104.png)

在这里自己选择程序安装路径

![http://files.jb51.net/file_images/article/201711/201711130959597.png](android_work1.assets/clip_image006-16950527098105.png)

![http://files.jb51.net/file_images/article/201711/201711131000008.png](android_work1.assets/clip_image007-16950527098109.png)![http://files.jb51.net/file_images/article/201711/201711131000009.png](android_work1.assets/clip_image008-16950527098106.png)

![http://files.jb51.net/file_images/article/201711/2017111310000010.png](android_work1.assets/clip_image009-16950527098107.png)

这里Android studio程序安装完毕。

**当然，也可以使用解压版，这个比较省事。**

进入Androidstudio 的bin目录启动AS，

![img](android_work1.assets/clip_image011-16950527098108.jpg)

出现下图

![img](android_work1.assets/clip_image012-169505270981010.png)

选择第二项，然后点击ok，出现下面的启动界面

![img](android_work1.assets/clip_image014-169505270981012.jpg)

在启动的时候会弹出下图

![http://files.jb51.net/file_images/article/201711/2017111310000013.png](android_work1.assets/clip_image015-169505270981015.png)

点击cancel，然后进入到了AS的安装向导界面

[![http://files.jb51.net/file_images/article/201711/2017111310000014.png](android_work1.assets/clip_image017-169505270981011.png)](http://files.jb51.net/file_images/article/201711/2017111310000014.png)

点击next进入UI界面主题选择界面，可以选择自己喜欢的风格，这里选择Darcula风格

![img](android_work1.assets/clip_image019-169505270981013.jpg)

点击下一步，这里需要指定SDK的本地路径，如果之前电脑中已经存在SDK，可以指定该路径，后续就可以不用下载SDK；我这里演示本地没有安装过SDK的场景，这里暂时可以指定一个后续将保存SDK的路径；

![http://files.jb51.net/file_images/article/201711/2017111310000017.png](android_work1.assets/clip_image021-169505270981014.png)

![http://files.jb51.net/file_images/article/201711/2017111310000018.png](android_work1.assets/clip_image023-169505270981016.png)

点击Finish后，开始自动下载SDK（注意，此时需要保证电脑联网）

[![http://files.jb51.net/file_images/article/201711/2017111310000019.png](android_work1.assets/clip_image025-169505270981017.png)](http://files.jb51.net/file_images/article/201711/2017111310000019.png)

![http://files.jb51.net/file_images/article/201711/2017111310000020.png](android_work1.assets/clip_image026-169505270981018.png)

下载完成SDK后，点击Finish进入AS的欢迎界面

 

![img](android_work1.assets/clip_image028-169505270981019.jpg)

3、配置AS第一次运行环境，并且能成功编译运行一个APP。

点击上图中的Start a new Android Studio project新建一个工程，进入下面的界面

![img](android_work1.assets/clip_image030-169505270981020.jpg)

![img](android_work1.assets/clip_image032-169505270981021.jpg)

![img](android_work1.assets/clip_image034-169505270981023.jpg)

 

 

 

到此，一个工程建立完成，第一次建立的工程会发现卡在下面的启动界面

 

![img](android_work1.assets/clip_image036-169505270981022.jpg)

第一次建立工程卡在该界面的时候，是因为在从网上下载gradle构建工具，耐心等待（需要网络环境良好）；

![img](android_work1.assets/clip_image038-169505270981024.jpg)

AndroidStudio项目创建和配置成功。

4.下面，我们生成APK文件

![img](android_work1.assets/clip_image040-169505270981025.jpg)

 

![img](android_work1.assets/clip_image042-169505270981127.jpg)

![img](android_work1.assets/clip_image044-169505270981126.jpg)

生成apk文件之后，导出该apk文件到模拟器或者真机上面进行安装，运行效果图如下

![http://files.jb51.net/file_images/article/201711/2017111310000236.png](android_work1.assets/clip_image045-169505270981128.png)

至此，Android Studio的安装以及开发环境就配置好了。

5.配置原生模拟器

（1）进入BIOS开启VT技术

![img](android_work1.assets/clip_image047-169505270981129.jpg)

![img](android_work1.assets/clip_image049-169505270981130.jpg)

 

 电脑型号不一，开启方法可自行百度

（2）设置禁止驱动程序强制签名

 

![img](android_work1.assets/clip_image051-169505270981131.jpg)

 ![img](file:///C:/Users/SQUARES/AppData/Local/Temp/msohtmlclip1/01/clip_image052.png)

![img](file:///C:/Users/SQUARES/AppData/Local/Temp/msohtmlclip1/01/clip_image053.png)

 ![img](file:///C:/Users/SQUARES/AppData/Local/Temp/msohtmlclip1/01/clip_image054.png)

（3）打开项目创建虚拟设备

![img](android_work1.assets/clip_image056-169505270981135.jpg)

![img](android_work1.assets/clip_image058-169505270981137.jpg)

 ![img](android_work1.assets/clip_image060-169505270981136.jpg)

如提示安装HAXM，那就默认安装。

![img](android_work1.assets/clip_image062-169505270981139.jpg)

启动后出现手机模拟器

 

![img](android_work1.assets/clip_image064-169505270981138.jpg)

建项目发布到模拟器上

![img](android_work1.assets/clip_image066-169505270981140.jpg)

6.其他模拟器配置

原生模拟器比较繁琐，还有不少兼容错误，如配置不出来可选其他模拟器

（1）   雷电、夜神、蓝叠、海马玩

（2）   genimotion（专业模拟器）