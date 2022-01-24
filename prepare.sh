#!/bin/bash

gitRepo=false

read -p "Enter year (i.e.: y2015)    " year
read -p "Enter day number (I.e.: 02) " day

git status >> /dev/null 2>&1
if [ $? -eq 0 ] ; then
  gitRepo=true
fi

mainDir=src/main/scala
testDir=src/test/scala

echo package ${year} > ${mainDir}/${year}/day${day}_1.scala
echo >> ${mainDir}/${year}/day${day}_1.scala
sed "s/dayxx_input/${year}\/day${day}_input/; s/xx/${day}/" ${mainDir}/dayxx_1.scala >> ${mainDir}/${year}/day${day}_1.scala
echo > ${mainDir}/${year}/day${day}_input.txt

echo package ${year} > ${testDir}/${year}/day${day}_1Test.scala
echo >> ${testDir}/${year}/day${day}_1Test.scala
sed "s/dayxx_1\./${year}.day${day}_1./; s/dayxx_1Test/day${day}_1Test/" ${testDir}/dayxx_1Test.scala >> ${testDir}/${year}/day${day}_1Test.scala

if [ "${gitRepo}" == "true" ] ; then
  git add ${mainDir}/${year}/day${day}_input.txt ${mainDir}/${year}/day${day}_1.scala ${testDir}/${year}/day${day}_1Test.scala >> /dev/null 2>&1
fi