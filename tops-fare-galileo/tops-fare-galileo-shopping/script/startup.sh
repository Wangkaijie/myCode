#!/bin/sh
basepath=`cd $(dirname $0)/..; pwd`
hostip=`cat /data/etc/local/ip |cut  -d'=' -f2`
mainclass="com.travelzen.fare.galileo.shopping.server.GalileoShoppingServer"
JAVA_OPTS="-Djava.rmi.server.hostname=$hostip -Dcom.sun.management.jmxremote.port=4491 -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=false"

start() {
	test -d /data/log/tops || mkdir /data/log/tops

	vm_args=''
	if [ -f $basepath/vm_args ]; then
		vm_args=$(cat $basepath/vm_args|sed 's/^\s*\|\s*$//g')
	fi
	java $vm_args -classpath $basepath/lib/*:$basepath/conf $JAVA_OPTS $mainclass >> /data/log/tops/tops_fare_galileo_shopping_out.log 2>&1 &
	echo "$!" > $basepath/pid
}

stop() {
	kill -9 `cat $basepath/pid`
}

restart(){
	stop
	start
}

usage(){
	echo "syntax error!"
	echo "Usage:"
	echo "$(basename $0) start|stop|restart"
}

if [ $# != 1 ]; then
	usage; exit 1;
fi

case $1 in
	start)    start;;
	stop)     stop;;
	restart)  restart;;
	*)        usage;;
esac
