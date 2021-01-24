CREATE TABLE `picturelistindex` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `listid` int(11) NOT NULL COMMENT '图片列表id',
  `listname` varchar(255) COMMENT '图片列表名',
  `listindex` int(11) NOT NULL COMMENT '图片列表下标',
  `productid` int(11) DEFAULT NULL COMMENT '产品id',
  `createdate` datetime NOT NULL COMMENT '数据创建日期',
  `updatedate` datetime NOT NULL COMMENT '数据更新日期',
  PRIMARY KEY (`id`,`listid`,`listindex`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `product` (
  `productid` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增 产品id',
  `productclass1` varchar(255) DEFAULT NULL COMMENT '一级分类',
  `productclass2` varchar(255) DEFAULT NULL COMMENT '二级分类',
  `productclass3` varchar(255) DEFAULT NULL COMMENT '三级分类',
  `productname` varchar(255) NOT NULL COMMENT '产品名称',
  `picturename` varchar(255) DEFAULT NULL COMMENT '产品图片名',
  `picturepath` varchar(255) DEFAULT NULL COMMENT '产品图片路径',
  `createdate` datetime NOT NULL COMMENT '数据创建日期',
  `updatedate` datetime NOT NULL COMMENT '数据更新日期',
  PRIMARY KEY (`productid`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `code` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
  `codetype` varchar(255) NOT NULL COMMENT '代码类型',
  `codename` varchar(255) NOT NULL COMMENT '代码名称',
  `code` varchar(255) NOT NULL COMMENT '代码',
  `createdate` datetime NOT NULL COMMENT '数据创建日期',
  `updatedate` datetime NOT NULL COMMENT '数据更新日期',
  PRIMARY KEY (`id`,`codetype`,`codename`,`code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `userName` varchar(255) NOT NULL,
  `passWord` varchar(255) NOT NULL,
  `userGroup` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8