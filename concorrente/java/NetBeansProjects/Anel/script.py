import os

n_threads = {2000000, 1000000, 500000, 100000, 50000, 10000, 5000, 1000}
n_msgs = {1000, 100, 50, 10}

# for i in n_threads:
#     print(i)
#     for j in n_msgs:
#         print("\t", j)
#         comando = "time java -jar 'dist/Anel.jar' "+ str(i) + " " +  str(j) + " oi"
#         print(comando)
#         os.system(comando)

tempo = os.popen('time java -jar dist/Anel.jar 10000 50 oi').read()
print(tempo)
