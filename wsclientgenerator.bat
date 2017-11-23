@echo off

"C:\Program Files\Java\jdk1.8.0_121\bin\wsimport.exe" -s src/main/java -p at.technikumwien.sksue.generated -Xnocompile http://localhost:8080/sksuebung/FirstWebService?wsdl

pause