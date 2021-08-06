
java -cp h2-1.4.200.jar org.h2.tools.CreateCluster  -urlSource "jdbc:h2:tcp://localhost:9091/data" -urlTarget "jdbc:h2:tcp://localhost:9092/data" -user "sa" -serverList "localhost:9091,localhost:9092"
pause
