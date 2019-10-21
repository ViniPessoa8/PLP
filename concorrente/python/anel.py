import threading
import sys

data = sys.argv[3]

class Processo(threading.Thread):
    def __init__(self):
        threading.Thread.__init__(self)
        self.mensagem = ""

    def run(self):
        global data
        with lock:
            self.mensagem = data

lock = threading.Lock()
nProcessos = int(sys.argv[1])
nVoltas = int(sys.argv[2])
threads = []

for i in range(nProcessos):
    threads.append(Processo())

i = 0
while i < nVoltas:
    if i == 0:
        for t in threads:
            t.start()
    else:
        for t in threads:
            t.run()
    threads[i].join()
    i += 1

print("concluido")
