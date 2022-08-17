mkdir -p target

#compiling source code
javac -d ./target src/java/edu/school21/printer/*/*.java   

#starting program
java -classpath target edu.school21.printer.app.Program 0 . /Users/fhyman/Desktop/Piscine_java/day04/ex00/ImagesToChar/it.bmp 