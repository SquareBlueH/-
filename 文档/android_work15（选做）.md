**实验15 数据存储**

 

**一、准备知识**

 

在Android应用中存储数据的主要三种方式：SharedPreferences，内部存储和外部SD卡存储。在实际应用中应该采用那种方式呢？

\1.  如果你有键值对形式的数据，使用SharedPreferences对象。举个例子，如果你想存储用户的一些属性，比如名字，肤色，生日或最后的登陆日期，那么SharedPreferences对象就是存储这些数据的最佳方式。其本质就是一个xml文件，常用于存储较简单的参数设置。

 

\2.   如果你想存储某些特殊的数据，需要去使用传统的文件系统去保存数据，那么使用内部存储将是一个好的选择。例如你可能想要去保存一篇文章，而这篇文章要被展示在你的应用中。也有可能，你要存储用户自己创建的数据，比如用户保存他自己写的一些笔记之类的。

在Android系统中，你也可以使用java.io包去实现这个功能。在Android系统中，第一种保存文件的方法是存储到内部设备。

 

\3.   有些时候，你需要和其他用户共享你的应用数据。举个例子，你可能会开发这样一种软件，它去记录用户曾经去过的地方的坐标，同时，你也能把这些数据与其他用户共享。这种情况下，把你的文件保存到SD卡上，因为SD卡具有更大的存储空间，同时也可以很容易的和其他用户分享这些文件。这样一来，就可以很容易地把这些数据传送给其他的设备，以便以后的使用。

 

 

**二、作业** 

1、 创建4个窗口：MainActivity、SHActivity、ISActivity和ESActivity。为MainActivity的添加radiobutton和button，在button的onclick事件添加代码，使得用户在选择radiobutton时，能够跳转到下一个目标窗口。

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image002.jpg)

 

2、实现键值存储例子。

（1）编辑SHActivity窗口，将界面设计如下。

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image004.jpg)

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image006.jpg)

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image008.jpg)

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image010.jpg)

 (2)为SHActivity.java添加代码：

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image012.jpg)

 

 

 

 

在按钮事件中定义一个SharedPreferences类的实例settings，将数据储存其中。

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image014.jpg)

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image016.jpg)

 

 

编写载入方法，读取settings中储存的数据

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image018.jpg)

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image020.jpg)![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image022.jpg)

 

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image024.jpg)

3、实现内部存储例子。

（1）编辑ISActivity窗口，将界面设计如下。

 

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image026.jpg)

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image028.jpg)![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image030.jpg)

(2)为ISActivity.java添加代码：

在保存按钮事件中使用传统文件读写的方法，创建一个note.txt文件。

在追加按钮事件中使用传统文件读写的方法，在note.txt文件后追加内容。

 

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image032.jpg)

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image034.jpg)

 

 

 

 

 

在打开按钮事件中使用传统文件读写的方法和stringbuilder，将note.txt文件的内容显示。

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image036.jpg)

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image038.jpg)

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image040.jpg)

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image042.jpg)![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image044.jpg)

使用文件设备管理器里我们可以找到该文件，但在真机上由于安全性考虑，我们没有该权限，所以可能找不到。此文件会随程序卸载一起删除。

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image046.jpg)

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image048.jpg)

 

4、实现外部存储例子。

（1）编辑ESActivity窗口，将界面设计如下。

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image050.jpg)

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image052.jpg) ![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image054.jpg)

(2)在Manifest.xml为读写SD卡添加权限添加代码：

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image056.jpg)

(3)将图片素材photo.png加入资源文件

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image058.jpg)

(4)为ESActivity.java添加代码：

在公有区按钮事件中获取公有区照片文件夹路径，并在那里创建图片文件。

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image060.jpg)

在私有区按钮事件中获取私有区照片文件夹路径，并在那里创建图片文件。

 

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image062.jpg)

创建图片文件代码

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image064.jpg)

判断SD卡是否挂载和扫描刷新媒体文件的代码

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image066.jpg)

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image068.jpg)![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image070.jpg)

使用DDMS我们可以找到该文件，私有照片区的图片会随程序卸载一起删除，公有区则不会。

![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image072.jpg) ![img](android_work15%EF%BC%88%E9%80%89%E5%81%9A%EF%BC%89.assets/clip_image074.jpg)