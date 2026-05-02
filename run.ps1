Remove-Item -Recurse -Force out
mkdir out
javac -cp dependencies/antlr-4.13.2-complete.jar -d out -sourcepath src (Get-ChildItem -Path src -Recurse -Filter "*.java" | Where-Object { $_.FullName -notlike "*\.antlr*" } | Select-Object -ExpandProperty FullName)
java -cp "out;dependencies/antlr-4.13.2-complete.jar" Main