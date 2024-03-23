### 酒店管理系统
## 一、	介绍
酒店管理系统主要用来给顾客提供预定房间、查看价格等事宜，整个系统包括管理员和顾客两种身份，不同的身份进入不同的界面，在界面中进行一些操作，可以给顾客和酒店带来很大的便利。
## 二、	分析
# 1、	顾客方面
①	可以通过注册信息之后登录到酒店管理系统，也可以随时退出管理系统
②	可以在里面可以对房间进行预定，预定之后预定信息会展现在我的订单里面
③	可以查看个人信息，也可以修改个人信息，修改个人信息之后会跳到登录页面要求顾客重新登录
④	可以对房间进行模糊查询，也可以通过房间类型、价格等进行筛选
# 2、	管理员方面
①	可以登录到酒店管理系统，也可以随时退出管理系统
②	可以对任意一个房型进行增房，减房，以及改房
③	可以添加新的房型
④	可以对房间进行模糊查询，也可以通过房型、价格等进行筛选
⑤	可以查看个人信息，也可以修改个人信息，修改个人信息之后会跳到登录页面要求管理员重新登录
⑥	可以查看每一位顾客的信息，并且能够删除顾客的信息
⑦	可以查看每一位顾客预定房间的信息
## 三、	主要界面
# 1、	登录界面
①	顾客登录页面
②	管理员登录页面
③	顾客注册页面
# 2、	顾客界面
①	顾客首页页面
②	预约房间页面
③	个人信息页面
④	修改个人信息页面
⑤	我的订单页面
# 3、	管理员界面
①	管理员首页页面
②	新增房型页面
③	查看顾客信息页面
④	查看顾客预定房间信息页面
⑤	个人信息页面
⑥	修改个人信息页面
## 四、	数据库表
# 1、	顾客表
管理员表	
列名	数据类型	长度	主键	注释
id	varchar	50	是	编号
username	int	50	否	管理员用户名
password	varchar	50	否	管理员密码
isRoot	int	50	否	是否登录

# 2、	管理员表
顾客表	
列名	数据类型	长度	主键	注释
id	varchar	50	是	编号
username	int	50	否	管理员用户名
password	varchar	50	否	管理员密码
isRoot	int	50	否	是否登录
telephone	varchar	50	否	电话号
gender	varchar	50	否	性别
identity	varchar	50	否	身份证号
is_delete	varchar	1	否	是否删除

# 3、	房间表
房间表	
列名	数据类型	长度	主键	注释
id	bigint	50	是	编号
roomImage	varchar	50	否	房间图片
price	decimal	50	否	房间价格
type	varchar	50	否	房间类型
state	bigint	50	否	房间状态
des	varchar	255	否	房间描述
peopleNumber	int	50	否	可住人数
bedNumber	int	50	否	床位数
sumRoom	varchar	50	否	房间总数
reserveRoom	bigint	50	否	预定房间数
id_delete	bigint	1	否	是否被删除

# 4、	预定房间信息表
预定房间信息表	
列名	数据类型	长度	主键	注释
id	bigint	50	是	编号
userid	varchar	50	否	用户编号
bookingTime	decimal	50	否	预定时间
leaveTime	varchar	50	否	离店时间
roomImg	bigint	50	否	房间图片
type	varchar	255	否	房间类型
customerName	int	50	否	顾客名字
telephone	int	50	否	电话号
identity	varchar	50	否	身份证号
state	bigint	50	否	房间状态

