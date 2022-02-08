@echo compile program
call javac -sourcepath ./src -d build/classes -cp ./libs/commons-lang3-3.12.0.jar src/ua/com/alevel/test/Test.java src/ua/com/alevel/Main.java

@echo run program
call java -cp build/classes/;./libs/commons-lang3-3.12.0.jar ua.com.alevel.Main

@echo create jar
call jar cfm build/jar/main.jar MANIFEST.MF -C build/classes/ .
call copy .\libs\commons-lang3-3.12.0.jar .\build\jar

@echo run jar
java -jar .\build\jar\main.jar
