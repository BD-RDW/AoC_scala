#!/bin/bash

read -p "Enter year (i.e.: y2015)    " year
read -p "Enter day number (I.e.: 02) " day

workDir=src/main/scala
echo package ${year} > ${workDir}/${year}/day${day}_1.scala
echo >> ${workDir}/${year}/day${day}_1.scala
sed "s/xx/${day}/" ${workDir}/dayxx_1.scala >> ${workDir}/${year}/day${day}_1.scala
#cp src/main/scala/dayxx_1.scala src/main/scala/$1/day$2_1.scala

workDir=src/test/scala
echo package ${year} > ${workDir}/${year}/day${day}_1Test.scala
echo >> ${workDir}/${year}/day${day}_1Test.scala
sed "s/dayxx_1\./${year}.day${day}_1./; s/dayxx_1Test/day${day}_1Test/" ${workDir}/dayxx_1Test.scala >> ${workDir}/${year}/day${day}_1Test.scala
#cp src/test/scala/dayxx_1Test.scala src/test/scala/$1/day$2_1Test.scala
#import dayxx_1.{calculate}
#import y2015.day04_1.