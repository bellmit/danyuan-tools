#!/bin/sh
port1=9091;
port2=9092;
ip1=192.168.0.31;
ip2=192.168.0.31;

kill -9 $(lsof -i:${port1} |awk '{print $2}' | tail -n 2)  
kill -9 $(lsof -i:${port2} |awk '{print $2}' | tail -n 2)  

nohup java -cp h2-1.4.200.jar org.h2.tools.Server -baseDir /home/java/h2/data/data1/ -ifNotExists -tcp -tcpAllowOthers -tcpPort ${port1}  -web -webAllowOthers  -webPort 9501 -tcpShutdownForce  >/dev/null 2>&1 &

nohup java -cp h2-1.4.200.jar org.h2.tools.Server -baseDir /home/java/h2/data/data2/ -ifNotExists -tcp -tcpAllowOthers -tcpPort ${port2}  -web -webAllowOthers  -webPort 9502 -tcpShutdownForce  >/dev/null 2>&1 &

nohup java -cp h2-1.4.200.jar org.h2.tools.CreateCluster  -urlSource "jdbc:h2:tcp://${ip1}:${port1}/data" -urlTarget "jdbc:h2:tcp://${ip2}:${port2}/data" -user "sa" -serverList "${ip1}:${port1},${ip2}:${port2}" >/dev/null 2>&1 &

