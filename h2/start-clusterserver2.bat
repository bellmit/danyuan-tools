
java -cp h2-1.4.200.jar org.h2.tools.Server -baseDir ./data/data2/ -ifNotExists -tcp -tcpAllowOthers -tcpPort 9092  -web -webAllowOthers  -webPort 9502 -tcpShutdownForce -browser
pause
