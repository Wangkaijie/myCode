#/bin/bash

selfpath=$(cd "$(dirname "$0")"; pwd)
tops=$(cd "$(dirname "$selfpath/../../..")"; pwd)
bin=$tops/script/deployer_zip.py
lastarg="-n"
if [ -z $1 ]; then
    lastarg=""
fi

$bin -t $tops -s /home/tops-fare-galileo/apps/tops-fare-galileo-shopping -p tops-fare-galileo/tops-fare-galileo-shopping -r test --host 192.168.162.31 -u root -a Abc12345 -bin startup.sh $lastarg
