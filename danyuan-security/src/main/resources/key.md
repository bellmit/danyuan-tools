```
keytool -genkey -alias danyuan -dname "CN=wth,OU=danyuan,O=danyuan,L=baishan,ST=jilin,C=CN" -storetype PKCS12 -keyalg RSA -keysize 2048 -keystore keystore.p12 -validity 40000
  
  
  
命令的各个参数的含义：
 -genkey ：生成key；
 -alias ：key的别名；
 -dname：指定证书拥有者信息
 -storetype ：密钥库的类型为JCEKS。常用的有JKS(默认),JCEKS(推荐),PKCS12,BKS,UBER。每个密钥库只可以是其中一种类型。
 -keyalg ：DSA或RSA算法(当使用-genkeypair参数)，DES或DESede或AES算法(当使用-genseckey参数)；
 -keysize ：密钥的长度为512至1024之间(64的倍数)
 -keystore ：证书库的名称
 -validity ： 指定创建的证书有效期多少天
 
 dname的值详解：
  CN(Common Name名字与姓氏)
  OU(Organization Unit组织单位名称)
  O(Organization组织名称)
  L(Locality城市或区域名称)
  ST(State州或省份名称)
  C(Country国家名称）
  
  在目录：C:\Users\ 当前用户 下就会看到一个文件keystore.p12

#证书的路径.
server.ssl.key-store=classpath:keystore.p12
#证书密码，请修改为您自己证书的密码
server.ssl.key-store-password=123456
#秘钥库类型
server.ssl.keyStoreType=PKCS12
#证书别名
server.ssl.keyAlias=tomcat
```