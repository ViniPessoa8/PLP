
nThreads[0]=1000
nThreads[1]=5000
nThreads[2]=10000
nThreads[3]=50000
nThreads[4]=100000
nThreads[5]=500000
nThreads[6]=1000000
nThreads[7]=2000000
nThreads[8]=3000000

nMsgs[0]=10
nMsgs[1]=50
nMsgs[2]=100
nMsgs[3]=100

i=0
j=0

for i in nThreads; do
    for j in nMsgs; do
    echo "$(i) Threads, $(j) Mensagens. "
        time java -jar "/dist/Anel.jar" i j oi
	done
done
