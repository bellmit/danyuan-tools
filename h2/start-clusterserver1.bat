
java -cp h2-1.4.200.jar org.h2.tools.Server -baseDir ./data/data1/ -ifNotExists -tcp -tcpAllowOthers -tcpPort 9091  -web -webAllowOthers  -webPort 9501 -tcpShutdownForce -browser
pause
