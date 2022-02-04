## Advent Of Code

This project is a personal project to learn more about using Scala.

For this I used the [advent of code](https://adventofcode.com/2021) to have nice and diverse assignments.

## points to note

Each assignment (for one day) is in one scala executable and it's functionality is tested using unittests. 
To quickly setup the classes/files for an assignment I have added the prepare.sh script. 
It will ask for the year and day and add the 2 files in the 2 directories.

I started putting the input in the Scala class, but found that large input data makes IntelliJ start using a lot of CPU (up to 100%).
Closing the scala file stopped that cpu usage, so at some point I started putting the input into a separate file named <scala class name>_input.txt

Added IntcodeComputer class (y2019)
