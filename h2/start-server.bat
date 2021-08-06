
java -cp h2-1.4.200.jar org.h2.tools.Server -baseDir ./data/ -ifNotExists -tcp -tcpAllowOthers -tcpPort 9090  -web -webAllowOthers  -webPort 9500 -tcpShutdownForce -browser
pause
