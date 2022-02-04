## first exam ##
### prepare manifest ###
`$ echo Main-Class: ua.com.alevel.Main>MANIFEST.MF`
### run compile ###
`$ javac -sourcepath ./src -d build/classes -cp ./libs/commons-lang3-3.11.jar src/ua/com/alevel/test/Test.java src/ua/com/alevel/Main.java`
### prepare jar output ###
`$ mkdir -p build/jar`
### extract libs classes to `build/classes` ###
`$ cd build/classes`
<br />
`$ jar xf ../../libs/commons-lang3-3.11.jar org`
<br />
`$ cd ../../`
### create jar file ###
`$ jar cfm build/jar/HelloWorld.jar MANIFEST.MF -C build/classes/ .`


## second exam ##
### prepare manifest ###
`$ echo Class-Path: commons-lang3-3.11.jar Main-Class: ua.com.alevel.Main>MANIFEST.MF`
### run compile ###
`$ javac -sourcepath ./src -d build/classes -cp ./libs/commons-lang3-3.11.jar src/ua/com/alevel/test/Test.java src/ua/com/alevel/Main.java`
### prepare jar output ###
`$ mkdir -p build/jar`
### create jar file and copy all libs###
`$ jar cfm build/jar/HelloWorld.jar MANIFEST.MF -C build/classes/ .`
<br />
`$ cp libs/commons-lang3-3.11.jar build/jar`


### Run program ###
`$ java -jar build/jar/HelloWorld.jar`