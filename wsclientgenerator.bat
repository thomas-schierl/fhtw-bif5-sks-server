@echo off

"C:\Program Files\Java\jdk1.8.0_121\bin\wsimport.exe" -Xauthfile auth -s src\main\java -p at.technikumwien.sksue.generated -Xnocompile http://localhost:8080/sksuebung/MovieWebService?wsdl

pause