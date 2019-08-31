#include<stdio.h>
#include<stdlib.h>

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

void realCombGenerico(int* list,int tam, int step, int* listToPrint, int tamListToPrint) {
    

    if(step == 1){
        for (int i = 0; i < tam; i++) {
            if (arrayHasItem(listToPrint, tamListToPrint, list[i]) == 1) {
                continue;
            }
            int* aux = (int *)  malloc(sizeof(int) * (tamListToPrint + 1));
            for (size_t j = 0; j < tamListToPrint; j++){
                aux[j] = listToPrint[j];
            }
            
            aux[tamListToPrint] = list[i];
            imprimeVet(aux, tamListToPrint);

            free(aux);
        }
    }else if (step > 1){
        // imprimeVet(list, tam);
        for (int i = 0; i < tam; i++) {
            if(step + i > tam) break;
            
            int* aux = (int *)  malloc(sizeof(int) * (tamListToPrint + 1));
            for (size_t j = 0; j < tamListToPrint; j++){
                aux[j] = listToPrint[j];
            }
            aux[tamListToPrint] = list[i];
            
            realCombGenerico(subArray(list, i + 1, tam), tam-1-i, step - 1, aux, tamListToPrint+1);
        }
    }
}

void combGenerico(int vet[],int tam, int step){
    
    if(step == 1){
        for (size_t i = 0; i < tam; i++){
            printf("[%d]\n", vet[i]);
        }
        
    }else if (step > 1){
        for (int i = 0; i < tam; i++) {
            if(step + i > tam) break;
            int aux[1] = {vet[i]};

            realCombGenerico(subArray(vet, i+1, tam), tam-i-1, step - 1, aux, 1);
        }
    }
    
}    

int main(int argc, char *argv[]){

    //Leitura dos parâmetros
    int n = atoi(argv[1]);
    int k = atoi(argv[2]);
    FILE* arqEntrada = fopen(argv[3], "r");

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
        combGenerico(vet, n, k);
    } else {
        printf("Entrada inválida.\n");
    }

    return 0;
}

// void comb(int vet[], int len){


//     for (int i = 0; i < len; i++) {
//         for (int j = i; j < len; j++) {
//             if(vet[i] == vet[j]) continue;
//             printf("(%d, %d)", vet[i], vet[j]);
//         }
//     }
// }   
