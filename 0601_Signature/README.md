### 1.APK签名方式的区别

|签名方式|兼容版本|保护对象|
|----|----|----|
|V1签名|基于Jar的签名，全版本|保护Zip中的文件|
|V2签名|Android 7.0出现|保护整个apk(除特殊区域外)的字节数据|
|V3签名|Android 9.0出现 |保护整个apk(除特殊区域外)的字节数据|

### 2.META-INFO文件夹

- MANIFEST.MF
- CERT.SF 存放了MANIFEST.MF
- CERT.RSA 使用RSA加密获取CERT.SF文件的摘要信息，并使用公钥进行加密，并把公钥信息也一起放入此文件中

[签名信息](https://source.android.google.cn/security/apksigning/v2)