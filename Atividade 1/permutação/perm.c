#include <stdio.h>
#include <stdlib.h>

void troca(int* x, int* y) 
{ 
    int aux; 
    aux = *x; 
    *x = *y; 
    *y = aux; 
}

int* subArray(int* vet, int init, int fin){
    int* vetToReturn = (int *) malloc(sizeof(int) * (fin - init));

    for (size_t i = init, j=0; i < fin; i++, j++){
        vetToReturn[j]=vet[i];
    }
    
    return vetToReturn;
}

int arrayHasItem(int* vet, int tam, int item){
    for (size_t i = 0; i < tam; i++){
        if(vet[i] == item) return 1; 
    }
    return 0;
}

void addItemToArray(int* vet, int tam, int item){
    vet =(int *) realloc(vet, sizeof(int) * (tam+1));
    vet[tam] = item;
}

void imprimeVet(int* vet, int tam){
    if(tam > 0){
        printf("[%d", vet[0]);
        for (int i = 1; i <= tam; i++){
            printf(", %d", vet[i]);
        }
        printf("]\n");

    }
}

void permuta(int* vet, int inic, int fim){

    if (inic == fim){
        imprimeVet(vet, fim);
    } else { 
        for (int i = inic; i <= fim; i++) { 
            troca(&vet[inic], &vet[i]); 
            permuta(vet, inic + 1, fim); 
            troca(&vet[inic], &vet[i]);
        } 
    } 

}

int main (int argc, char *argv[]){

    //Leitura dos parâmetros
    int n = atoi(argv[1]);
    FILE* arqEntrada = fopen(argv[2], "r");

    int lCont = 0;
    size_t tam = 100;
    char* linha = malloc(tam*sizeof(char));
    
    //Alocação e preenchimento do vetor
    int* vet = malloc(n*sizeof(int));

    // Leitura do arquivo de entrada
    if (arqEntrada){
        while (!feof(arqEntrada)){
            if(fgets(linha, tam, arqEntrada)){
                vet[lCont++] = atoi(linha);
            }
        }
    }


    if (lCont == n){
        permuta(vet, 0, n-1);
    } else {
        printf("Entrada inválida.\n");
    }

    return 0;
}