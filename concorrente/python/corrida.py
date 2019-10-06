import threading
import time
import random
import sys

def animacao(tempo):
    ani = "|/-\\"
    for i in range(tempo):
        time.sleep(0.05)
        sys.stdout.write("\r" + ani[i % len(ani)])
        sys.stdout.flush()

class Corredor(threading.Thread):
    resultado = []
    def __init__(self, nome):
        threading.Thread.__init__(self)
        self.nome = nome
        self.resultado = []
    
    def run(self):
        random.seed(time.time())
        tempo = random.uniform(2, 5)
        time.sleep(tempo)
        animacao(int(tempo))
        self.resultado.append(tempo*1000.0)
    
    def retornarResultado(self):
        return sum(self.resultado)

threads = []

joao = Corredor("João")
maria =  Corredor("Maria")
felipe = Corredor("Felipe")
carlos = Corredor("Carlos")
daniela = Corredor("Daniela")

threads.append(joao)
threads.append(maria)
threads.append(felipe)
threads.append(carlos)
threads.append(daniela)

for t in threads:
    t.start()
for t in threads:
    t.join()

print(" volta completa")

for i in range(0, 9):
    for t in threads:
        t.run()
    for t in threads:
        t.join()
    print(" volta completa")

menorTempo = []

for t in threads:
    print("Nome: ", t.nome)
    print("Resultado (em ms): ", t.retornarResultado())
    menorTempo.append(t.retornarResultado())

print("Menor tempo: ", min(menorTempo))

