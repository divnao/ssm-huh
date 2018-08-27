# SSM考核--19800--胡浩

## 1. 数据库配置
1. 配置文件: resource目录下的`beans.xml`
2. 数据库为: `sakila`
3. 配置数据库用户和密码: 该文件`第45行`和`第46行`, 如下:

![](http://wx4.sinaimg.cn/mw690/0060lm7Tly1fuocjpklggj30ez010q2t.jpg)

## 2. 项目启动

1. 配置tomcat,无需项目名等其他路径，如下:

   ![](https://i.loli.net/2018/08/27/5b83e9e53b6ed.png)

   

   2. 点击运行tomcat;
   3. 浏览器输入: `localhost:8080/`或者`localhost:8080/index.html`均可进入系统登录页(首页)．

## 3. 项目使用

### 3.1 用户登录
1. 输入用户名和密码

   >用户名: `sakila.customoer`表的`first_name`字段值．
   >密码: `sakila.customoer`表的`last_name`字段值．

2. 点击登录

   ![](http://wx1.sinaimg.cn/mw690/0060lm7Tly1fuocxfpwq9j310p0jrq81.jpg)

3. 用户名密码错误, 无法进入系统, 系统始终出于登录页面

4. 用户或密码为空，提示＂用户或密码为空＂

   ![](http://wx1.sinaimg.cn/mw690/0060lm7Tly1fuocxfpwq9j310p0jrq81.jpg)



### 3.2 客户管理

   1. 成功登录后，进入客户管理页面，　页面右上角显示当前用户，并提供＂退出＂系统功能；

      ![](http://wx4.sinaimg.cn/mw690/0060lm7Tly1fuod1wnsumj310p0jqgpk.jpg)

   2. 点击左侧＂Customer 管理＂, 系统将回到客户管理第1页;

   3. 点击左侧＂Film管理＂, 提示＂正在开发中...＂;

      ![](http://wx3.sinaimg.cn/mw690/0060lm7Tly1fuod4ky124j310n0jqjvl.jpg)

   4. 点击＂编辑＂按钮，出现＂编辑客户＂模态框, 默认填充了将要修改的用户的原始信息，修改之后点击＂提交＂，

      将出现＂修改结果＂；

      点击编辑按钮:

      ![](http://wx2.sinaimg.cn/mw690/0060lm7Tly1fuod7nh89aj310k0jvaea.jpg)

      修改信息:

      ![](http://wx2.sinaimg.cn/mw690/0060lm7Tly1fuoda9z38lj310q0jp0wx.jpg)

      点击提交:

      ![](http://wx4.sinaimg.cn/mw690/0060lm7Tly1fuodbbryt6j310v0js78f.jpg)

      修改结果:

      ![](http://wx1.sinaimg.cn/mw690/0060lm7Tly1fuodd75d1pj30z702k3ym.jpg)

      5. 点击删除(当前点击的时用户id为10的按钮)：

         提示：　是否确定删除

         ![](http://wx1.sinaimg.cn/mw690/0060lm7Tly1fuodguplx3j310r0jttcx.jpg)

         点击确定, 提示删除结果(外键异常，无法删除)

         ![](https://i.loli.net/2018/08/27/5b83c5292dfc5.png)

         删除新加入的客户信息：

         ![](https://i.loli.net/2018/08/27/5b83c5716aaba.png)

         删除效果：

         ![](https://i.loli.net/2018/08/27/5b83c59de5e0e.png)

      6. 新增用户，点击新增按钮，出现＂新增用户＂模态框；

         ![](https://i.loli.net/2018/08/27/5b83c356a60a8.png)
      
         新增成功：
      
         ![](https://i.loli.net/2018/08/27/5b83c5f8c1e51.png)
      
          7. 分页查看，点击列表左下角的按钮，进行页码选择；
      
          8. 退出系统，　点击右上角＂退出＂，即退出系统．
