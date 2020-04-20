#!/bin/bash
#Hakan Cetinkaya 21099

while getopts c:d: flag
do
case "${flag}" in
	c) character=${OPTARG};;
	d) file=${OPTARG};;
esac
done
for word in $file
do
cat $file | grep ^$character
done
exit












