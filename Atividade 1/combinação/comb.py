import sys

num = []
permutacoes = []

#Lê parâmetros
n = int(sys.argv[1])
k = int(sys.argv[2])
nomeArq = sys.argv[3]

#Abre o arquivo
arq = open(nomeArq)

#Lê os valores do arquivo
cont = 0
texto = arq.readlines()
for linha in texto:
    cont += 1
    num.append(int(linha))

def comb(vet, passo, vet_print = []):
        
    if passo == 1 : 
        for i in range(len(vet)): 
            if vet_print.__contains__(vet[i]): continue
            print(vet_print + [vet[i]])
    else:
        for i in range(len(vet)):
            if i + passo > len(vet): break
            aux = vet_print + [vet[i]]
            comb(vet[i+1:], passo-1, aux) 

comb(num, k)