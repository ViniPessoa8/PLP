import sys

num = []
permutacoes = []

#Lê parâmetros
n = int(sys.argv[1])
nomeArq = sys.argv[2]

#Abre o arquivo
arq = open(nomeArq)

#Lê os valores do arquivo
cont = 0
texto = arq.readlines()
for linha in texto:
    cont += 1
    num.append(int(linha))


def troca(vet, a, b):
    aux = vet[a]
    vet[a] = vet[b]
    vet[b] = aux

def perm(vet):    
    if len(vet) == 0: return [] 
    if len(vet) == 1: return [vet] 
    
    aux = []
    
    for i in range(len(vet)):
        value = vet[i]
        for j in perm(vet[:i] + vet[i+1:]):
            aux.append([value] + j)          
    
    return aux

if (cont == n):
    print(perm(num))
else :
    print("Entrada inválida.")
